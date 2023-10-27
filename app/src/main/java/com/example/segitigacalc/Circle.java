package com.example.segitigacalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Circle extends AppCompatActivity {

    String selected = "luas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_circle);

        ImageView illustration = findViewById(R.id.illustration);
        EditText rInput = findViewById(R.id.rInput);
        TextView resDisp = findViewById(R.id.resultDisp);
        TextView formulaDisp = findViewById(R.id.formulaDisp);

        Button kBtn = findViewById(R.id.kelilingBtn);
        Button lBtn = findViewById(R.id.luasBtn);
        Button backBtn = findViewById(R.id.backBtn);
        Button countBtn = findViewById(R.id.countBtn);

        //Luas is selected by default
        lBtn.setEnabled(false);

        //Button functions
        lBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = "luas";
                lBtn.setEnabled(false);
                kBtn.setEnabled(true);

                lBtn.setBackground(ContextCompat.getDrawable(Circle.this, R.drawable.text_main_bg));
                lBtn.setTextColor(ContextCompat.getColor(Circle.this, R.color.white));
                lBtn.setTypeface(lBtn.getTypeface(), Typeface.BOLD);

                kBtn.setBackground(ContextCompat.getDrawable(Circle.this, R.drawable.btn_bg_2_bg));
                kBtn.setTextColor(ContextCompat.getColor(Circle.this, R.color.text_main));
                kBtn.setTypeface(kBtn.getTypeface(), Typeface.NORMAL);

                illustration.setImageResource(R.drawable.circleluas);
                formulaDisp.setText(R.string.circle_luas);
            }
        });

        kBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = "keliling";
                kBtn.setEnabled(false);
                lBtn.setEnabled(true);

                kBtn.setBackground(ContextCompat.getDrawable(Circle.this, R.drawable.text_main_bg));
                kBtn.setTextColor(ContextCompat.getColor(Circle.this, R.color.white));
                kBtn.setTypeface(kBtn.getTypeface(), Typeface.BOLD);

                lBtn.setBackground(ContextCompat.getDrawable(Circle.this, R.drawable.btn_bg_2_bg));
                lBtn.setTextColor(ContextCompat.getColor(Circle.this, R.color.text_main));
                lBtn.setTypeface(lBtn.getTypeface(), Typeface.NORMAL);

                illustration.setImageResource(R.drawable.circlekel);
                formulaDisp.setText(R.string.circle_keliling);
            }
        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rInput.getText().toString().isEmpty()) {
                    Toast.makeText(Circle.this, "Nilai harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selected.equals("luas")) {
                    double r = Double.parseDouble(rInput.getText().toString());
                    double res = 3.14 * (r * r);

                    resDisp.setText("L = "+res);
                }else if (selected.equals("keliling")) {
                    double r = Double.parseDouble(rInput.getText().toString());
                    double res = 2 * 3.14 * r;

                    resDisp.setText("K= "+res);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Circle.this, MainActivity.class));
            }
        });
    }
}