package com.project.radiobutton_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup rad1, rad2;
    CheckBox chk1, chk2, chk3;
    TextView txtResult;

    String s1 = "", s2 = "", s3 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("RadioButton_CheckBox");

        rad1 =(RadioGroup)findViewById(R.id.rad1);
        rad2 =(RadioGroup)findViewById(R.id.rad2);
        chk1 = (CheckBox)findViewById(R.id.chk1);
        chk2 = (CheckBox)findViewById(R.id.chk2);
        chk3 = (CheckBox)findViewById(R.id.chk3);
        txtResult =(TextView)findViewById(R.id.txtResult);

        rad1.setOnCheckedChangeListener(radioGroupEvent);
        rad2.setOnCheckedChangeListener(radioGroupEvent);

        chk1.setOnCheckedChangeListener(chkEvent);
        chk2.setOnCheckedChangeListener(chkEvent);
        chk3.setOnCheckedChangeListener(chkEvent);
    }

    RadioGroup.OnCheckedChangeListener radioGroupEvent = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton r = (RadioButton) findViewById(checkedId);
            if(group == rad1)
                s1 = r.getText().toString() + "型";
            else if(group == rad2)
                s2 = r.getText().toString() ;

            showMessage();
        }
    };

    private void showMessage(){
        txtResult.setText("你選擇 : " + s1 + " " + s2 + "\n你喜歡的運動: " + s3);
    }

    CheckBox.OnCheckedChangeListener chkEvent = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            s3 = "";
            if(chk1.isChecked())
                s3 = chk1.getText().toString();

            if(chk2.isChecked())
                s3 += " " + chk2.getText().toString();

            if(chk3.isChecked())
                s3 += " " + chk3.getText().toString();

            showMessage();
        }
    };
}
