package com.nibm.mad.lesson4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nibm.mad.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<String> mData;
    private LayoutInflater mInflater;
    private final OnItemClickListener listener;

//    public MyRecyclerViewAdapter(Context context, List<String> data) {
//        this.mInflater = LayoutInflater.from(context);
//        this.mData = data;
//    }

    public MyRecyclerViewAdapter(Context context, List<String> mData,OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String item = mData[position];
        String item = mData.get(position);
        holder.myTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener,View.OnLongClickListener
    {
        TextView myTextView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.txtName);

//            itemView.setOnClickListener(v -> {
//                int position = getAdapterPosition();
//                Toast.makeText(
//                        itemView.getContext(),
//                        "Clicked: " + mData.get(position),
//                        Toast.LENGTH_SHORT
//                ).show();
//            });

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, mData.get(position));
            }
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemLongClick(position, mData.get(position));
                return true; // event handled
            }
            return false;
        }
    }



    public interface OnItemClickListener {
        void onItemClick(int position, String name);
        void onItemLongClick(int position, String name);
    }
}
