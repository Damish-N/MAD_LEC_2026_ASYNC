package com.nibm.mad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.lesson4.Lesson4Activity;
import com.nibm.mad.lesson4.TestListView;
import com.nibm.mad.lesson4.TestRecycleView;
import com.nibm.mad.lesson4.TreadsLearn;
import com.nibm.mad.lesson5.ContactActivty;
import com.nibm.mad.lesson5.TaskAsync;
import com.nibm.mad.lesson6.JsonActivity;
import com.nibm.mad.lesson7.MapActivity;
import com.nibm.mad.lesson7.MapCurrentLocation;
import com.nibm.mad.lesson8.DBActivity;
import com.nibm.mad.threads.TreadActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Button btnLesson3 = findViewById(R.id.btnLesson3);

        btnLesson3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Lesson4Activity.class);
            startActivity(intent);
        });

        Button btnLesson4 = findViewById(R.id.btnLesson4);

        btnLesson4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TreadActivity.class);
            startActivity(intent);
        });


        Button btnLesson4Test = findViewById(R.id.btnLesson4Test);

        btnLesson4Test.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TestListView.class);
            startActivity(intent);
        });

        Button testBtnRecycle = findViewById(R.id.testBtnRecycle);

        testBtnRecycle.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TestRecycleView.class);
            startActivity(intent);
        });

        Button testBtnTread = findViewById(R.id.testBtnThread);

        testBtnTread.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TreadsLearn.class);
            startActivity(intent);
        });

        Button textAsyncTaskBtn = findViewById(R.id.testAsyncTaskBtn);

        textAsyncTaskBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TaskAsync.class);
            startActivity(intent);
        });

        Button textContactActitvty = findViewById(R.id.testContactActivity);

        textContactActitvty.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContactActivty.class);
            startActivity(intent);
        });

        Button testApiCall = findViewById(R.id.testApiCall);

        testApiCall.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, JsonActivity.class);
            startActivity(intent);
        });

        Button testCallMap = findViewById(R.id.testCallMap);

        testCallMap.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapCurrentLocation.class);
            startActivity(intent);
        });

        Button testDB = findViewById(R.id.testDB);

        testDB.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DBActivity.class);
            startActivity(intent);
        });

    }
}