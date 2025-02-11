package com.example.normalrecyclerview.multipleviewtype;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.normalrecyclerview.R;

import java.util.ArrayList;

public class MultipleTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;
    private Context context;
    private ArrayList<MultiEmployee> multiEmployees;

    public MultipleTypeAdapter(Context context, ArrayList<MultiEmployee> multiEmployees) {
        this.context = context;
        this.multiEmployees = multiEmployees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_CALL) {
            view = LayoutInflater.from(context).inflate(R.layout.item_call, parent, false);
            return new CallViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_email, parent, false);
            return new EmailViewHolder(view);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(multiEmployees.get(position).getEmail())) {
            return TYPE_CALL;
        } else {
            return TYPE_EMAIL;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_CALL) {
            ((CallViewHolder) holder).setCallDetails(multiEmployees.get(position));
        } else {
            ((EmailViewHolder) holder).setEmailDetails(multiEmployees.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return multiEmployees.size();
    }

    public class CallViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtAddress;

        CallViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }

        void setCallDetails(MultiEmployee employee) {
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
        }
    }

    public class EmailViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private TextView txtAddress;

        EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }

        void setEmailDetails(MultiEmployee employee) {
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
        }
    }
}
