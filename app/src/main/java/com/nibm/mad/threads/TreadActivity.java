package com.nibm.mad.threads;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.MainActivity;
import com.nibm.mad.R;

public class TreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tread);

        TextView textView = findViewById(R.id.textViewTreads);

        Button button = findViewById(R.id.asyncTaskButton);

        textView.setText("hello");
//        new Thread(() -> {
//            // Background work
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            textView.setText("Updated from background!");
//        }).start();

        new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            runOnUiThread(() -> {
                textView.setText("Updated safely!");
            });

        }).start();


        button.setOnClickListener(
               v->{
                   Intent intent = new Intent(this, AsyncTaskActivity.class);
                   startActivity(intent);
               }
        );
    }
}