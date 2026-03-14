package com.nibm.mad.lesson5;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.R;

public class TaskAsync extends AppCompatActivity {

    TextView textView;
    Button buttton;


    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task_async);


        textView = findViewById(R.id.asyncTextView);
        buttton = findViewById(R.id.asyncBtn);

//        buttton.setOnClickListener(
//           v->{
//               new MyAsyncTask(textView).execute();
//           }

        buttton.setOnClickListener(
                v->{
                    textView.setText("Checked the handler start");
                    new Thread(
                            ()-> {
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            handler.post(
                                    ()->{
                                        this.getSupportActionBar().hide();
                                    }
                            );
                            }
                    ).start();
                }
        );


    }

//         new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//        }
//    }
}