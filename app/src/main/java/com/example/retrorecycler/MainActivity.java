package com.example.retrorecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnBusListener {

        private MyAdapter myAdapter;
        private RecyclerView myRecyclerView;
         private List<BusInfo> dataList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

          BusApiHolder service = RetrofitClient.getRetrofitInstance().create(BusApiHolder.class);
            Call<List<BusInfo>> call = service.getAllBuses();

            call.enqueue(new Callback<List<BusInfo>>() {
                @Override
                public void onResponse(Call<List<BusInfo>> call, Response<List<BusInfo>> response) {

                    loadDataList(response.body());
                }

                @Override
                public void onFailure(Call<List<BusInfo>> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();


                }
            });
        }

        private void loadDataList(List<BusInfo> busList) {

            myRecyclerView = findViewById(R.id.myRecyclerView);
            myAdapter = new MyAdapter(busList,this);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            myRecyclerView.setLayoutManager(layoutManager);
            myRecyclerView.setAdapter(myAdapter);

        }


                @Override
                public void onBusClick(int position){


                    Intent intent = new Intent(MainActivity.this,BusActivity.class);
                    intent.putExtra("example",dataList.get(position));

                    startActivity(intent);
                }
}
