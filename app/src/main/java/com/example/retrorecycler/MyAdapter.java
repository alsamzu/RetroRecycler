package com.example.retrorecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder>{

   public List<BusInfo> dataList;

    public OnBusListener nonBusListener;


    public MyAdapter(List<BusInfo> dataList, OnBusListener nonBusListener) {
        this.dataList = dataList;
        this.nonBusListener = nonBusListener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final View myView;

        TextView bus_details;
        TextView bus_title;
        OnBusListener onBusListener;

        CustomViewHolder(View itemView, OnBusListener onBusListener){

            super(itemView);

            myView = itemView;

            bus_details = myView.findViewById(R.id.bus_details);
            bus_title = myView.findViewById(R.id.bus_title);

            this.onBusListener = onBusListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onBusListener.onBusClick(getAdapterPosition());

        }
    }

    public interface OnBusListener{
        void onBusClick(int position);
    }


    @Override
    public CustomViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);

        CustomViewHolder vh =  new CustomViewHolder(view, nonBusListener);
        return vh;
    }

    @Override
    public void onBindViewHolder( CustomViewHolder holder, int position) {

        holder.bus_title.setText(""+dataList.get(position).getId());
        holder.bus_details.setText(dataList.get(position).getBusdetials());
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }



}


