package com.example.normalrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.normalrecyclerview.cardview.CardViewActivity;
import com.example.normalrecyclerview.multipleviewtype.MultipleViewType;
import com.example.normalrecyclerview.multiselection.MultipleSelectionActivity;
import com.example.normalrecyclerview.normalview.NormalRecyclerView;
import com.example.normalrecyclerview.singlsselection.SingleSelectionRV;
import com.example.normalrecyclerview.swipe.SwipeSelectionActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NormalRecyclerView.class);
                startActivity(i);

            }
        });
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CardViewActivity.class);
                startActivity(i);
            }
        });
        btn3 = findViewById(R.id.buttonSingleSelection);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SingleSelectionRV.class);
                startActivity(i);
            }
        });
        btn4 = findViewById(R.id.buttonMultipleViewType);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MultipleViewType.class);
                startActivity(i);
            }
        });
        btn5 = findViewById(R.id.button_multi_selection);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MultipleSelectionActivity.class);
                startActivity(i);
            }
        });
        btn6 = findViewById(R.id.button_swipe);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SwipeSelectionActivity.class);
                startActivity(i);
            }
        });
    }
}