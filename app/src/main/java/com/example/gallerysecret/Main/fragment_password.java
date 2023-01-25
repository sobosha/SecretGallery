package com.example.gallerysecret.Main;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gallerysecret.MainActivity;
import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomFragment;
import com.example.gallerysecret.Setting.IAnimationEnd;
import com.example.gallerysecret.Setting.Setting;
import com.example.gallerysecret.Setting.mAnimation;
import com.example.gallerysecret.Setting.mLocalData;

import io.alterac.blurkit.BlurLayout;

public class fragment_password extends CustomFragment {
    TextView number1, number2, number3, number4, number5, number6, number7, number8, number9, number0, Ok, Delete, textEnterPass, DialogAlertText, forgotPassword,passwordError;
    EditText Password;
    RelativeLayout Dialog;
    boolean showDialog = false;
    BlurLayout blurLayout;

    @Override
    public int layout() {
        return R.layout.fragment_password;
    }

    String CheckPass = "0";

    public void setCheckPass(String checkPass) {
        CheckPass = checkPass;
    }

    @Override
    public void onCreateMyView() {
        passwordError=parent.findViewById(R.id.password_error);
        forgotPassword = parent.findViewById(R.id.forgotPassword);
        Dialog = parent.findViewById(R.id.DialogPassword);
        textEnterPass = parent.findViewById(R.id.textview_EnterPassword);
        if (!mLocalData.getLoggedIn(getContext())) {
            textEnterPass.setText("کلمه عبور خود را ایجاد کنید");
            forgotPassword.setVisibility(View.GONE);
            passwordError.setVisibility(View.VISIBLE);
        }
        if(!CheckPass.equals("0")){
            textEnterPass.setText("کلمه عبور را تکرار کنید");
            forgotPassword.setVisibility(View.GONE);
            passwordError.setVisibility(View.GONE);
        }
        number0=parent.findViewById(R.id.number0);
        number1=parent.findViewById(R.id.number1);
        number2=parent.findViewById(R.id.number2);
        number3=parent.findViewById(R.id.number3);
        number4=parent.findViewById(R.id.number4);
        number5=parent.findViewById(R.id.number5);
        number6=parent.findViewById(R.id.number6);
        number7=parent.findViewById(R.id.number7);
        number8=parent.findViewById(R.id.number8);
        number9=parent.findViewById(R.id.number9);
        Ok=parent.findViewById(R.id.PasswordOk);
        Delete=parent.findViewById(R.id.deleteNumber);
        Password=parent.findViewById(R.id.edittext_password);
        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(Password.getText().toString().length()>=4 && passwordError.getText().equals("بیشتر از 4 رقم")){
                    passwordError.setTextColor(Color.parseColor("#3cc611"));
                }
                else{
                    passwordError.setTextColor(Color.parseColor("#fa3f2e"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number0, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number0.clearAnimation();

                        Password.setText(Password.getText().toString()+"0");
                    }
                });

            }
        });
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number1, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number1.clearAnimation();

                        Password.setText(Password.getText().toString()+"1");
                    }
                });

            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number2, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number2.clearAnimation();

                        Password.setText(Password.getText().toString()+"2");
                    }
                });

            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number3, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number3.clearAnimation();

                        Password.setText(Password.getText().toString()+"3");
                    }
                });

            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number4, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number4.clearAnimation();

                        Password.setText(Password.getText().toString()+"4");
                    }
                });

            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number5, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number5.clearAnimation();

                        Password.setText(Password.getText().toString()+"5");
                    }
                });

            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number6, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number6.clearAnimation();

                        Password.setText(Password.getText().toString()+"6");
                    }
                });

            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number7, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number7.clearAnimation();

                        Password.setText(Password.getText().toString()+"7");
                    }
                });

            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number8, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number8.clearAnimation();
                        Password.setText(Password.getText().toString()+"8");
                    }
                });

            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(number9, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        number9.clearAnimation();
                        Password.setText(Password.getText().toString()+"9");
                    }
                });

            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(Delete, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        Delete.clearAnimation();
                        if(Password.getText().toString().length()>0)
                            Password.setText(Password.getText().toString().substring(0,Password.getText().length()-1));

                    }
                });
                }
        });
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Setting.OnAnimationEnd(mAnimation.townScaleMiddleCustom(Ok, 1, 1, 0.7f, 0.7f, 0, 50), new IAnimationEnd() {
                    @Override
                    public void TheEnd() {
                        Ok.clearAnimation();
                        if (CheckPass.equals("0")) {
                            if (mLocalData.getLoggedIn(getContext())) {
                                if(mLocalData.getPassword(getContext()).equals(Password.getText().toString())){
                                    MainActivity.getGlobal().FinishFragStartFrag(new fragment_menu());
                                }
                                else{
                                    passwordError.setText("پسورد اشتباه است");
                                    passwordError.setVisibility(View.VISIBLE);

                            /*if(!showDialog){
                                Dialog.addView(new Dialog(getContext(),R.layout.dialog_password));
                                DialogAlertText=parent.findViewById(R.id.textview_ِDialogPass);
                                DialogAlertText.setText("پسورد اشتباه است");
                                showDialog=true;
                                parent.findViewById(R.id.btn_exit_DialogPass).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Dialog.removeAllViews();
                                        showDialog=false;
                                    }
                                });
                            }*/
                                }
                            } else {
                                if (Password.getText().toString().length() >= 4) {
                                    fragment_password fragPass = new fragment_password();
                                    fragPass.setCheckPass(Password.getText().toString());
                                    MainActivity.getGlobal().FinishFragStartFrag(fragPass);
                                }
                                else{
                                    passwordError.setText("بیشتر از 4 رقم");
                                    passwordError.setVisibility(View.VISIBLE);

                            /*if(!showDialog){
                            Dialog.addView(new Dialog(getContext(),R.layout.dialog_password));
                            DialogAlertText=parent.findViewById(R.id.textview_ِDialogPass);
                            DialogAlertText.setText("رمز باید بین 4 تا 6 رقم باشد");
                            showDialog=true;
                            parent.findViewById(R.id.btn_exit_DialogPass).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Dialog.removeAllViews();
                                    showDialog=false;
                                }
                            });
                            }*/
                                }
                            }
                        }
                        else{
                            if(Password.getText().toString().equals(CheckPass)){
                                fragment_question fragment_question=new fragment_question();
                                fragment_question.setPassword(CheckPass);
                                MainActivity.getGlobal().FinishFragStartFrag(fragment_question);
                            }
                            else{
                                passwordError.setTextColor(Color.parseColor("#fa3f2e"));
                                passwordError.setText("تکرار رمز اشتباه است");
                                passwordError.setVisibility(View.VISIBLE);
                        /*if(!showDialog){
                        Dialog.addView(new Dialog(getContext(),R.layout.dialog_password));
                        DialogAlertText=parent.findViewById(R.id.textview_ِDialogPass);
                        DialogAlertText.setText("تکرار رمز اشتباه است");
                        showDialog=true;
                        parent.findViewById(R.id.btn_exit_DialogPass).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Dialog.removeAllViews();
                                    showDialog=false;
                                }
                            });
                        }*/
                            }
                        }
                    }
                });

            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mLocalData.getLoggedIn(getContext()))
                    MainActivity.getGlobal().FinishFragStartFrag(new fragment_question());
                else
                    Toast.makeText(getContext(), "شما تا به حال وارد نشده اید", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void mBackPressed() {
        super.mBackPressed();
        if(!CheckPass.equals("0")){
            MainActivity.getGlobal().FinishFragStartFrag(new fragment_password());
        }
        if(showDialog){
            Dialog.removeAllViews();
            showDialog=false;
        }
        else if(!showDialog){
            Dialog.addView(new Dialog(getContext(), R.layout.dialogexit));
            showDialog=true;
            dialog();
        }

    }

    private void dialog() {
        TextView exit,noExit;
        noExit=parent.findViewById(R.id.btn_exit_No);
        exit=parent.findViewById(R.id.btn_exit_Yes);
        blurLayout=parent.findViewById(R.id.blurlayuot);
        noExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.removeAllViews();
                showDialog=false;
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getGlobal().finish();
            }
        });
        blurLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog.removeAllViews();
                showDialog=false;
            }
        });
    }
}
