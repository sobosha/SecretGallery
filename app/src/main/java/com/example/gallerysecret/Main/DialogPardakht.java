package com.example.gallerysecret.Main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gallerysecret.Core.DataModelResponse;
import com.example.gallerysecret.Core.IView;
import com.example.gallerysecret.Core.bzResponce;
import com.example.gallerysecret.Core.shopResult2;
import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.MarketPurchase;
import com.example.gallerysecret.MarketResult;
import com.example.gallerysecret.PurchaseEvent;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomRel;
import com.example.gallerysecret.Setting.Presenter;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mLocalData;
import com.example.gallerysecret.Setting.reqBuy;
import com.example.gallerysecret.Setting.reqBuyResult;
import com.example.gallerysecret.Setting.shop_item;
import com.example.gallerysecret.StoreParent;
import com.example.gallerysecret.shoping;
import com.google.android.material.snackbar.Snackbar;

import io.alterac.blurkit.BlurLayout;

public class DialogPardakht extends CustomRel implements StoreParent {
    int bz ;
    Context context;
    String sku="";
    RelativeLayout cost,status;
    TextView textCost;
    shop_item shop_itemChild;
    BlurLayout blurLayout;
    int takhfifValue=0;
    TextView btn_pardakht;
    String offCode="";
    RelativeLayout Dialog;
    boolean BuyClick=false;
    public DialogPardakht(Context context) {
        super(context, R.layout.dialogpardakht);
        this.context=context;
    }

    public void Pardkht(RelativeLayout Dialog,RelativeLayout status){
        btn_pardakht = MainActivity.getGlobal().findViewById(R.id.btn_pardakht);
        TextView btn_noPardakht = MainActivity.getGlobal().findViewById(R.id.btn_No_pardakht);
        status.setVisibility(View.INVISIBLE);
        cost=MainActivity.getGlobal().findViewById(R.id.cost);
        textCost=MainActivity.getGlobal().findViewById(R.id.textview_Cost);
        if(Setting.isNetworkConnect()) {
            if(mLocalData.getToken(MainActivity.getGlobal()).equals("")){
                Presenter.get_global().GetAction(new IView<DataModelResponse>() {
                    @Override
                    public void SendRequest() {

                    }

                    @Override
                    public void OnSucceed(DataModelResponse object) {
                        mLocalData.SetToken(MainActivity.getGlobal(), object.getData().getToken());
                        getBz();
                        //Toast.makeText(MainActivity.getGlobal(), mLocalData.getToken(MainActivity.getGlobal()), Toast.LENGTH_SHORT).show();
                        MainActivity.getGlobal().findViewById(R.id.progress_cost).setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void OnError(String error, int statusCode) {
                        //Toast.makeText(MainActivity.getGlobal(), "توکن نگرفت"+statusCode, Toast.LENGTH_SHORT).show();

                    }
                }, "users", "create", "1", DataModelResponse.class);
            }
            else{
                MainActivity.getGlobal().findViewById(R.id.progress_cost).setVisibility(View.VISIBLE);
                cost.setVisibility(View.INVISIBLE);
                getBz();
            }

        }else Snackbar.make(MainActivity.getGlobal().getCurrentFragment().getView(),"اینترنت خود را متصل کنید",1000).show();

        btn_noPardakht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog.removeAllViews();
                fragment_list.getInstance().showDialog = false;
                status.setVisibility(View.VISIBLE);
            }
        });
        btn_pardakht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Setting.isNetworkConnect()){
                    BuyClick=true;
                    findViewById(R.id.progress_btnBuy).setVisibility(VISIBLE);
                    btn_pardakht.setVisibility(GONE);
                    Presenter.get_global().GetAction(new IView<DataModelResponse>() {
                        @Override
                        public void SendRequest() {

                        }

                        @Override
                        public void OnSucceed(DataModelResponse object) {
                            mLocalData.SetToken(MainActivity.getGlobal(), object.getData().getToken());
                            getBz();

                        }

                        @Override
                        public void OnError(String error, int statusCode) {
                            //Toast.makeText(MainActivity.getGlobal(), "توکن نگرفت"+statusCode, Toast.LENGTH_SHORT).show();

                        }
                    }, "users", "create", "1", DataModelResponse.class);

                }
                else
                    Snackbar.make(MainActivity.getGlobal().getCurrentFragment().getView(),"اینترنت خود را متصل کنید",1000).show();
                    /*else {
                        try{
                            MarketPurchase.BuyMarket(sku, bz + "", offCode, new PurchaseEvent() {
                                @Override
                                public void NormalPay() {
                                    GotoPayGate(shop_itemChild.getId(), storeParent, 0);

                                }

                                @Override
                                public void SuccessPay(MarketResult result) {
                        *//*Dialog.removeAllViews();
                        showDialog = false;
                        status.setVisibility(View.VISIBLE);*//*
                                    onSuccedBuy();
                                }

                                @Override
                                public void ErrorPay() {

                                }
                            });
                        }catch (Throwable e){
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }*/
//                if(mLocalData.getToken(context).equals("")){
//
//                }


            }
        });
        blurLayout = MainActivity.getGlobal().findViewById(R.id.blurlayuot);
        blurLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.removeAllViews();
                fragment_list.getInstance().showDialog = false;
                status.setVisibility(View.VISIBLE);
            }
        });

    }


    public void getBz(){
        Presenter.get_global().GetAction(new IView<bzResponce>() {
            @Override
            public void SendRequest() { }
            @Override
            public void OnSucceed(bzResponce object) {
                bz=object.getBz();
                //setData(result);
                //Toast.makeText(context, bz+"", Toast.LENGTH_SHORT).show();
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

                        MainActivity.getGlobal().findViewById(R.id.progress_cost).setVisibility(View.GONE);
                        cost.setVisibility(View.VISIBLE);
                        textCost.setText(shop_itemChild.getPrice()+"");
                        if(BuyClick){
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
                                            GotoPayGate(shop_itemChild.getId(), DialogPardakht.this, 0);


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

                    }

                    @Override
                    public void OnError(String error, int statusCode) {
                        //Toast.makeText(context, error + "...." + statusCode, Toast.LENGTH_SHORT).show();
                    }
                }, "shop", "getItem", "", new shoping("gallery"), shopResult2.class);

            }
            @Override
            public void OnError(String error, int statusCode) {
                //Toast.makeText(context, "Bz nagereft", Toast.LENGTH_SHORT).show();
                //MainActivity.getGlobal().showSnackBar("reject", "مشکلی پیش امده.عزیزم مجددا تلاش کن ", 2500);
            }
        } , "users" , "getBz" , "" , bzResponce.class);
    }

    public void GotoPayGate(int id, StoreParent storeParent, final int gate) {
        Presenter.get_global().PostAction(new IView<reqBuyResult>() {
            @Override
            public void SendRequest() {
                GotoPayGate(id, storeParent, gate);
            }

            @Override
            public void OnSucceed(reqBuyResult object) {
                btn_pardakht.setVisibility(VISIBLE);
                findViewById(R.id.progress_btnBuy).setVisibility(GONE);
                //((mProgress) findViewById(R.id.mProgress)).onSucceed();
                storeParent.onHideDialog();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(object.getUrl()));
                getContext().startActivity(browserIntent);
                Dialog.removeAllViews();
                fragment_list.getInstance().showDialog = false;
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

    @Override
    public void onSuccedBuy() {

    }

    @Override
    public void onErrorBuy() {

    }

    @Override
    public void onHideDialog() {

    }
}
