package com.finance.personal.vitt;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    FloatingActionButton bt5;
   // EditText et6,et7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bt5=findViewById(R.id.floatingButton);
       // et6=findViewById(R.id.editText8);
       // et7=findViewById(R.id.editText9);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ib = new Intent(ProfileActivity.this , HomeActivity.class);
                startActivity(ib);
            }
        });

       // int total=Integer.parseInt(et6.getText().toString());
        // int limit=Integer.parseInt(et7.getText().toString());
    }
}
