package com.example.musicplayer;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context1;
    LayoutInflater inflater;
    CardView cardView,cardalbum;

    List<Audio> dataList;

    public RecyclerViewAdapter(Context context, List<Audio> dataList){
        this.inflater=LayoutInflater.from(context);
        this.dataList=dataList;
        context1=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        if(MainActivity.check==1||MainActivity.check==5||MainActivity.check==6||MainActivity.check==4) {
            View view = inflater.inflate(R.layout.row, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==2){
            View view = inflater.inflate(R.layout.rowalbum, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==3)
        {
            View view = inflater.inflate(R.layout.rowalbum, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        if(MainActivity.check==1||MainActivity.check==5||MainActivity.check==6||MainActivity.check==4) {
            holder.textView.setText(dataList.get(position).getTitle());
            holder.textView3.setText("Album: " + dataList.get(position).getAlbum());
            holder.textView4.setText("Artist: " + dataList.get(position).getArtist());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context1, PlayerClass.class);
                    String currentSong = dataList.get(position).getTitle();
                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("songList", (ArrayList) dataList);
                    intent.putExtra("currentSong", currentSong);
                    intent.putExtra("position", position);
                    context1.startActivity(intent);
                }
            });
        }
        if(MainActivity.check==2){
            holder.textView5.setText(dataList.get(position).getAlbum());
            cardalbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List2Fragment ldf = new List2Fragment();
                    Bundle args = new Bundle();
                    args.putString("Name", dataList.get(position).getAlbum());
                    ldf.setArguments(args);
                    ((AppCompatActivity)context1).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,ldf).commit();
                }
            });
        }
        if(MainActivity.check==3){
            holder.textView5.setText(dataList.get(position).getArtist());
            cardalbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListFragment ldf = new ListFragment();
                    Bundle args = new Bundle();
                    args.putString("Name", dataList.get(position).getArtist());
                    ldf.setArguments(args);
                    ((AppCompatActivity)context1).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,ldf).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView3,textView4,textView5;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if(MainActivity.check==1||MainActivity.check==5||MainActivity.check==6||MainActivity.check==4) {
                textView = itemView.findViewById(R.id.textView);
                textView3 = itemView.findViewById(R.id.textView3);
                textView4 = itemView.findViewById(R.id.textView4);
                cardView = itemView.findViewById(R.id.cardview);
            }
            if(MainActivity.check==2){
                textView5=itemView.findViewById(R.id.textView5);
                cardalbum=itemView.findViewById(R.id.cardview1);
            }
            if(MainActivity.check==3){
                textView5=itemView.findViewById(R.id.textView5);
                cardalbum=itemView.findViewById(R.id.cardview1);
            }
        }
    }
}
