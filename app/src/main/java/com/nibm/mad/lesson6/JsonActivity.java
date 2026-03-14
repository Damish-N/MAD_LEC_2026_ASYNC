package com.nibm.mad.lesson6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nibm.mad.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonActivity extends AppCompatActivity {

    UserAdaptor userAdaptor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json);

        List<User> userList = new ArrayList<>();
        User user= new User(1,"Test","test@gmail.com");
        User user1= new User(1,"Test","test@gmail.com");

        userList.add(user);
        userList.add(user1);
        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userAdaptor = new UserAdaptor();
        recyclerView.setAdapter(userAdaptor);


//        userAdaptor.setUsers(userList);

        loadUsers();

    }

    private void loadUsers() {
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);

//        new Thread(()->{
            Call<List<User>>call = apiService.getUsers();
//
//            try {
//                Response<List<User>> response = call.execute();
//                runOnUiThread(()->{
//                    userAdaptor.setUsers(response.body());
//
//                });
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
        call.enqueue(
                new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        runOnUiThread(
                                ()->{
                                    userAdaptor.setUsers(response.body());
                                }
                        );
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {

                    }
                }
        );
    }
}