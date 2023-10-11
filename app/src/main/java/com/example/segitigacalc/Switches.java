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
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Switches extends AppCompatActivity {
    //Element variables
    LinearLayout cardHolder;
    LinearLayout dispContainer;
    Button orderBtn;
    TextView disp;
    EditText menuInput;
    EditText qtyInput;
    
    List<Menu> menus = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switches);

        //Element initialization
        cardHolder = findViewById(R.id.cards);
        dispContainer = (LinearLayout) findViewById(R.id.dispContainer);
        orderBtn = (Button) findViewById(R.id.orderBtn);
        disp = (TextView) findViewById(R.id.disp);
        menuInput = findViewById(R.id.menuInput);
        qtyInput = findViewById(R.id.qtyInput);
        
        createMenu();
        
        //Inserts card data
        for (Menu menu :
                menus) {
            int cardPaddingDP = 15;
            int cardPadding = toPX(cardPaddingDP);

            //Makes new card base
            LinearLayout card = new LinearLayout(Switches.this);
            LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            cardParams.setMargins(toPX(20), 0, toPX(20), toPX(25));

            card.setLayoutParams(cardParams);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(cardPadding, cardPadding, cardPadding, cardPadding);
            card.setBackgroundColor(ContextCompat.getColor(Switches.this, R.color.card_bg));

            //Adds text content to card
            NumberFormat formatter = NumberFormat.getInstance(Locale.ENGLISH);
            String formattedPrice = formatter.format(Long.parseLong(String.valueOf(menu.getPrice())));

            card.addView(cardContent(Switches.this, menu.getName()+" ("+menu.getId()+")", "title"));
            card.addView(cardContent(Switches.this, menu.getDescription(), "desc"));
            card.addView(cardContent(Switches.this, "Rp. "+formattedPrice, "price"));

            //Adds card to main card view
            cardHolder.addView(card);
        }
        
        //Checks button input
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Checks for empty input
                if (menuInput.getText().toString().isEmpty() || qtyInput.getText().toString().isEmpty()) {
                    Toast.makeText(Switches.this, "Input tidak lengkap!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Data processing
                int selection = Integer.parseInt(menuInput.getText().toString());
                int qty = Integer.parseInt(qtyInput.getText().toString());

                String ordered = "";
                int price = 0;
                int totalPrice = 0;

                switch(selection) {
                    case 0:
                        ordered = "Nasi goreng";
                        price = 25000;
                        break;
                    case 1:
                        ordered = "Pizza";
                        price = 120000;
                        break;
                    case 2:
                        ordered = "Burger";
                        price = 75000;
                        break;
                    case 3:
                        ordered = "Mac n' Cheese";
                        price = 45000;
                        break;
                    case 4:
                        ordered = "Mie goreng";
                        price = 25000;
                        break;
                    default:
                        break;
                }

                //Data output
                if (!ordered.isEmpty() && price > 0) {
                    Toast.makeText(Switches.this, "Ditambahkan pesanan "+ordered, Toast.LENGTH_SHORT).show();

                    totalPrice = price * qty;

                    NumberFormat formatter = NumberFormat.getInstance(Locale.ENGLISH);
                    disp.setText(qty+" "+ordered+" Rp. "+formatter.format(Long.parseLong(String.valueOf(totalPrice))));
                    dispContainer.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(Switches.this, "Sebuah Error telah terjadi", Toast.LENGTH_SHORT).show();
                }

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
        retView.setTextSize(type == "title" ? 20 : 15);
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