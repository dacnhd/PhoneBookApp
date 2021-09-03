package com.example.phonebookapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<ContactModel> listContacts;
    private Context context;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(Context context, List<ContactModel> listContacts) {
        this.context = context;
        this.listContacts = listContacts;
    }


    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(R.layout.item_contact, null);

            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) view.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) view.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
            holder.btCall =(Button) view.findViewById(R.id.btCall);
            holder.btEdit = (Button) view.findViewById(R.id.btEdit);
            view.setTag(holder);
        }
        ViewHolder holder =(ViewHolder) view.getTag();
        ContactModel model = listContacts.get(i);
        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhone());
        holder.ivAvatar.setImageResource(model.getImage());

        holder.btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(i);
            }
        });

        holder.btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnChildItemClick.onItemChildClick(i);
            }
        });

        return view;
    }

    private void onCall(int i) {
        ContactModel contact = listContacts.get(i);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contact.getPhone()));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            return;
        }
        context.startActivity(intent);
    }

    public void registerChildItemClick(IOnChildItemClick iOnChildItemClick) {
        this.iOnChildItemClick = iOnChildItemClick;
    }

    public void unRegisterChildItemClick(){
        this.iOnChildItemClick = null;
    }



    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        Button btCall;
        Button btEdit;
    }
}
