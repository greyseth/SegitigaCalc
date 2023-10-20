package com.example.segitigacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intents extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents);

        Button browserBtn = findViewById(R.id.browserBtn);
        Button telpBtn = findViewById(R.id.telpBtn);
        Button newPageBtn = findViewById(R.id.newPageBtn);

        browserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gseth-profile.netlify.app"));
                startActivity(browserIntent);
            }
        });

        telpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = "08080808080";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.fromParts("tel", num, null));
                startActivity(callIntent);
            }
        });

        newPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(Intents.this, landing_intents.class);
                startActivity(explicitIntent);
            }
        });
    }
}