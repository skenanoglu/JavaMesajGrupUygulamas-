package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.GroupModel;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {

    Context context;
    ArrayList<GroupModel> list;

    public GroupAdapter() {
    }

    public GroupAdapter(Context context, ArrayList<GroupModel> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.group_item,parent,false);
        return new GroupAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GroupModel groupModel = list.get(position);
        holder.groupName.setText(groupModel.getTitle());
        holder.groupDescription.setText(groupModel.getDesc());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView groupName, groupDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.tv1);
            groupDescription = itemView.findViewById(R.id.tv2);
        }
    }
}
