package com.finance.personal.vitt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    Button bt3;
   // EditText et3,et4,et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        bt3= findViewById(R.id.btsign);

       // et3=(EditText)findViewById(R.id.editText3);
      //  et4=(EditText)findViewById(R.id.editText6);
      //  et5=(EditText)findViewById(R.id.editText7);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent is = new Intent(SignupActivity.this, ProfileActivity.class);
                startActivity(is);
            }
        });

      //  String email=et3.getText().toString();
       // String password=et3.getText().toString();
       // String confirmedPass=et3.getText().toString();


    }
}
