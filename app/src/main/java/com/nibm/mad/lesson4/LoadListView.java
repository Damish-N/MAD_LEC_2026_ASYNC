package com.nibm.mad.lesson4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nibm.mad.R;

public class LoadListView extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {}


        setContentView(R.layout.activity_load_list_view);
        ListView listView = findViewById(R.id.listView);

        String[] students = {
                "Nimal",
                "Kamal",
                "Sunil",
                "Amara",
                "Saman"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        listView.setAdapter(adapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = students[position];
            Toast.makeText(this, "Clicked: " + selected, Toast.LENGTH_SHORT).show();
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            String selected = students[position];
            Toast.makeText(this, "Longed Clicked: " + selected, Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}
