package com.nibm.mad.threads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.R;

public class AsyncTaskActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            new MyTask().execute();
        });
    }

    private class MyTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            // Runs on UI thread
            textView.setText("Task Started...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            // Background thread
            try {
                Thread.sleep(3000); // simulate long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task Finished!";
        }

        @Override
        protected void onPostExecute(String result) {
            // Back to UI thread
            textView.setText(result);
        }
    }
}