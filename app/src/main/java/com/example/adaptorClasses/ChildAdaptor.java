package com.example.adaptorClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modelClasses.ChildModelClass;
import com.example.nestedrecyclearviewrevision.R;

import java.util.List;

public class ChildAdaptor extends RecyclerView.Adapter<ChildAdaptor.MyViewHolder> {
    public List<ChildModelClass> childModelClassList;
    ChildAdaptor(List<ChildModelClass> childAdaptorList){
        this.childModelClassList=childAdaptorList;
    }
    ChildClickListener childClickListener;
    //Make the setter of ChildClickListener

    public void setChildClickListener(ChildClickListener childClickListener) {
        this.childClickListener = childClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.child_row_view,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //ChildModelClass childModelClassPosition=childModelClassList.get(position);
        holder.ivChildRowView.setImageResource(childModelClassList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return childModelClassList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView ivChildRowView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChildRowView=itemView.findViewById(R.id.ivChildRowView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if (childClickListener!=null&&position!=RecyclerView.NO_POSITION){
                        childClickListener.childClick(view,getAdapterPosition());
                    }
                }
            });
        }
    }
    public interface ChildClickListener{
        void childClick(View view,int index);
    }
}
