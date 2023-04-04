package com.example.adaptorClasses;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modelClasses.ChildModelClass;
import com.example.modelClasses.ParentModelClass;
import com.example.nestedrecyclearviewrevision.Main3Activity;
import com.example.nestedrecyclearviewrevision.R;

import java.util.ArrayList;
import java.util.List;

public class ParentAdaptor extends RecyclerView.Adapter<ParentAdaptor.MyViewHolder> {
    ParentClickListener parentClickListener;
    ParentModelClass parentModelClassPosition;
    public static final String IMAGE_KAY = "imageKey";
    public void setParentClickListener(ParentClickListener parentClickListener) {
        this.parentClickListener = parentClickListener;
    }

    //Make the list reference variable
    List<ParentModelClass> parentModelClassList;

    //Constructor of the ParentAdaptor class
    public ParentAdaptor(List<ParentModelClass> parentModelClassList) {
        this.parentModelClassList = parentModelClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_row_view, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        parentModelClassPosition = parentModelClassList.get(position);
        holder.tvParentRowView.setText(parentModelClassPosition.getTitle());
        ChildAdaptor childAdaptor = new ChildAdaptor(parentModelClassPosition.getChildModelClassList());
        holder.rvChild.setLayoutManager(new LinearLayoutManager(holder.rvChild.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.rvChild.setAdapter(childAdaptor);
        childAdaptor.setChildClickListener(new ChildAdaptor.ChildClickListener() {
            @Override
            public void childClick(View view, int index) {
                Toast.makeText(holder.itemView.getContext(), "Click", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(holder.itemView.getContext(),Main3Activity.class);
                int image=parentModelClassList.get(position).getChildModelClassList().get(index).getImage();
                intent.putExtra(IMAGE_KAY,image);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parentModelClassList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvParentRowView;
        RecyclerView rvChild;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvParentRowView = itemView.findViewById(R.id.tvParentRowView);
            rvChild = itemView.findViewById(R.id.rvChild);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (parentClickListener != null) {
                        parentClickListener.parentClick(view, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface ParentClickListener {
        void parentClick(View view, int index);
    }
}
