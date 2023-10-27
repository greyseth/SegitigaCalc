package com.example.segitigacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void GoToCircle(View view) {
        Intent intent = new Intent(MainActivity.this, Circle.class);
        startActivity(intent);
    }

    public void GoToSquare(View view) {
        Intent intent = new Intent(MainActivity.this, Square.class);
        startActivity(intent);
    }

    public void GoToTriangle(View view) {
        Intent intent = new Intent(MainActivity.this, Triangle.class);
        startActivity(intent);
    }

    public void GoToDiamond(View view) {
        Intent intent = new Intent(MainActivity.this, Diamond.class);
        startActivity(intent);
    }

}