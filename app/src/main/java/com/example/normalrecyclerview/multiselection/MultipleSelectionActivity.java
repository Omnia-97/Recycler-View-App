package com.example.normalrecyclerview.multiselection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.normalrecyclerview.R;
import com.example.normalrecyclerview.singlsselection.Employee;

import java.util.ArrayList;

public class MultipleSelectionActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MultiAdapter adapter;
    Button button;
    ArrayList<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleselectionactivity);
        recyclerView = findViewById(R.id.multiple_rv);
        button = findViewById(R.id.get_multiple_selection_btn);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        adapter = new MultiAdapter(this , employees);
        recyclerView.setAdapter(adapter);
        CreateListOfData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getSelected().size() > 0){
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0 ; i < adapter.getSelected().size() ; i++){
                        stringBuilder.append(adapter.getSelected().get(i).getName());
                        stringBuilder.append("\n");
                    }
                    ShowToast(stringBuilder.toString().trim());
                }else {
                    ShowToast("No data selected");
                }
            }
        });


    }

    private void ShowToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void CreateListOfData() {
        employees = new ArrayList<>();
        for (int i =0 ; i < 20; i++){
            Employee employee = new Employee();
            employee.setName("Employee " + (i+1));
            if(i == 0){
                employee.setChecked(true);
            }
            employees.add(employee);
        }
        adapter.setEmployees(employees);
    }
}