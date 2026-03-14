package com.nibm.mad.lesson4;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.R;

public class TestListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_list_view);

        this.getSupportActionBar().hide();

        String[] students = {
                "Nimal",
                "Kamal",
                "Sunil",
                "Amara",
                "Nimal",
                "Kamal",
                "Sunil",
                "Amara",
                "Nimal",
                "Kamal",
                "Sunil",
                "Amara",
                "Kamal",
                "Sunil",
                "Amara"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        ListView listView = findViewById(R.id.listViewTest);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(
                (parent,
                 view, position,
                 id) -> {
            String selected = students[position];
                    System.out.println("Id "  + id  + "pos " + position);
            Toast.makeText(this, "Clicked: "
                    + selected, Toast.LENGTH_SHORT).show();
        }
        );


    }
}