package com.example.normalrecyclerview.singlsselection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;

public class SingleSelectionRV extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn;

    // Variables
    private ArrayList<Employee> employees = new ArrayList<>();
    private SingleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_selection_rv);
        recyclerView = findViewById(R.id.singleRV);
        btn = findViewById(R.id.button_get_selected);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new SingleAdapter(this, employees);
        recyclerView.setAdapter(adapter);
        createList();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getSelected() != null) {
                    ShowToast(adapter.getSelected().getName());

                } else {
                    ShowToast("No Employee Selected");


                }
            }
        });
    }

    private void createList() {
        employees = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();
            employee.setName("Employee " + (i+1));
            employees.add(employee);
        }
        adapter.setEmployeeArrayList(employees);
    }

    private void ShowToast (String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}