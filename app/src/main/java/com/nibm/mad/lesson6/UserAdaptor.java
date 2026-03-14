package com.nibm.mad.lesson6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nibm.mad.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdaptor extends  RecyclerView.Adapter<UserAdaptor.UserVH>{


    List<User> users = new ArrayList<>();

    public void setUsers(List<User> usersList){
        users.clear();

        users.addAll(usersList);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user,parent,false);
        return new UserVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        User user = users.get(position);
        holder.txtUserName.setText(user.getName());
        holder.txtUserEmail.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserVH extends RecyclerView.ViewHolder{
        TextView txtUserName, txtUserEmail;
        public UserVH(@NonNull View itemView) {
            super(itemView);
            txtUserName = itemView.findViewById(R.id.txtUserName);
            txtUserEmail = itemView.findViewById(R.id.txtUserEmail);
        }
    }
}
