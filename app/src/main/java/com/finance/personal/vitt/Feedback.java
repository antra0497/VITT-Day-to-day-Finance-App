package com.finance.personal.vitt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Feedback extends Fragment {

    Button send;
    EditText to,sub,mesg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feedback,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        send=(Button)view.findViewById(R.id.fsend);
        to=(EditText)view.findViewById(R.id.Eto);
        sub=(EditText)view.findViewById(R.id.Esub);
        mesg=(EditText)view.findViewById(R.id.Mesg);
        to.setText("Vittfinance@gmail.com");

         send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String subS= sub.getText().toString();
                String mesgS= mesg.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/html");
                email.putExtra(Intent.EXTRA_EMAIL, new String[] {"Vittfinance@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT,subS );
                email.putExtra(Intent.EXTRA_TEXT,mesgS );

                 startActivity(Intent.createChooser(email,"Select Email app"));

            }

        });



    }
}
