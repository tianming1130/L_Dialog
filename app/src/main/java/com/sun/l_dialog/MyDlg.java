package com.sun.l_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by sun on 2017/11/23.
 */

public class MyDlg extends Dialog {

    Context context;
    public MyDlg(@NonNull Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dlg_layout);

        Button btnOk=(Button) findViewById(R.id.btn_ok);
        final RadioGroup rgHobby=(RadioGroup) findViewById(R.id.rg_hobby);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,((RadioButton) findViewById
                        (rgHobby.getCheckedRadioButtonId())).getText().toString(), Toast
                        .LENGTH_SHORT).show();
                MyDlg.this.dismiss();
            }
        });
    }
}
