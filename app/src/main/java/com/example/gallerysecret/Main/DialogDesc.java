package com.example.gallerysecret.Main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.gallerysecret.R;
import com.example.gallerysecret.Setting.CustomClasses.CustomRel;

public class DialogDesc extends CustomRel {
    public DialogDesc(Context context,String Description,IDescDialog iDescDialog) {
        super(context, R.layout.dialog_desc);
        TextView Desc=findViewById(R.id.textview_descDiaolg);
        TextView Ok=findViewById(R.id.btn_ok);
        Desc.setText(Description);
        Ok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                iDescDialog.Ok();
            }
        });

    }


}
