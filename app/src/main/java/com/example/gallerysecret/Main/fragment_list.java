package com.example.gallerysecret.Main;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.Core.bzResponce;
import com.example.gallerysecret.Core.shopResult2;
import com.example.gallerysecret.ImageCompresor.IImageCompressTaskListener;
import com.example.gallerysecret.ImageCompresor.ImageCompressTask;
import com.example.gallerysecret.Main.DataBase.AppDatabaseImage;
import com.example.gallerysecret.Main.DataBase.AppDatabaseVideo;
import com.example.gallerysecret.Main.DataBase.ImageDao;
import com.example.gallerysecret.Main.DataBase.ImageEntity;
import com.example.gallerysecret.Main.DataBase.VideoDao;
import com.example.gallerysecret.Main.DataBase.VideoEntity;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.MarketPurchase;
import com.example.gallerysecret.MarketResult;
import com.example.gallerysecret.PurchaseEvent;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomAdapter;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.IAnimationEnd;
import com.example.gallerysecret.Setting.Presenter;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mAnimation;
import com.example.gallerysecret.Setting.mLocalData;
import com.example.gallerysecret.Setting.nValue;
import com.example.gallerysecret.Setting.reqBuy;
import com.example.gallerysecret.Setting.reqBuyResult;
import com.example.gallerysecret.Setting.shop_item;
import com.example.gallerysecret.StoreParent;
import com.example.gallerysecret.shoping;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.alterac.blurkit.BlurLayout;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class fragment_list extends CustomFragment implements StoreParent {
    Context context;
    String type = "";
    List<ImageEntity> images;
    List<VideoEntity> videos;
    ImageView floatingActionButton,floatingActionButton2;
    AppDatabaseImage appDatabaseImage;
    AppDatabaseVideo appDatabaseVideo;
    ImageDao imageDao;
    VideoDao videoDao;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    TextView Nulltext;
    ImageEntity restore;
    VideoEntity restorevideo;
    Bitmap bitmapSend;
    public RelativeLayout Dialog,status;
    BlurLayout blurLayout;
    StoreParent storeParent;
    ProgressBar progressBarPardakht;
    static fragment_list Instance;
    public static boolean showDialog = false;
    boolean oneItem=false;
    public void setRestorevideo(VideoEntity restorevideo) {
        this.restorevideo = restorevideo;
    }

    ImageCompressTask imageCompressTask;

    public void setRestore(ImageEntity restore) {
        this.restore = restore;
    }

    static final int SELECT_PICTURES = 8;
    static final int SELECT_VIDEO = 9;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(1);

    public void setType(String type) {
        this.type = type;
    }

    public static fragment_list getInstance(){
        return Instance;
    }

    @Override
    public int layout() {
        return R.layout.fragment_list;
    }

    @Override
    public void onCreateMyView() {
        Instance=this;
        status=MainActivity.getGlobal().findViewById(R.id.top_status);
        status.setVisibility(View.VISIBLE);
        Dialog = parent.findViewById(R.id.Dialog_pardakht);
        if(!mLocalData.getSigns(getContext())){
            Dialog.addView(new DialogDesc(getContext(), "اولین عکسی که حذف می شود در برخی از گوشی ها در گالری همچنان نشان داده می شود که با انتخاب عکس دوم عکس اول هم حذف می شود", new IDescDialog() {
                @Override
                public void Ok() {
                    Dialog.removeAllViews();
                    mLocalData.setSigns(getContext(),true);
                }
            }));
            parent.findViewById(R.id.blurlayuot).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog.removeAllViews();
                    mLocalData.setSigns(getContext(),true);
                }
            });
        }
        recyclerView = parent.findViewById(R.id.recycler_list);
        storeParent=this;
        context = getContext();
        images = new ArrayList<>();
        videos = new ArrayList<>();
        if (type.equals("image") || type.equals("restoreImage")) {
            appDatabaseImage = AppDatabaseImage.getInstance(context);
            imageDao = appDatabaseImage.imageDao();
            ((TextView)MainActivity.getGlobal().findViewById(R.id.title)).setText("لیست عکس های مخفی");
        } else if (type.equals("video") || type.equals("restorevideo")) {
            appDatabaseVideo = AppDatabaseVideo.getInstance(context);
            videoDao = appDatabaseVideo.videoDao();
            ((TextView)MainActivity.getGlobal().findViewById(R.id.title)).setText("لیست ویدیو های مخفی");
        }
        floatingActionButton = parent.findViewById(R.id.floating_plus);
        floatingActionButton2 = parent.findViewById(R.id.floating_plus2);
        Nulltext = parent.findViewById(R.id.textview_nullRec);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(floatingActionButton, 1, 1, 0.8f, 0.8f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        floatingActionButton.clearAnimation();
                        if(checkPermission()){
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            if (type.equals("image")) {
                                intent.setType("image/*");
                                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES);
                            } else if (type.equals("video")) {
                                intent.setType("video/*");
                                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent, "Select Video"), SELECT_VIDEO);

                            }
                        }
                        else{
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                                try {
                                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                                    intent.addCategory("android.intent.category.DEFAULT");
                                    intent.setData(Uri.parse(String.format("package:%s",context.getPackageName())));
                                    startActivityForResult(intent, 2296);
                                } catch (Exception e) {
                                    Intent intent = new Intent();
                                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                                    startActivityForResult(intent, 2296);
                                }
                            } else {
                                //below android 11
                                ActivityCompat.requestPermissions(MainActivity.getGlobal(), new String[]{WRITE_EXTERNAL_STORAGE}, 10);
                                MainActivity.getGlobal().setPermissionHandler(new PermissionTask() {
                                    @Override
                                    public void Allow() {
                                        Intent intent = new Intent(Intent.ACTION_PICK);
                                        if (type.equals("image")) {
                                            intent.setType("image/*");
                                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                                            intent.setAction(Intent.ACTION_GET_CONTENT);
                                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES);
                                        } else if (type.equals("video")) {
                                            intent.setType("video/*");
                                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                                            intent.setAction(Intent.ACTION_GET_CONTENT);
                                            startActivityForResult(Intent.createChooser(intent, "Select Video"), SELECT_VIDEO);

                                        }
                                    }

                                    @Override
                                    public void Deny() {
                                        Snackbar.make(getContext(),getView(),"برای ادامه کار به دسترسی نیاز داریم",Snackbar.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        }
                    }
                });
