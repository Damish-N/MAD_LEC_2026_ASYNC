package com.nibm.mad.lesson4;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nibm.mad.R;

import java.util.List;

public class LoadReyclerView extends AppCompatActivity implements MyRecyclerViewAdapter.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_load_reycler_view);


        String[] students = {
                "Nimal",
                "Kamal",
                "Sunil",
                "Amara",
                "Saman"
        };


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, List.of(students),this);
        recyclerView.setAdapter(adapter);

        recyclerView.setAdapter(adapter);

//        recyclerView.setOnClickListener(
//                new AdapterView<>()
//        );

    }

    @Override
    public void onItemClick(int position, String name) {
        Toast.makeText(this, "Clicked: " + name + " (pos " + position + ")", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(int position, String name) {
        Toast.makeText(this, "Long Clicked: " + name, Toast.LENGTH_SHORT).show();
    }
}