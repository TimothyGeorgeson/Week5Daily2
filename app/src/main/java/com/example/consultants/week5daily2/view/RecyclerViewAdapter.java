package com.example.consultants.week5daily2.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week5daily2.R;
import com.example.consultants.week5daily2.model.Contact;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Contact> contactList;
    private Context context;
    private FragmentManager fm;

    //constructer needed to pass in fragment manager to begin fragment with item click
    public RecyclerViewAdapter(List<Contact> contactList, Context context, FragmentManager fm) {
        this.contactList = contactList;
        this.context = context;
        this.fm = fm;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create view from list item xml
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //set information into views
        Contact contact = contactList.get(position);
        holder.tvContactName.setText(contact.getContactName());
        holder.tvPhoneNumber.setText(contact.getContactNumber());

        //add onclicklistener to display detailed info fragment
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailFragment detailFragment = new DetailFragment();
                //bundle with 3 strings to send and be shown in fragment
                Bundle bundle = new Bundle();
                bundle.putString("name", contact.getContactName());
                bundle.putString("number", contact.getContactNumber());
                bundle.putString("email", contact.getContactEmail());
                detailFragment.setArguments(bundle);
                detailFragment.show(fm, "DetailFragment");
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvContactName;
        TextView tvPhoneNumber;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContactName = itemView.findViewById(R.id.tvContactName);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
        }
    }
}
