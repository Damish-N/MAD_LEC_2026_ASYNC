package com.nibm.mad.lesson8;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nibm.mad.R;

public class DBActivity extends AppCompatActivity {

    DBHelper dbHelper ;

    EditText userName,age;

    Button insertButton,viewButton;

    TextView viewUsersTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dbactivity);

        this.getSupportActionBar().hide();

        userName = findViewById(R.id.userName);
        age = findViewById(R.id.userAge);
        insertButton = findViewById(R.id.insertBtn);

        dbHelper = new DBHelper(this);

        insertButton.setOnClickListener(
                v->{
                  Boolean re =   dbHelper.insertData(userName.getText().toString(),
                            age.getText().toString());
                    Toast.makeText(
                            this,
                            re ? "Inserted ": "Failed",
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );
        viewButton = findViewById(R.id.viewBtn);
        viewUsersTextView = findViewById(R.id.viewUsersTextView);
        viewButton.setOnClickListener(
                v->{
                    Cursor cursor = dbHelper.getData();
                    StringBuilder stringBuilder = new StringBuilder();

                    while (cursor.moveToNext()){
                        stringBuilder.append("ID").append(cursor.getInt(0)).append("\n");
                        stringBuilder.append("Name").append(cursor.getString(1)).append("\n");
                        stringBuilder.append("Age").append(cursor.getInt(2)).append("\n\n");
                    }
                    viewUsersTextView.setText(stringBuilder.toString());
                }
        );

    }
}