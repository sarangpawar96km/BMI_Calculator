package com.example.bmi_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editweight,editheightft,editheightin;
        Button btncalculate;
        TextView txtresult,txtbmi;
        LinearLayout ll;

        editweight=findViewById(R.id.editweight);
        editheightft=findViewById(R.id.editheightft);
        editheightin=findViewById(R.id.editheightin);
        btncalculate=findViewById(R.id.btncalculate);
        txtresult=findViewById(R.id.txtresult);
        txtbmi=findViewById(R.id.txtbmi);
        ll=findViewById(R.id.ll);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(editweight.getText().toString());
                int htf = Integer.parseInt(editheightft.getText().toString());
                int htin = Integer.parseInt(editheightin.getText().toString());

                int totalinches = htf * 12 + htin;
                double totalcentimeters = totalinches * 2.54; // 2.54 cm per inch
                double totalmeters = totalcentimeters / 100;
                double bmi = wt / (totalmeters * totalmeters);

                if (bmi > 25) {
                    txtresult.setText("You are Overweight 😣");
                    txtbmi.setText("BMI = "+bmi);
                    ll.setBackgroundColor(getResources().getColor(R.color.ovw));
                } else if (bmi >= 18.5 && bmi <= 25) {
                    ll.setBackgroundColor(getResources().getColor(R.color.hlty));
                    txtresult.setText("You are Healthy 🤗");
                    txtbmi.setText("BMI = "+bmi);
                } else {
                    txtresult.setText("You are Underweight 😪");
                    txtbmi.setText("BMI = "+bmi);
                    ll.setBackgroundColor(getResources().getColor(R.color.unw));
                }
            }
        });

    }
}