package com.nibm.mad.lesson4;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.R;

public class TreadsLearn extends AppCompatActivity {
    Button buttonTread,buttonRunnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_treads_learn);
        buttonTread = findViewById(R.id.btnUsingThread);
        buttonRunnable = findViewById(R.id.btnUsingRunnable);
        buttonTread.setOnClickListener(
//                v->{
//                    MyThread myThread = new MyThread();
//                    myThread.start();
//                }
                v->{
                    new Thread(()->{
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Run the using Tread Class");

                        runOnUiThread(()->{
                            buttonRunnable.setText("Changes");
                        });

                    }).start();
                }
        );

        buttonRunnable.setOnClickListener(
                v->{
                    MyRunnable myThread = new MyRunnable();
                    myThread.run();
                }
        );
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Run the using Tread Class");
        }
    }

    class MyRunnable implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Run the using Runnable Class");
        }
    }
}