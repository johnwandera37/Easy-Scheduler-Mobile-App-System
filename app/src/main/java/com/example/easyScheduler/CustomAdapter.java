package com.example.easyScheduler;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    //creating constructor for the CustomAdapter
    private Context context;
    Activity activity;
    private ArrayList message_id, message_number, message_message, date, time;
    //want to paste all the created arraylist to MessageActivity
    CustomAdapter(Context context, Activity activity, ArrayList message_id, ArrayList message_number,
                  ArrayList message_message, ArrayList date, ArrayList time){

        //setting all these values to global variable
        this.context = context;
        this.message_id = message_id;
        this.activity = activity;
        this.message_number = message_number;
        this.message_message = message_message;
        this.date = date;
        this.time = time;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate recyclerView layout

        LayoutInflater inflater = LayoutInflater.from(context);
        //return new MyViewHolder and make View View the inflater
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder object to get string from array of these items[2nd_last]
        holder.message_number_txt.setText(String.valueOf(message_number.get(position)));
        holder.message_message_txt.setText(String.valueOf(message_message.get(position)));
        holder.date_txt.setText(String.valueOf(date.get(position)));
        holder.time_txt.setText(String.valueOf(time.get(position)));

    }

    @Override
    public int getItemCount() {

        return message_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //creating TextView Objects
        TextView message_number_txt, message_message_txt, date_txt, time_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //getting ids of the textView from recycler_row layout
            message_number_txt = itemView.findViewById(R.id.phoneNoDisplay);
            message_message_txt = itemView.findViewById(R.id.messageDisplay);
            date_txt = itemView.findViewById(R.id.dateDisplay);
            time_txt = itemView.findViewById(R.id.timeDisplay);
        }
    }
}
