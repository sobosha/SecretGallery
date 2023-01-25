package com.example.gallerysecret.Main;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomAdapter;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.IAnimationEnd;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mAnimation;
import com.example.gallerysecret.Setting.mLocalData;

import java.util.ArrayList;
import java.util.List;

import io.alterac.blurkit.BlurLayout;

public class fragment_question extends CustomFragment {
    TextView question,btn_next,showquest;
    EditText answer;
    RelativeLayout Dialog,relRec,questionClick;
    Spinner spinner_question;
    RecyclerView recQuestion;
    CustomAdapter customAdapter;
    BlurLayout blurLayout;
    ImageView Down,Up;
    List<Question> list;
    String[] question_text={"نام مدرسه دبیرستان","نام شهر محل سکونت","نام حیوان خانگی","گل مورد علاقه"};
    boolean showDialog=false;
    boolean showDialogOk=false;
    @Override
    public int layout() {
        return R.layout.fragment_question;
    }

    String Password="0";

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public void onCreateMyView() {
        list=new ArrayList<>();
        for(int i=0;i<question_text.length;i++){
            Question q=new Question();
            q.setQuestion(question_text[i]);
            list.add(q);
        }
        showquest=parent.findViewById(R.id.textview_showquestion);
        Down=parent.findViewById(R.id.spiner_down);
        Up=parent.findViewById(R.id.spiner_up);
        recQuestion=parent.findViewById(R.id.rec_question);
        questionClick=parent.findViewById(R.id.rel_click_question);
        relRec=parent.findViewById(R.id.rel_recyclerQuestion);
        btn_next=parent.findViewById(R.id.btn_next_question);
        question=parent.findViewById(R.id.textview_question);
        answer=parent.findViewById(R.id.Edittext_question);
        Dialog=parent.findViewById(R.id.DialogQuestion);
        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relRec.setVisibility(View.GONE);
                showquest.setText(question_text[MainActivity.getGlobal().position]);
            }
        });
        customAdapter = new CustomAdapter.RecyclerBuilder<Question, RecItem>(getContext(), recQuestion, list)
                .setView(() -> new RecItem(getContext(), "question"))
                .setBind((position, list, rel, selectItem, customAdapter) -> rel.question(list.get(position),position,relRec))
                .grid(1)
                .orientation(RecyclerView.VERTICAL)
                .build();
        if(Password.equals("0")){
            questionClick.setVisibility(View.GONE);
            question.setText(mLocalData.getName(getContext()));
            question.setVisibility(View.VISIBLE);


        }
        questionClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relRec.setVisibility(View.VISIBLE);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Password.equals("0")) {
                    if (answer.getText().toString().length() > 2) {
                        mLocalData.SetQues(getContext(), answer.getText().toString());
                        mLocalData.setLoggedIn(getContext(), true);
                        mLocalData.setPassword(getContext(), String.valueOf(Password));
                        mLocalData.setName(getContext(),question_text[MainActivity.getGlobal().position]);
                        Dialog.removeAllViews();
                        Dialog.setVisibility(View.VISIBLE);
                        Dialog.addView(new Dialog(getContext(),R.layout.dialogregistered));
                        showDialogOk=true;
                        ((TextView)parent.findViewById(R.id.btn_next)).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.getGlobal().FinishFragStartFrag(new fragment_menu());
                            }
                        });
                        blurLayout=parent.findViewById(R.id.blurlayuot);
                        blurLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                MainActivity.getGlobal().FinishFragStartFrag(new fragment_menu());
                            }
                        });
                    } else {
                        Dialog.addView(new Dialog(getContext(),R.layout.dialog_question));
                        showDialog=true;
                        TextView text=parent.findViewById(R.id.btn_exit_DialogQuestion);
                        TextView texttitle=parent.findViewById(R.id.textview_ِDialogQuestion);
                        texttitle.setText("پاسخ باید بیشتر از دو حرف باشد");
                        text.setText("دوباره وارد می کنم");
                        text.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Dialog.removeAllViews();
                                showDialog=false;
                            }
                        });
                        blurLayout=parent.findViewById(R.id.blurlayuot);
                        blurLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Dialog.removeAllViews();
                                showDialog=false;
                            }
                        });
                    }
                }
                else {
                    if(mLocalData.getQues(getContext()).equals(answer.getText().toString())){
                        Dialog.addView(new Dialog(getContext(),R.layout.dialog_question));
                        TextView text=parent.findViewById(R.id.btn_exit_DialogQuestion);
                        TextView textview=parent.findViewById(R.id.textview_ِDialogQuestion);
                        textview.setText("رمز عبور شما\n"+mLocalData.getPassword(getContext()));
                        hideSoftKeyboard(MainActivity.getGlobal());
                        text.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Setting.OnAnimationEnd(mAnimation.myFadeOut(Dialog, 0, 1000), new IAnimationEnd() {
                                    @Override
                                    public void TheEnd() {
                                        MainActivity.getGlobal().FinishFragStartFrag(new fragment_password());
                                    }
                                });
                            }
                        });


                    }
                    else{
                        Dialog.addView(new Dialog(getContext(),R.layout.dialog_question));
                        showDialog=true;
                        TextView text=parent.findViewById(R.id.btn_exit_DialogQuestion);
                        TextView texttitle=parent.findViewById(R.id.textview_ِDialogQuestion);
                        texttitle.setText("پاسخ اشتباه است");
                        text.setText("دوباره وارد می کنم");
                        text.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               Dialog.removeAllViews();
                                showDialog=false;
                            }
                        });
                        blurLayout=parent.findViewById(R.id.blurlayuot);
                        blurLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Dialog.removeAllViews();
                                showDialog=false;
                            }
                        });
                    }

                }
            }
        });
    }

    public  void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
        if(showDialog){
            Dialog.removeAllViews();
            showDialog=false;
        }
        else if(showDialogOk){
            MainActivity.getGlobal().FinishFragStartFrag(new fragment_menu());
        }
        else{
            MainActivity.getGlobal().FinishFragStartFrag(new fragment_password());
        }
    }
}
