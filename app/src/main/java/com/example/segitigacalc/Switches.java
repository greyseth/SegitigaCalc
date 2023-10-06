package com.example.segitigacalc;
import com.example.segitigacalc.Menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class Switches extends AppCompatActivity {
    LinearLayout cardHolder;
    Button orderBtn;
    EditText menuInput;
    EditText qtyInput;
    
    List<Menu> menus = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switches);

        cardHolder = findViewById(R.id.cards);
        orderBtn = (Button) findViewById(R.id.orderBtn);
        menuInput = findViewById(R.id.menuInput);
        qtyInput = findViewById(R.id.qtyInput);
        
        createMenu();
        
        //Inserts card data
        for (Menu menu :
                menus) {
            int cardPaddingDP = 15;
            int cardPadding = toPX(cardPaddingDP);

            //Makes new card base
            LinearLayout card = new LinearLayout(getApplicationContext());
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            cardParams.setMargins(toPX(20), 0, toPX(20), toPX(25));

            card.setLayoutParams(cardParams);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(cardPadding, cardPadding, cardPadding, cardPadding);
            card.setBackgroundColor(ContextCompat.getColor(getApplication(), R.color.card_bg));

            //Adds text content to card
            card.addView(cardContent(getApplicationContext(), menu.getName()+" ("+menu.getId()+")", "title"));
            card.addView(cardContent(getApplicationContext(), menu.getDescription(), "desc"));
            card.addView(cardContent(getApplicationContext(), "Rp. "+menu.getPrice(), "price"));

            //Adds card to main card view
            cardHolder.addView(card);
        }
        
        //Checks button input
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Ordered");
            }
        });
    }
    
    public void createMenu() {
        menus.add(new Menu("Nasi goreng", "Nasi yang digoreng.", 25000, 0));
        menus.add(new Menu("Pizza", "Pizz Rizz Zaa", 120000, 1));
        menus.add(new Menu("Burger","Burr yang di gerr", 75000, 2));
        menus.add(new Menu("Mac n' Cheese", "Mac yang di chese", 45000, 3));
        menus.add(new Menu("Mie goreng", "Mie yang digoreng.", 25000, 4));
    }

    public TextView cardContent(Context context, String textContent, String type) {
        TextView retView = new TextView(context);
        LinearLayout.LayoutParams retParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        retParams.setMargins(0, 0, 0, toPX(5));

        retView.setText(textContent);
        if (type == "title" || type == "desc") retView.setTextColor(Color.BLACK);
        retView.setTextSize(spToPX(type == "title" ? 20 : 15));
        if (type == "title") retView.setTypeface(retView.getTypeface(), Typeface.BOLD);
        if (type == "price") retView.setTypeface(retView.getTypeface(), Typeface.ITALIC);

        return retView;
    }

    public int toPX(int dp) {
        return getResources().getDisplayMetrics().densityDpi * dp / 160;
    }

    public int spToPX(int sp) {
        float scaledDensity = getResources().getDisplayMetrics().scaledDensity;
        return Math.round(sp * scaledDensity);
    }
}