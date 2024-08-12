package com.clubconnect;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    CardView profilesCard;
    CardView addeventCard;
    CardView viewfbCard;
    CardView viewpostCard;
    CardView  clubdetailcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        profilesCard = findViewById(R.id.profilesCard);
        addeventCard=findViewById(R.id.addeventCard);
        viewfbCard=findViewById(R.id.viewfbCard);
        viewpostCard=findViewById(R.id.viewpostCard);
        clubdetailcard=findViewById(R.id.clubdetailcard);



        addeventCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, addevent.class);
            startActivity(intent);
        });
        profilesCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, addposts.class);
            startActivity(intent);
        });
        viewfbCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, viewfb.class);
            startActivity(intent);
        });
        viewpostCard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, viewposts.class);
            startActivity(intent);
        });
        clubdetailcard.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, clubdetails.class);
            startActivity(intent);
        });
    }
    }
