package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Button checkStatusButton = findViewById(R.id.checkStatusButton);

        final EditText editTextCitizenID  = (EditText) findViewById(R.id.editTextCitizenID);

        checkStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = editTextCitizenID.getEditableText().toString();




//                int n = Integer.parseInt(msg);
                if(msg.length() != 13){
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    CharSequence text = "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    if(msg.equals("1111111111111") || msg.equals("2222222222222")){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(NextActivity.this);
                        dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                        dialog.setMessage("คุณเป็นมีผู้มีสิทธิเลือกตั้ง");
                        dialog.setPositiveButton("OK", null);

                        dialog.show();

                    }
                    else {
                        AlertDialog.Builder dialog = new AlertDialog.Builder(NextActivity.this);
                        dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                        dialog.setMessage("คุณไม่มีสิทธิเลือกตั้ง");
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });

                        dialog.show();
                    }
                }
            }
        });


    }
}