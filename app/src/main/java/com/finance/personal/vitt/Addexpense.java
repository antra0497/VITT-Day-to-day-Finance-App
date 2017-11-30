package com.finance.personal.vitt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addexpense extends AppCompatActivity {

    Button save;
    AutoCompleteTextView choice;
    EditText amount;
    String ch[]={"Groceries","Travel","Medicine","PersonalCare","Books","Recharge","OutsideFood","Miscellaneous","Party"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexpense);

        save=(Button)findViewById(R.id.addamt);
        amount=(EditText)findViewById(R.id.amountspend);
        choice=(AutoCompleteTextView)findViewById(R.id.autoCompletechoice);

        ArrayAdapter<String> apt=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ch);
        choice.setThreshold(1);
        choice.setAdapter(apt);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String expenseCategory = choice.getText().toString();
                String expenseAmount= amount.getText().toString();

                Toast.makeText(getApplicationContext(),"Expense Saved", Toast.LENGTH_LONG).show();

                startActivity(new Intent(Addexpense.this, HomeActivity.class));

            }
        });

}
}
