package com.example.medicalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SymtomsActivity extends AppCompatActivity {
    private Button signoutSym;
    private FirebaseAuth auth;
    private CheckBox aaid;
    private CheckBox bbid;
    private Button nextfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symtoms);
        //  signoutSym = (Button) findViewById(R.id.signoutid);
aaid = (CheckBox) findViewById(R.id.aid);
bbid = (CheckBox) findViewById(R.id.bid);
nextfinal=(Button) findViewById(R.id.nextsymid);

        nextfinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 {


    Intent intent = new Intent(SymtomsActivity.this, MainActivity.class);
    startActivity(intent);
    finish();
}
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
boolean ad =aaid.isChecked();
boolean bd = bbid.isChecked();
if(ad || bd){
    Toast.makeText(getApplicationContext(), "type1", Toast.LENGTH_SHORT).show();
}
    }
}