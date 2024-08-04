package com.example.normalrecyclerview.multipleviewtype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;

public class MultipleViewType extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view_type);
        recyclerView = findViewById(R.id.multiple_view_rv);
        InsertDataToRV();



    }

    private void InsertDataToRV() {
        ArrayList<MultiEmployee> multiEmployees = new ArrayList<>();
        MultiEmployee employee1 = new MultiEmployee();

        employee1.setName("Mohammad");
        employee1.setAddress("New York");
        employee1.setPhone("+012398234234");
        multiEmployees.add(employee1);

        MultiEmployee employee2 = new MultiEmployee();
        employee2.setName("Ali");
        employee2.setAddress("London");
        employee2.setEmail("ali@gmail.com");
        multiEmployees.add(employee2);

        MultiEmployee employee3 = new MultiEmployee();
        employee3.setName("Jack");
        employee3.setAddress("Philadelphia");
        employee3.setEmail("jack@gmail.com");
        multiEmployees.add(employee3);

        MultiEmployee employee4 = new MultiEmployee();
        employee4.setName("Ryan");
        employee4.setAddress("Canada");
        employee4.setPhone("+123423453456");
        multiEmployees.add(employee4);
        MultipleTypeAdapter multipleTypeAdapter = new MultipleTypeAdapter(this, multiEmployees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(multipleTypeAdapter);
    }
}