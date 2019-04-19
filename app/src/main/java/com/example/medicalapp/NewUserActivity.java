package com.example.medicalapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class NewUserActivity extends AppCompatActivity {
    private DatePicker dpResult;
    private TextView tvDisplayDate;
    //private DatePicker dpResult;
    private Button btnChangeDate;

    private int year;
    private int month;
    private int day;
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
 private EditText calenderedit;
 private Button calendarButton;

   // DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.simpleDatePicker);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();

        progressDialogue = new ProgressBar(this);
        setContentView(R.layout.activity_new_user);
        nameText = (EditText) findViewById(R.id.nameid);
        usernameText = (EditText) findViewById(R.id.usernameid);
        passwrdText = (EditText) findViewById(R.id.passwordid);
       //dobText = (EditText) findViewById(R.id.dobid);
       // dpResult = (DatePicker) findViewById(R.id.dpResult);

        civilText = (EditText) findViewById(R.id.civilid);
        mobileText = (EditText) findViewById(R.id.mobileid);
        emailText = (EditText) findViewById(R.id.emailid);
        weightText = (EditText) findViewById(R.id.weightid);
        sugarText = (EditText) findViewById(R.id.sugarlevelid);
        calendarButton = (Button) findViewById(R.id.calButton);
        calenderedit = (EditText) findViewById(R.id.editcal);
        final Calendar myCalendar = Calendar.getInstance();

      //  EditText edittext= (EditText) findViewById(R.id.Birthday);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                String myFormat = "MMM dd, yyyy"; //In which you need put here
                SimpleDateFormat sdformat = new SimpleDateFormat(myFormat, Locale.US);
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                calenderedit.setText(sdformat.format(myCalendar.getTime()));
            }

        };
        calendarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(NewUserActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }

        });

nxtBtn = (Button) findViewById(R.id.nextofNewid) ;


        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameText.getText().toString().trim();
                String username = usernameText.getText().toString().trim();
                final String password = passwrdText.getText().toString().trim();
//
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

             /*   if (TextUtils.isEmpty(dob)) {
                    Toast.makeText(getApplicationContext(), "Enter dob!", Toast.LENGTH_SHORT).show();
                    return;
                }*/




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

                                    startActivity(new Intent(NewUserActivity.this, AddSugar.class));
finish();
                                }
                            }
                        });

            }
            public void onRadioButtonClicked(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch(view.getId()) {
                    case R.id.maleid:
                        if (checked)
                            // Pirates are the best
                            break;
                    case R.id.femaleid:
                        if (checked)
                            // Ninjas rule
                            break;
                }
            }

       /*    private DatePickerDialog.OnDateSetListener datePickerListener
                    = new DatePickerDialog.OnDateSetListener() {

                // when dialog box is closed, below method will be called.
                public void onDateSet(DatePicker view, int selectedYear,
                                      int selectedMonth, int selectedDay) {
                    year = selectedYear;
                    month = selectedMonth;
                    day = selectedDay;

                    // set selected date into textview
               //   tvDisplayDate.setText(new StringBuilder().append(month + 1)
                 //       .append("-").append(day).append("-").append(year)
                  //       .append(" "));

                    // set selected date into datepicker also
                    dpResult.init(year, month, day, null);

                }
            };*/


        });



    }
}
/*    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal">
        <TextView
            style="@style/fielTheme"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Date Of Birth:"/>

        <EditText

            android:hint="dob"
            android:id="@+id/dobid"
            android:background="@drawable/textinputborder"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
           />
    </LinearLayout>*/

