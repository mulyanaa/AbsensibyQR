package com.example.android.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Name3;

    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Name3 = (EditText)findViewById(R.id.etName3);

        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("Silahkan masukan nomer ruangan dan nama petugas");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Name3.getText().toString());
            }
        });
    }

    private void validate(String userName, String officer){
        if((!userName.equals("")) && (!officer.equals("")) ){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String room1 = userName;
            String officer1 = officer;
            intent.putExtra("dataroom",room1);
            intent.putExtra("dataofficer",officer1);
//            Bundle bundle = new Bundle();
//            bundle.putString("dataroom",room1);
//            getIntent(bundle)
            startActivity(intent);
        }else if ((!userName.equals("")) && (officer.equals(""))) {
            Info.setText("data petugas tidak boleh kosong");

        }
    else if ((userName.equals("")) && (!officer.equals(""))) {
            Info.setText("Input ruangan tidak boleh kosong");

    }
        else{

            Info.setText("Input ruangan dan petugas tidak boleh kosong");

//            if(counter == 0){
//                Login.setEnabled(false);
//            }
        }
    }

}


