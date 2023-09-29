package com.example.segitigacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Loops extends AppCompatActivity {

    EditText awalInput;
    EditText akhirInput;

    TextView resDisp;
    Button processBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loops);

        awalInput = findViewById(R.id.awalInput);
        akhirInput = findViewById(R.id.akhirInput);

        resDisp = findViewById(R.id.display);
        processBtn = findViewById(R.id.processBtn);

        processBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer start = Integer.parseInt(awalInput.getText().toString());
                Integer end = Integer.parseInt(akhirInput.getText().toString());
                StringBuilder sb = new StringBuilder();

                if (end >= start) {
                    for(Integer i = start; i <= end; i++) {
                        sb.append(i);
                        sb.append("\n");
                    }
                }else {
                    for(Integer i = start; i >= end; i--) {
                        sb.append(i);
                        sb.append("\n");
                    }
                }

                resDisp.setText(sb.toString());
            }
        });
    }
}