package com.finance.personal.vitt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.finance.personal.vitt.SignupActivity.mAuth;

public class ProfileActivity extends AppCompatActivity {

    String email;
    FloatingActionButton bt5;
    EditText fullname,phonenos,budget,limit;
    CollectionReference db = FirebaseFirestore.getInstance().collection("UserData");
    FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        bt5=findViewById(R.id.floatingButton);

        currentUser = mAuth.getCurrentUser();
        email = currentUser.getEmail();
        fullname= findViewById(R.id.name);
        phonenos= findViewById(R.id.phonenos);
        budget= findViewById(R.id.totalbudget);
        limit= findViewById(R.id.limitbudget);

            bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> docData = new HashMap<>();

                docData.put("email", email);
                docData.put("full_name", fullname.getText().toString());
                docData.put("Phone_nos", phonenos.getText().toString());
                docData.put("Total_budget", budget.getText().toString());
                docData.put("Limit_budget", limit.getText().toString());

                db.document(email).set(docData).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.e("User ", "Data saved");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Error ", "Data Not Saved !");
                    }
                });

                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
            }
          });

       }
    }