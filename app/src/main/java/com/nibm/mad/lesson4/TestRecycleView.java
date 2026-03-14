package com.nibm.mad.lesson4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nibm.mad.R;

public class TestRecycleView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_recycle_view);

        RecyclerView recyclerView = findViewById(R.id.testRecyleView);
        String [] students = {
                "Venusha",
                "laffar",
                "Shehan",
                "Udara",
                "Nemeshi"
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentAdapter studentAdapter = new StudentAdapter(students);

        recyclerView.setAdapter(studentAdapter);

    }
}