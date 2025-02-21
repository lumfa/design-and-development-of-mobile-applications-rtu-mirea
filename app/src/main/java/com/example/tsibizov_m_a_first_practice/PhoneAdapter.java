package com.example.tsibizov_m_a_first_practice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PhoneAdapter extends ArrayAdapter<Person> {
    private final Context context;
    private final Person[] person;

    public PhoneAdapter(Context context, Person[] person) {
        super(context, R.layout.item, person);
        this.context = context;
        this.person = person;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(this.person[position].getName());

        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(this.person[position].getPhone());

        ImageView contact_image = (ImageView) view.findViewById(R.id.contact_image);
        contact_image.setImageResource(R.drawable.img);

        contact_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toContactInfo = new Intent(context, ContactActivity.class);
                toContactInfo.putExtra("name", person[position].getName());
                toContactInfo.putExtra("phone", person[position].getPhone());
                context.startActivity(toContactInfo);
            }
        });

        return view;
    }
}
