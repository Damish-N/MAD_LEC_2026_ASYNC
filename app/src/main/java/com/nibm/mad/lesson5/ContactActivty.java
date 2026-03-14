package com.nibm.mad.lesson5;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.nibm.mad.R;

import java.util.ArrayList;

public class ContactActivty extends AppCompatActivity {

    private static final int REQ_READ_CONTACTS = 1001;

    private ListView listContacts;
    private ArrayAdapter<String> adapter;
    private final ArrayList<String> contactItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts_view);
        this.getSupportActionBar().hide();
        listContacts = findViewById(R.id.listContacts);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contactItems);
        listContacts.setAdapter(adapter);

        checkPermissionAndLoadContacts();

    }
    private void checkPermissionAndLoadContacts() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            loadContacts();
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    REQ_READ_CONTACTS
            );
        }
    }

    private void loadContacts() {
        contactItems.clear();
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                },
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        );
        if (cursor != null) {
            int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            while (cursor.moveToNext()) {
                String name = cursor.getString(nameIndex);
                String number = cursor.getString(numberIndex);
                contactItems.add(name + "  -  " + number);
            }
            cursor.close();
        }

        adapter.notifyDataSetChanged();

        Toast.makeText(this, "Loaded " + contactItems.size() + " contacts", Toast.LENGTH_SHORT).show();
    }
}
