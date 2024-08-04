package com.example.normalrecyclerview.swipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.normalrecyclerview.R;
import com.example.normalrecyclerview.singlsselection.Employee;

import java.util.ArrayList;

public class SwipeAdapter extends RecyclerView.Adapter<SwipeAdapter.SiwpeViewHolder> {
    private Context context;
    private ArrayList<Employee> employees;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public SwipeAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SiwpeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee_swipe , parent, false);
        return new SiwpeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiwpeViewHolder holder, int position) {
        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout , String.valueOf(employees.get(position).getName()));
        viewBinderHelper.closeLayout(String.valueOf(employees.get(position).getName()));
        holder.bindData(employees.get(position));

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class SiwpeViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView editText;
        private TextView deleteText;
        private SwipeRevealLayout swipeRevealLayout;

        public SiwpeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            editText = itemView.findViewById(R.id.txtEdit);
            deleteText = itemView.findViewById(R.id.txtDelete);
            swipeRevealLayout = itemView.findViewById(R.id.swipelayout);
            editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Edit is clicked", Toast.LENGTH_SHORT).show();
                }
            });

            deleteText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Delete is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
        void bindData(final Employee employee){
            textView.setText(employee.getName());
        }


    }
}
