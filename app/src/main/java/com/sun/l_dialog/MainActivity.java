package com.sun.l_dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlertDialog, btnDialog;
    private View dlgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertDialog = (Button) findViewById(R.id.btn_alert_dialog);
        btnDialog = (Button) findViewById(R.id.btn_dialog);

        btnAlertDialog.setOnClickListener(this);
        btnDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alert_dialog:
                showAlertDialog();
                break;
            case R.id.btn_dialog:
                showDialog();
                break;
        }
    }

    private void showAlertDialog() {
        dlgView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        final RadioGroup rg_hobby = dlgView.findViewById(R.id.rg_hobby);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("对话框")
                //.setMessage("这是一个测试对话框")
                .setView(dlgView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, ((RadioButton) dlgView.findViewById
                                (rg_hobby.getCheckedRadioButtonId())).getText().toString(), Toast
                                .LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .create();
        alertDialog.show();
    }

    private void showDialog() {
        MyDlg myDlg=new MyDlg(this);
        myDlg.show();
    }
}
