package com.example.medicalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SymtomsActivity extends AppCompatActivity {
    private Button signoutSym;
    private FirebaseAuth auth;
    private CheckBox aaid;
    private CheckBox bbid;
    private CheckBox ccid;
    private CheckBox ddid;
    private CheckBox eeid;
    private CheckBox ffid;
    private CheckBox ggid;
    private CheckBox hhid;
    private CheckBox iiid;
    private CheckBox jjid;
    private CheckBox kkid;
    private CheckBox llid;
    private Button nextfinal;
    private TextView tct1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symtoms);

        aaid = (CheckBox) findViewById(R.id.aid);
        bbid = (CheckBox) findViewById(R.id.bid);
        ccid = (CheckBox) findViewById(R.id.cid);
        ddid = (CheckBox) findViewById(R.id.did);
        eeid = (CheckBox) findViewById(R.id.eid);
        ffid = (CheckBox) findViewById(R.id.fid);
        ggid = (CheckBox) findViewById(R.id.gid);
        hhid = (CheckBox) findViewById(R.id.hid);
        iiid = (CheckBox) findViewById(R.id.iid);
        jjid = (CheckBox) findViewById(R.id.jid);
        kkid = (CheckBox) findViewById(R.id.kid);
        llid = (CheckBox) findViewById(R.id.lid);

nextfinal=(Button) findViewById(R.id.nextsymid);
tct1 = (TextView) findViewById(R.id.tctid);
tct1.setText(getIntent().getExtras().getString("tct"));
        tct1.setVisibility(View.INVISIBLE);
        nextfinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
if(aaid.isChecked() || bbid.isChecked() || ccid.isChecked() || ddid.isChecked() || eeid.isChecked() || ffid.isChecked() || ggid.isChecked() || hhid.isChecked() || iiid.isChecked() ||jjid.isChecked() || kkid.isChecked() || llid.isChecked()) {

    Intent intent = new Intent(SymtomsActivity.this, Main2Activity.class);
    intent.putExtra("tct1", tct1.getText().toString());
    startActivity(intent);
}
else {
    Toast.makeText(getApplicationContext(), "Select Symptoms!", Toast.LENGTH_SHORT).show();
}

}

        });

    }


}