/*                Intent intent = new Intent(Intent.ACTION_PICK);
                if (type.equals("image")) {
                    intent.setType("image/*");
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES);
                } else if (type.equals("video")) {
                    intent.setType("video/*");
                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Video"), SELECT_VIDEO);

                }*/




            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(floatingActionButton2, 1, 1, 0.8f, 0.8f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        floatingActionButton2.clearAnimation();
                        clickOnFloating();
                    }
                });

            }
        });
/*        if(type.equals("restoreImage")){
            RestoreImage(restore);
        }*/
        if (type.equals("image")) {
            customAdapter = new CustomAdapter.RecyclerBuilder<ImageEntity, RecItem>(context, recyclerView, images)
                    .setView(() -> new RecItem(context, type))
                    .setBind((position, list, rel, selectItem, customAdapter) -> rel.imageitem(list.get(position), position, list.size()))
                    .build();
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
            ImageGet();
            if (restore != null) {
                mExecutorService.execute(new TaskHandlerThread(()->{},()->{RestoreImage(restore);}));
                //Toast.makeText(context, "حالا تو گالریت هست:)", Toast.LENGTH_SHORT).show();
            }
        } else if (type.equals("video")) {
            customAdapter = new CustomAdapter.RecyclerBuilder<VideoEntity, RecItem>(context, recyclerView, videos)
                    .setView(() -> new RecItem(context, type))
                    .setBind((position, list, rel, selectItem, customAdapter) -> rel.videoitem(list.get(position), position, list.size()))
                    .build();
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
            VideoGet();
            if (restorevideo != null) {
                mExecutorService.execute(new TaskHandlerThread(()->{},()->{RestoreVideo(restorevideo);}));
                //Toast.makeText(context, "حالا تو گالریت هست:)", Toast.LENGTH_SHORT).show();

            }

        }
    }

    int sizeOfVideo;
    int sizeOfImage;
    private ClipData videoClipData;
    private ClipData ImageClipData;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_PICTURES) {
            if (resultCode == Activity.RESULT_OK) {
                MainActivity.getGlobal().DialogShow();
                if (data.getClipData() != null) {
                    sizeOfImage = data.getClipData().getItemCount(); //evaluate the count before the for loop --- otherwise, the count is evaluated every loop.
                    ImageClipData=data.getClipData();
                    get=true;
                    oneItem=false;
                    forImage();

                    //do something with the image (save it to some directory or whatever you need to do with it here)
                } else if (data.getData() != null) {
                    if (images.size() > 3 && !mLocalData.getUserInfo(MainActivity.getGlobal())) {
                        MainActivity.getGlobal().DialogGone();
                        pardakht();
                    } else {
                        oneItem=true;
                        String imagePath = data.getData().getPath();
                        Log.d("Image Path2", imagePath);
                        fileDelete(data.getData(), "add");
                    }
                    //do something with the image (save it to some directory or whatever you need to do with it here)
                }
                //Toast.makeText(context, "دیگه تو گالریت نیست:)", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == SELECT_VIDEO) {
            if (resultCode == Activity.RESULT_OK) {
                MainActivity.getGlobal().DialogShow();
                if (data.getClipData() != null) {
                    sizeOfVideo = data.getClipData().getItemCount(); //evaluate the count before the for loop --- otherwise, the count is evaluated every loop.

                    videoClipData = data.getClipData();
                    oneItem=false;
                    get = true;
                    forVideo();
                    //do something with the image (save it to some directory or whatever you need to do with it here)
                } else if (data.getData() != null) {
                    if (videos.size() > 3 && !mLocalData.getUserInfo(MainActivity.getGlobal())) {
                        MainActivity.getGlobal().DialogGone();
                        pardakht();
                    } else {
                        get=false;
                        oneItem=true;
                        String imagePath = data.getData().getPath();
                        Log.d("Video Path2", imagePath);
                        fileDelete(data.getData(), "add");
                    }
                    //do something with the image (save it to some directory or whatever you need to do with it here)
                }
                //Toast.makeText(context, "دیگه تو گالریت نیست:)", Toast.LENGTH_SHORT).show();
            }

        }
        if(requestCode==2296){
            if(resultCode==Activity.RESULT_CANCELED){
                if(!checkPermission())
                    Snackbar.make(getContext(),MainActivity.getGlobal().getCurrentFragment().getView(),"برای ادامه کار به دسترسی نیاز داریم",Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private boolean get;
    private int primaryVideo;
    private int primaryImage;

    private void forVideo() {
        if (get) {
            if (videos.size() > 3 && !mLocalData.getUserInfo(MainActivity.getGlobal())) {
                MainActivity.getGlobal().DialogGone();
                pardakht();
            } else if(videoClipData.getItemAt(primaryVideo)!=null){
                Uri VideoUri = videoClipData.getItemAt(primaryVideo).getUri();
                String image = VideoUri.getPath();
                fileDelete(VideoUri, "add");
            }
        }
    }

    private void forImage() {
        if (get) {
            if (images.size() > 3 && !mLocalData.getUserInfo(MainActivity.getGlobal())) {
                MainActivity.getGlobal().DialogGone();
                pardakht();
            } else if(ImageClipData.getItemAt(primaryImage)!=null){
                Uri ImageUri = ImageClipData.getItemAt(primaryImage).getUri();
                String image = ImageUri.getPath();
                fileDelete(ImageUri, "add");
            }
        }
    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
        if (showDialog) {
            Dialog.removeAllViews();
            showDialog = false;
        }
        else
            MainActivity.getGlobal().FinishFragStartFrag(new fragment_menu());
    }

    public boolean copyOfFile(File orginalFile) {
        try {
            InputStream in = new FileInputStream(orginalFile);
            File copy = new File(context.getApplicationInfo().dataDir, orginalFile.getName());

            OutputStream out = new FileOutputStream(copy);
            byte[] buf = new byte[1024];


            long lenght = orginalFile.length();
            long j = 0;
            while (true) {
                int read = in.read(buf);
                if (read != -1) {
                    j += (long) read;
                    MainActivity.getGlobal().progressBarMain.setProgress(((int) ((100 * j) / lenght)));
                    out.write(buf, 0, read);
                } else {
                    in.close();
                    out.flush();
                    out.close();
                    break;
                }
            }



            /*int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }*/
            /*out.close();
            in.close();
            out.flush();*/
            if (type.equals("image")) {
                imageCompressTask = new ImageCompressTask(context, copy.getAbsolutePath(), iImageCompressTaskListener);
                ImageEntity temp = new ImageEntity();
                temp.setImage(copy.getAbsolutePath());
                temp.setImageorginalpath(orginalFile.getAbsolutePath());
                images.add(temp);
                mExecutorService.execute(imageCompressTask);
                mExecutorService.execute(new ImageSaver(context, appDatabaseImage, imageDao, temp));
            } else if (type.equals("video")) {
                VideoEntity temp = new VideoEntity();
                temp.setVideo(copy.getAbsolutePath());
                temp.setVideoorginalpath(orginalFile.getAbsolutePath());
                videos.add(temp);
                mExecutorService.execute(new VideoSaver(context, appDatabaseVideo, videoDao, temp));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri, projection,
                    selection, selectionArgs, null);

            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return null;
    }

    public void fileDelete(Uri uri, String Command) {
        Log.d("DialogMainStatus", String.valueOf(MainActivity.getGlobal().DialogMain.getVisibility()));
        get = false;
        MainActivity.getGlobal().DialogShow();
        mExecutorService.execute(new TaskHandlerThread(() -> {
            MainActivity.getGlobal().progressBarMain.setProgress(0);
            MainActivity.getGlobal().DialogGone();
            if(type.equals("video") && !oneItem) {
                primaryVideo++;
                if (sizeOfVideo != primaryVideo) {
                    get = true;
                    forVideo();
                }
                else{
                    primaryVideo=0;
                    primaryVideo=0;
                }
            }
            if(type.equals("image") && !oneItem) {
                primaryImage++;
                if (sizeOfImage != primaryImage) {
                    get = true;
                    forImage();
                }
                else{
                    primaryImage=0;
                }
            }
            oneItem=false;
            Log.d("DialogMainStatus", String.valueOf(MainActivity.getGlobal().DialogMain.getVisibility()));
        }, () -> {
            final String docId;
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    docId = DocumentsContract.getDocumentId(uri);
                    final String[] split = docId.split(":");
                    //final String type = split[0];
                    Uri contentUri = null;
                    if ("image".equals(type)) {
                        contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(type)) {
                        contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    }
                    String selection = "_id=?";
                    String[] selectionArgs = new String[]{split[1]};


                    String temp = getDataColumn(context, contentUri, selection,
                            selectionArgs);
                    File file = new File(temp);
                    if (Command.equals("add"))
                        copyOfFile(file);
                    if (file.exists()) {
                        if (file.delete()) {
                            // Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                            MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                        } else {
                            //Toast.makeText(context, "not Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                    MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                } catch (Throwable e) {
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = MainActivity.getGlobal().getContentResolver().query(uri,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    File file = new File(cursor.getString(cursor.getColumnIndex(filePathColumn[0])));
                    if (Command.equals("add"))
                        copyOfFile(file);
                    if (file.exists()) {
                        if (file.delete()) {
                            //Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                            MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                            if (file.exists()) {
                                //Toast.makeText(context, "Exist", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                }

            } else if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    /*if (type.equals("image")) {
                        ImageGet();

                    } else if (type.equals("video")) {
                        VideoGet();

                    }*/


                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = MainActivity.getGlobal().getContentResolver().query(uri,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    File file = new File(cursor.getString(cursor.getColumnIndex(filePathColumn[0])));
                    if (Command.equals("add"))
                        copyOfFile(file);
                    if (file.exists()) {
                        if (file.delete()) {
                            //Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                            MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
                            if (file.exists()) {
                                //Toast.makeText(context, "Exist", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
/*                    MainActivity.getGlobal().progressBarMain.setProgress(0);
                    MainActivity.getGlobal().DialogGone();*/
                }
            if (type.equals("image")) {
                ImageGet();

            } else if (type.equals("video")) {
                VideoGet();

            }

        }));


    }
    String sku="";
    RelativeLayout cost;
    TextView textCost;
    private void pardakht() {
        Dialog.removeAllViews();
        DialogPardakht d=new DialogPardakht(getContext());
        Dialog.addView(d);
        d.Pardkht(Dialog,status);
        /*getBz();
        Dialog.removeAllViews();
        Dialog.addView(new Dialog(context, R.layout.dialogpardakht, this));
        status.setVisibility(View.INVISIBLE);
        cost=parent.findViewById(R.id.cost);
        textCost=parent.findViewById(R.id.textview_Cost);
        if(Setting.isNetworkConnect()) {
            parent.findViewById(R.id.progress_cost).setVisibility(View.VISIBLE);
            Presenter.get_global().PostAction(new IView<shopResult2>() {
                @Override
                public void SendRequest() {

                }

                @Override
                public void OnSucceed(shopResult2 object) {
                    shop_itemChild = object.getData().get(0);

                    if (takhfifValue == 0)
                        sku = shop_itemChild.getType() + "-" + shop_itemChild.getQuantity();
                    else
                        sku = shop_itemChild.getType() + "-" + shop_itemChild.getQuantity() + "-" + takhfifValue;

                    parent.findViewById(R.id.progress_cost).setVisibility(View.GONE);
                    cost.setVisibility(View.VISIBLE);
                    textCost.setText(shop_itemChild.getPrice()+"");

                }

                @Override
                public void OnError(String error, int statusCode) {
                    Toast.makeText(context, error + "...." + statusCode, Toast.LENGTH_SHORT).show();
                }
            }, "shop", "getItem", "", new shoping("gallery"), shopResult2.class);
        }else Toast.makeText(context, "اینترنت خود را متصل کنید", Toast.LENGTH_SHORT).show();

            TextView btn_pardakht = parent.findViewById(R.id.btn_pardakht);
            TextView btn_noPardakht = parent.findViewById(R.id.btn_No_pardakht);
            btn_noPardakht.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Dialog.removeAllViews();
                    showDialog = false;
                    status.setVisibility(View.VISIBLE);
                }
            });
            btn_pardakht.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        if(Setting.isNetworkConnect()){
                            Presenter.get_global().PostAction(new IView<shopResult2>() {
                                @Override
                                public void SendRequest() {

                                }

                                @Override
                                public void OnSucceed(shopResult2 object) {
                                    shop_itemChild = object.getData().get(0);

                                    if (takhfifValue == 0)
                                        sku = shop_itemChild.getType() + "-" + shop_itemChild.getQuantity();
                                    else
                                        sku = shop_itemChild.getType() + "-" + shop_itemChild.getQuantity() + "-" + takhfifValue;
                                    cost.setVisibility(View.VISIBLE);
                                    textCost.setText(shop_itemChild.getPrice()+"");
                                    MarketPurchase.BuyMarket(sku, bz + "", offCode, new PurchaseEvent() {
                                        @Override
                                        public void NormalPay() {
                                            GotoPayGate(shop_itemChild.getId(), storeParent, 0);

                                        }

                                        @Override
                                        public void SuccessPay(MarketResult result) {
                                            onSuccedBuy();
                                        }

                                        @Override
                                        public void ErrorPay() {
                                            Toast.makeText(context, "eeeeee", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }

                                @Override
                                public void OnError(String error, int statusCode) {
                                    Toast.makeText(context, error + "...." + statusCode, Toast.LENGTH_SHORT).show();
                                }
                            }, "shop", "getItem", "", new shoping("gallery"), shopResult2.class);

                        }
                        else
                            Toast.makeText(context, "اینترنت را متصل کنید", Toast.LENGTH_SHORT).show();

                    *//*else {
                        try{
                            MarketPurchase.BuyMarket(sku, bz + "", offCode, new PurchaseEvent() {
                                @Override
                                public void NormalPay() {
                                    GotoPayGate(shop_itemChild.getId(), storeParent, 0);

                                }

                                @Override
                                public void SuccessPay(MarketResult result) {
                        *//**//*Dialog.removeAllViews();
                        showDialog = false;
                        status.setVisibility(View.VISIBLE);*//**//*
                                    onSuccedBuy();
                                }

                                @Override
                                public void ErrorPay() {

                                }
                            });
                        }catch (Throwable e){
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }*//*
//                if(mLocalData.getToken(context).equals("")){
//
//                }


                }
            });
            blurLayout = parent.findViewById(R.id.blurlayuot);
            blurLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog.removeAllViews();
                    showDialog = false;
                    status.setVisibility(View.VISIBLE);
                }
            });*/


    }

    public void ImageGet() {
        ImageGetter imageGet = new ImageGetter(imageDao, new IUpdateUi() {
            @Override
            public void update(List<ImageEntity> imageEntities) {
                images.clear();
                images.addAll(imageEntities);
                customAdapter.notifyDataSetChanged();
                if (images.size() > 0) {
                    Nulltext.setVisibility(View.GONE);
                    floatingActionButton2.setVisibility(View.GONE);
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
            }
        });
        mExecutorService.execute(imageGet);
    }

    public void VideoGet() {
        VideoGetter videoGet = new VideoGetter(videoDao, new IUpdateUiVideo() {
            @Override
            public void update(List<VideoEntity> videoEntities) {
                videos.clear();
                videos.addAll(videoEntities);
                if (videos.size() > 0) {
                    Nulltext.setVisibility(View.GONE);
                    floatingActionButton2.setVisibility(View.GONE);
                    floatingActionButton.setVisibility(View.VISIBLE);
                }
                customAdapter.notifyDataSetChanged();
            }
        });
        mExecutorService.execute(videoGet);
    }

    public boolean RestoreImage(ImageEntity copyFile) {
        try {

            File copy = new File(copyFile.getImage());
            InputStream in = new FileInputStream(copy);
            File orginal = new File(copyFile.getImageorginalpath());
            orginal.createNewFile();

            OutputStream out = new FileOutputStream(orginal);
            byte[] buf = new byte[1024];
            long lenght = copy.length();
            long j = 0;
            while (true) {
                int read = in.read(buf);
                if (read != -1) {
                    j += (long) read;
                    MainActivity.getGlobal().progressBarMain.setProgress(((int) ((100 * j) / lenght)));
                    out.write(buf, 0, read);
                } else {
                    in.close();
                    out.flush();
                    out.close();
                    break;
                }
            }
            /*int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.flush();
            out.close();*/
            if (orginal.exists()) {
                if (copy.delete()) {
                    //Toast.makeText(context, "بازگردانی شد", Toast.LENGTH_SHORT).show();
                }
            }
            images.remove(copyFile);
            MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(orginal)));
            mExecutorService.execute(new ImageRestore(imageDao, copyFile, new IUpdateUi() {
                @Override
                public void update(List<ImageEntity> imageEntities) {
                    images.clear();
                    images.addAll(imageEntities);
                    customAdapter.notifyDataSetChanged();
                    if (images.size() > 0) {
                        Nulltext.setVisibility(View.GONE);
                        floatingActionButton2.setVisibility(View.GONE);
                        floatingActionButton.setVisibility(View.VISIBLE);
                    } else {
                        Nulltext.setVisibility(View.VISIBLE);
                        floatingActionButton2.setVisibility(View.VISIBLE);
                        floatingActionButton.setVisibility(View.GONE);
                    }
                    MainActivity.getGlobal().DialogGone();
                    MainActivity.getGlobal().sendBroadcast(new Intent(
                            Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                            Uri.parse(orginal.getAbsolutePath())));
                }
            }));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean RestoreVideo(VideoEntity copyFile) {
        try {
            File copy = new File(copyFile.getVideo());
            InputStream in = new FileInputStream(copy);
            File orginal = new File(copyFile.getVideoorginalpath());
            orginal.createNewFile();
            OutputStream out = new FileOutputStream(orginal);
            byte[] buf = new byte[1024];

            long lenght = copy.length();
             long j= 0;
            while (true) {
                int read = in.read(buf);
                if (read != -1) {
                    j += (long) read;
                    MainActivity.getGlobal().progressBarMain.setProgress(((int) ((100 * j) / lenght)));
                    out.write(buf, 0, read);
                } else {
                    in.close();
                    out.flush();
                    out.close();
                    break;
                }
            }

            /*int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
            out.flush();*/
            if (orginal.exists()) {
                if (copy.delete()) {

                }
            }
            videos.remove(copyFile);
            MainActivity.getGlobal().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(orginal)));
            mExecutorService.execute(new VideoRestore(videoDao, copyFile, new IUpdateUiVideo() {
                @Override
                public void update(List<VideoEntity> videoEntities) {
                    videos.clear();
                    videos.addAll(videoEntities);
                    customAdapter.notifyDataSetChanged();
                    if (videos.size() > 0) {
                        Nulltext.setVisibility(View.GONE);
                        floatingActionButton2.setVisibility(View.GONE);
                        floatingActionButton.setVisibility(View.VISIBLE);
                    } else {
                        Nulltext.setVisibility(View.VISIBLE);
                        floatingActionButton2.setVisibility(View.VISIBLE);
                        floatingActionButton.setVisibility(View.GONE);
                    }
                    MainActivity.getGlobal().DialogGone();
                }
            }));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    private final IImageCompressTaskListener iImageCompressTaskListener = new IImageCompressTaskListener() {
        @Override
        public void onComplete(List<File> compressed) {
            File file = compressed.get(0);
            bitmapSend = BitmapFactory.decodeFile(file.getAbsolutePath());
        }

        @Override
        public void onError(Throwable error) {

        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        mExecutorService.shutdown();
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            int result = 0;
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                result = context.checkSelfPermission(READ_EXTERNAL_STORAGE);
                int result1 = context.checkSelfPermission(WRITE_EXTERNAL_STORAGE);
                return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
            }
        }
        return true;
    }

    private void clickOnFloating(){
        floatingActionButton.clearAnimation();
        if(checkPermission()){
            Intent intent = new Intent(Intent.ACTION_PICK);
            if (type.equals("image")) {
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES);
            } else if (type.equals("video")) {
                intent.setType("video/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Video"), SELECT_VIDEO);

            }
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                try {
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s",context.getPackageName())));
                    startActivityForResult(intent, 2296);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    startActivityForResult(intent, 2296);
                }
            } else {
                //below android 11
                ActivityCompat.requestPermissions(MainActivity.getGlobal(), new String[]{WRITE_EXTERNAL_STORAGE}, 10);
                MainActivity.getGlobal().setPermissionHandler(new PermissionTask() {
                    @Override
                    public void Allow() {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        if (type.equals("image")) {
                            intent.setType("image/*");
                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES);
                        } else if (type.equals("video")) {
                            intent.setType("video/*");
                            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(intent, "Select Video"), SELECT_VIDEO);

                        }
                    }

                    @Override
                    public void Deny() {
                        Snackbar.make(getContext(),getView(),"برای ادامه کار به دسترسی نیاز داریم",Snackbar.LENGTH_SHORT).show();
                    }
                });
            }

        }
    }

    shop_item shop_itemChild;
    int takhfifValue=0;
    String offCode="";
    @Override
    public void onSuccedBuy() {
        Toast.makeText(context, "Market Pay", Toast.LENGTH_SHORT).show();
        mLocalData.setUserInfo(getContext(),true);
    }

    @Override
    public void onErrorBuy() {
        pardakht();
        Toast.makeText(context, "error market pay", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHideDialog() {

    }

    public void GotoPayGate(int id, StoreParent storeParent, final int gate) {
        Presenter.get_global().PostAction(new IView<reqBuyResult>() {
            @Override
            public void SendRequest() {
                GotoPayGate(id, storeParent, gate);
            }

            @Override
            public void OnSucceed(reqBuyResult object) {
                //((mProgress) findViewById(R.id.mProgress)).onSucceed();
                storeParent.onHideDialog();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(object.getUrl()));
                getContext().startActivity(browserIntent);
                Dialog.removeAllViews();
                showDialog = false;
                status.setVisibility(View.VISIBLE);
            }

            @Override
            public void OnError(String error, int statusCode) {
                //((mProgress) findViewById(R.id.mProgress)).onSucceed();
                if (gate == 0)
                    GotoPayGate(id, storeParent, 1);

            }
        }, "shop", "buy", "", new reqBuy(id + "", offCode, gate), reqBuyResult.class);

    }

    int bz ;
    public void getBz(){
        Presenter.get_global().GetAction(new IView<bzResponce>() {
            @Override
            public void SendRequest() { }
            @Override
            public void OnSucceed(bzResponce object) {
                bz=object.getBz();
                //setData(result);
                Toast.makeText(context, bz+"", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void OnError(String error, int statusCode) {
                Toast.makeText(context, "Bz nagereft", Toast.LENGTH_SHORT).show();
                //MainActivity.getGlobal().showSnackBar("reject", "مشکلی پیش امده.عزیزم مجددا تلاش کن ", 2500);
            }
        } , "users" , "getBz" , "" , bzResponce.class);
    }


}
