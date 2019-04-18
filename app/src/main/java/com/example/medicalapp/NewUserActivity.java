package com.example.medicalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;



public class NewUserActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText usernameText;
    private EditText passwrdText;
    private EditText dobText;
    private EditText sexText;
    private EditText civilText;
    private EditText mobileText;
    private EditText emailText;
    private EditText weightText;
    private EditText sugarText;
    private FirebaseAuth auth;
    private ProgressBar progressDialogue;
    private Button nxtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        progressDialogue = new ProgressBar(this);
        setContentView(R.layout.activity_new_user);
        nameText = (EditText) findViewById(R.id.nameid);
        usernameText = (EditText) findViewById(R.id.usernameid);
        passwrdText = (EditText) findViewById(R.id.passwordid);
        dobText = (EditText) findViewById(R.id.dobid);
        sexText = (EditText) findViewById(R.id.sexid);
        civilText = (EditText) findViewById(R.id.civilid);
        mobileText = (EditText) findViewById(R.id.mobileid);
        emailText = (EditText) findViewById(R.id.emailid);
        weightText = (EditText) findViewById(R.id.weightid);
        sugarText = (EditText) findViewById(R.id.sugarlevelid);
nxtBtn = (Button) findViewById(R.id.nextofNewid) ;
        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString().trim();
                String username = usernameText.getText().toString().trim();
                final String password = passwrdText.getText().toString().trim();
                String dob = dobText.getText().toString().trim();
                String sex = sexText.getText().toString().trim();
                String civil = civilText.getText().toString().trim();
                String mobile = mobileText.getText().toString().trim();
                String email = emailText.getText().toString().trim();
                String weight = weightText.getText().toString().trim();
                String sugar = sugarText.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(dob)) {
                    Toast.makeText(getApplicationContext(), "Enter dob!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sex)) {
                    Toast.makeText(getApplicationContext(), "Enter sex!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(civil)) {
                    Toast.makeText(getApplicationContext(), "Enter CivilId!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mobile)) {
                    Toast.makeText(getApplicationContext(), "Enter Mobile Number!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sugar)) {
                    Toast.makeText(getApplicationContext(), "Enter Sugar Level!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(weight)) {
                    Toast.makeText(getApplicationContext(), "Enter Weight!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


                //authenticate user
                auth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(NewUserActivity.this, new OnCompleteListener<AuthResult>() {


                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    // there was an error

                                        Toast.makeText(NewUserActivity.this, "authentication failed", Toast.LENGTH_LONG).show();

                                } else {

                                    startActivity(new Intent(NewUserActivity.this, SymtomsActivity.class));
finish();finish();
                                }
                            }
                        });

            }
        });


    }
}


