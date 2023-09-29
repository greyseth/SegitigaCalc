package com.example.segitigacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button luasBtn, kelBtn, calcBtn;

    EditText tinggiInput, alasInput, aInput, bInput, cInput;
    TextView resDisplay = null;

    String selected = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializes elements
        luasBtn = (Button) findViewById(R.id.luasBtn);
        kelBtn = (Button) findViewById(R.id.kelBtn);
        calcBtn = (Button) findViewById(R.id.calcBtn);

        tinggiInput = (EditText) findViewById(R.id.tinggiInput);
        alasInput = (EditText) findViewById(R.id.alasInput);
        aInput = (EditText) findViewById(R.id.aInput);
        bInput = (EditText) findViewById(R.id.bInput);
        cInput = (EditText) findViewById(R.id.cInput);
        resDisplay = (TextView) findViewById(R.id.resultDisplay);

        //Button functions
        luasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aInput.setVisibility(View.GONE);
                bInput.setVisibility(View.GONE);
                cInput.setVisibility(View.GONE);

                tinggiInput.setVisibility(View.VISIBLE);
                alasInput.setVisibility(View.VISIBLE);

                selected = "luas";
            }
        });

        kelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tinggiInput.setVisibility(View.GONE);
                alasInput.setVisibility(View.GONE);

                aInput.setVisibility(View.VISIBLE);
                bInput.setVisibility(View.VISIBLE);
                cInput.setVisibility(View.VISIBLE);

                selected = "kel";
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selected.equals("luas")) {
                    if (tinggiInput.getText().toString().isEmpty() || alasInput.getText().toString().isEmpty()) {
                        GiveError("DATA BELUM TERISI!");
                        return;
                    }

                    resDisplay.setVisibility(View.VISIBLE);
                    resDisplay.setTextColor(Color.BLACK);
                    resDisplay.setText((.5 * Integer.parseInt(alasInput.getText().toString()) * Integer.parseInt(tinggiInput.getText().toString()))+"");
                }else if (selected.equals("kel")) {
                    if (aInput.getText().toString().isEmpty() || bInput.getText().toString().isEmpty() || cInput.getText().toString().isEmpty()) {
                        GiveError("DATA BELUM TERISI!");
                        return;
                    }

                    resDisplay.setVisibility(View.VISIBLE);
                    resDisplay.setTextColor(Color.BLACK);
                    resDisplay.setText((Integer.parseInt(aInput.getText().toString()) + Integer.parseInt(bInput.getText().toString()) + Integer.parseInt(cInput.getText().toString()))+"");
                }else {
                    GiveError("TOLONG PILIH JENIS KALKULASI!");
                }
            }
        });
    }

    void GiveError(String msg) {
        resDisplay.setVisibility(View.VISIBLE);
        resDisplay.setTextColor(Color.RED);
        resDisplay.setText(msg);
    }
}