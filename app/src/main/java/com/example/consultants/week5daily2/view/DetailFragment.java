package com.example.consultants.week5daily2.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.consultants.week5daily2.R;

//class to display a fragment for detailed contact info
public class DetailFragment extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvNumber = view.findViewById(R.id.tvNumber);
        TextView tvEmail = view.findViewById(R.id.tvEmail);
        //set textviews to info from bundle arguments
        tvName.setText("Name: " + getArguments().getString("name"));
        tvNumber.setText("Number: " + getArguments().getString("number"));
        tvEmail.setText("Email: " + getArguments().getString("email"));

        //ok button to dismiss detailed info fragment
        Button btnOk = view.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }
}
