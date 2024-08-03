package com.example.normalrecyclerview.singlsselection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.EmployeeHolder> {
    private Context context;
    private ArrayList<Employee> employeeArrayList;
    private int checkedPosition = 0;

    public SingleAdapter(Context context, ArrayList<Employee> employeeArrayList) {
        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = new ArrayList<>();
        this.employeeArrayList = employeeArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);

        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {
        holder.bind(employeeArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return employeeArrayList.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;


        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.emp_name);
            imageView = itemView.findViewById(R.id.imageview_emp);
        }

        void bind(final Employee employee) {
            if (checkedPosition == -1) {
                imageView.setVisibility(View.GONE);
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }

            }
            name.setText(employee.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageView.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }
    }

    public Employee getSelected() {
        if (checkedPosition != -1) {
            return employeeArrayList.get(checkedPosition);
        }
        return null;
    }
}
