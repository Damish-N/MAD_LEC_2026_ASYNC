package com.nibm.mad.lesson4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nibm.mad.R;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

     String [] student;

    public StudentAdapter(String[] student) {
        this.student = student;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_test,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(student[position]);
    }

    @Override
    public int getItemCount() {
        return student.length;
    }


    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            txtName = itemView.findViewById(R.id.testStudentName);


            itemView.setOnClickListener(
                    v->{
                        int poss =  getAdapterPosition();
                        System.out.println("You clicked " + student[poss]);
                    }
            );
        }
    }
}
