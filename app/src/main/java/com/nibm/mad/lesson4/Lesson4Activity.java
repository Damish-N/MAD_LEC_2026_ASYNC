package com.nibm.mad.lesson4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nibm.mad.R;

public class Lesson4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_four);

        Button button = findViewById(R.id.loadListView);

        button.setOnClickListener(
                v->{
                    Intent intent = new Intent(this, LoadListView.class);
                    startActivity(intent);
                }
        );

        Button button2 = findViewById(R.id.recyclerViewButton);

        button2.setOnClickListener(
                v->{
                    Intent intent = new Intent(this, LoadReyclerView.class);
                    startActivity(intent);
                }
        );
    }
}

