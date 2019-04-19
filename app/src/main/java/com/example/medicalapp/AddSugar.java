package com.example.medicalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

    public class AddSugar extends AppCompatActivity {
    private EditText weightInAdd;
    private EditText sugarInAdd;
    private Button nextInAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sugar);
        weightInAdd = (EditText) findViewById(R.id.weightAddid);
        sugarInAdd = (EditText) findViewById(R.id.sugarLevel);
        nextInAdd = (Button) findViewById(R.id.nextinIaddsw);
        nextInAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weightws = weightInAdd.getText().toString().trim();
                int weightresult = Integer.parseInt(weightws);
                String sugarws = sugarInAdd.getText().toString().trim();
                int sugarResult = Integer.parseInt(sugarws);
                if(TextUtils.isEmpty(weightws)){
                    Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(sugarws)){
                    Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if((sugarResult>=4 && sugarResult<=7 )&&(weightresult == 70)) {
                    Intent intent = new Intent(AddSugar.this,SymtomsActivity.class);
                    intent.putExtra("tct","You Have Type261 Diabeties");
                    startActivity(intent);
                    finish();
                }else if((sugarResult>7 )&&(weightresult >= 70)){
                    Intent intent = new Intent(AddSugar.this,SymtomsActivity.class);
                    intent.putExtra("tct","You Have Type21 Diabeties");
                    startActivity(intent);
                    finish();
                }else if((sugarResult>=5 && sugarResult<=7 )&&(weightresult >= 50)){
                    Intent intent = new Intent(AddSugar.this,SymtomsActivity.class);
                    intent.putExtra("tct","You Have Type213 Diabeties");
                    startActivity(intent);
                    finish();
                }else if ((sugarResult>7 )&&(weightresult >=50))
                {
                    Intent intent = new Intent(AddSugar.this,SymtomsActivity.class);
                    intent.putExtra("tct","You Have Type215 Diabeties");
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}