package com.example.retrorecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        Intent intent = getIntent();
        BusInfo busInfo = intent.getParcelableExtra("example");

        int id = busInfo.getId();
        String details = busInfo.getBusdetials();

        TextView ida = findViewById(R.id.id_text_view);
        TextView detail = findViewById(R.id.details_text_view);

        ida.setText(id);
        detail.setText(details);

    }
}
