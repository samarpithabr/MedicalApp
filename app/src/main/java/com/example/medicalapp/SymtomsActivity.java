package com.example.medicalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
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
        //  signoutSym = (Button) findViewById(R.id.signoutid);
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
        nextfinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


    Intent intent = new Intent(SymtomsActivity.this, Main2Activity.class);
    intent.putExtra("tct1","tct1.setText(getIntent().getExtras().getString(\"tct\"));");
    startActivity(intent);
    finish();
}

        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
boolean ad =aaid.isChecked();
boolean bd = bbid.isChecked();
        boolean cd =ccid.isChecked();
        boolean dd = ddid.isChecked();
        boolean ed =eeid.isChecked();
        boolean fd = ffid.isChecked();
        boolean gd =ggid.isChecked();
        boolean hd = hhid.isChecked();
        boolean id =iiid.isChecked();
        boolean jd = jjid.isChecked();
        boolean kd =kkid.isChecked();
        boolean ld = llid.isChecked();

if(ad || bd){
    Toast.makeText(getApplicationContext(), "type1", Toast.LENGTH_SHORT).show();
}
    }
}