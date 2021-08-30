package com.example.phonebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private List<ContactModel> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContact, this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel contactModel = listContact.get(i);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Nguyen Van A", "012121212", R.drawable.img_1);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van B", "021212121", R.drawable.img_2);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van C", "013131313", R.drawable.img_3);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van D", "031313131", R.drawable.img);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van E", "014141414", R.drawable.img);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van F", "041414141", R.drawable.img_1);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van G", "015151515", R.drawable.img_2);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van H", "051515151", R.drawable.img_3);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van I", "016161616", R.drawable.img_1);
        listContact.add(contact);
        contact = new ContactModel("Nguyen Van k", "061616161", R.drawable.img);
        listContact.add(contact);
    }
}