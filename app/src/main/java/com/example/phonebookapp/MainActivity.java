package com.example.phonebookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvContact;
    private List<ContactModel> listContact = new ArrayList<>();

    private ContactAdapter adapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        initView();

        adapter = new ContactAdapter(this, listContact);
        adapter.registerChildItemClick(this::onItemChildClick);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel contactModel = listContact.get(i);
                Toast.makeText(MainActivity.this, contactModel.getName() + ":" +contactModel.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onItemChildClick(int i) {
        ContactModel contactModel = listContact.get(i);
        ivUser.setImageResource(contactModel.getImage());
        tvName.setText(contactModel.getName());
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData() {
        listContact.add(new ContactModel("Nguyen Van A", "012121212", R.drawable.img_1));
        listContact.add(new ContactModel("Nguyen Van B", "021212121", R.drawable.img_2));
        listContact.add(new ContactModel("Nguyen Van C", "013131313", R.drawable.img_3));
        listContact.add(new ContactModel("Nguyen Van D", "031313131", R.drawable.img));
        listContact.add(new ContactModel("Nguyen Van A", "012121212", R.drawable.img_1));
        listContact.add(new ContactModel("Nguyen Van B", "021212121", R.drawable.img_2));
        listContact.add(new ContactModel("Nguyen Van C", "013131313", R.drawable.img_3));
        listContact.add(new ContactModel("Nguyen Van D", "031313131", R.drawable.img));
        listContact.add(new ContactModel("Nguyen Van A", "012121212", R.drawable.img_1));
        listContact.add(new ContactModel("Nguyen Van B", "021212121", R.drawable.img_2));
        listContact.add(new ContactModel("Nguyen Van C", "013131313", R.drawable.img_3));
        listContact.add(new ContactModel("Nguyen Van D", "031313131", R.drawable.img));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        adapter.unRegisterChildItemClick();
    }
}