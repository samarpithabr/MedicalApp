package com.example.medicalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AddSugar extends AppCompatActivity {
    private EditText weightInAdd;
    private EditText sugarInAdd;
    private Button nextInAdd;
    private Button signoutuser;
    private FirebaseAuth auth;
    private TextView username;


    //Make listener a member variable so you can register and unregister it
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sugar);
        weightInAdd = (EditText) findViewById(R.id.weightAddid);
        sugarInAdd = (EditText) findViewById(R.id.sugarLevel);
        signoutuser = (Button) findViewById(R.id.signoutId);
        auth = FirebaseAuth.getInstance();
        username = (TextView) findViewById(R.id.userid);
       username.setText(getIntent().getExtras().getString("tct"));
        nextInAdd = (Button) findViewById(R.id.nextinIaddsw);
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(AddSugar.this, ReturnActivity.class));
            finish();
        }

        //Set the authStateListener member variable here in onCreate()
// this listener will be called when there is change in firebase user session
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(AddSugar.this, ReturnActivity.class));

                }
            }
        };

        auth.addAuthStateListener(authStateListener);

        signoutuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();

            }
        });


        nextInAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int weight =weightInAdd.ge
                String weightws = weightInAdd.getText().toString();
                int weightresult = Integer.parseInt(weightws);
                String sugarws = sugarInAdd.getText().toString();
                int sugarResult = Integer.parseInt(sugarws);
                if (TextUtils.isEmpty(weightws)) {
                    Toast.makeText(getApplicationContext(), "Enter weight!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sugarws)) {
                    Toast.makeText(getApplicationContext(), "Enter sugar!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (sugarResult < 4) {
                    sugarInAdd.setError("please enter sugar above 4 mmlo/L");
                    Toast.makeText(getApplicationContext(), "please enter sugar above 4 mmlo/L!", Toast.LENGTH_SHORT).show();

                }
                if (weightresult < 50) {
                    weightInAdd.setError("please enter weight above 50Kg");
                    Toast.makeText(getApplicationContext(), "please enter weight above 50Kg!", Toast.LENGTH_SHORT).show();
                }


                if ((sugarResult >= 4 && sugarResult <= 7) && (weightresult == 70)) {
                    Intent intent = new Intent(AddSugar.this, SymtomsActivity.class);
                    intent.putExtra("tct", "You Have Type 2 DIABETES\n\nYou have to take Insulin once a Day(morning) and Metaphormin once a Day(morning)\n  \n See you on your Next Appointment  ");
                    startActivity(intent);

                } else if ((sugarResult > 7) && (weightresult >= 70)) {
                    Intent intent = new Intent(AddSugar.this, SymtomsActivity.class);
                    intent.putExtra("tct", "You Have Type 2 DIABETES\n\nYou have to take Insulin twice a Day(morning and evening) and Metaphormin twice a Day(morning and evening)\n  \n See you on your Next Appointment  ");
                    startActivity(intent);

                } else if ((sugarResult >= 5 && sugarResult <= 7) && (weightresult >= 50)) {
                    Intent intent = new Intent(AddSugar.this, SymtomsActivity.class);
                    intent.putExtra("tct", "You Have Type 1 DIABETES\n\nYou have to take Insulin once a Day(morning) and Metaphormin once a Day(morning)\n  \n See you on your Next Appointment  ");
                    startActivity(intent);

                } else if ((sugarResult > 7) && (weightresult >= 50)) {
                    Intent intent = new Intent(AddSugar.this, SymtomsActivity.class);
                    intent.putExtra("tct", "You Have Type 1 DIABETES\n\nYou have to take Insulin twice a Day(morning and evening) and Metaphormin twice a Day(morning and evening)\n  \n See you on your Next Appointment  ");
                    startActivity(intent);

                }
            }
        });
    }


    // Override onDestroy so the listener is removed when the activity is destroys and doesn't continue to use resources.
    @Override
    protected void onDestroy() {
        auth.removeAuthStateListener(authStateListener);
        super.onDestroy();
    }
}

