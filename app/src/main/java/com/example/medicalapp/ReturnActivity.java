package com.example.medicalapp;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ReturnActivity extends AppCompatActivity {
    private EditText usernamere;
    private EditText paswrdre;
    private Button nextBtn;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

      /*  if (auth.getCurrentUser() != null) {
            startActivity(new Intent(ReturnActivity.this, SymtomsActivity.class));
            finish();
        }*/

        // set the view now
        setContentView(R.layout.activity_return);



        usernamere = (EditText) findViewById(R.id.userreid);
        paswrdre = (EditText) findViewById(R.id.passwrdreid);
        nextBtn = (Button) findViewById(R.id.nextreid);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernamere.getText().toString().trim();
                final String passwrd = paswrdre.getText().toString().trim();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passwrd)) {
                    Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Progress Bar is not in layout!   So it is NULL
//                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(username, passwrd)
                        .addOnCompleteListener(ReturnActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                //Progress Bar is not in layout!   So it is NULL
                                //                              progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    //Log the error
                                    Log.e("LOG", task.getException().toString());

                                    if (passwrd.length() < 8) {
                                        paswrdre.setError("enter password");
                                    } else {

                                        Toast.makeText(ReturnActivity.this, "Please Sign Up", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(ReturnActivity.this, SymtomsActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

    }
}
