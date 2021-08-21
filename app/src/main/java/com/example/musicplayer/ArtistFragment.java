package com.example.musicplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArtistFragment extends Fragment {
    RecyclerView recyclerView;
    private  RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Audio> artistAlbum;

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_artist,container,false);
        recyclerView=view.findViewById(R.id.ArtistRecyclerView);
        recyclerView.setHasFixedSize(true);
        MainActivity.check=3;
        artistAlbum=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        int count[];

        count=new int[MainActivity.audioList.size()];
        for(int i=0;i<MainActivity.audioList.size();i++){
            count[i]=0;
        }
        for(int i=0;i<MainActivity.audioList.size();i++){
            for(int j=0;j<=i;j++){
                if(MainActivity.audioList.get(j).getArtist().equalsIgnoreCase(MainActivity.audioList.get(i).getArtist())){
                    count[i]++;
                }
            }

        }
        for(int i=0;i<MainActivity.audioList.size();i++) {
            if (count[i] == 1) {
                artistAlbum.add(new Audio(MainActivity.audioList.get(i).getData(),
                        MainActivity.audioList.get(i).getTitle(),
                        MainActivity.audioList.get(i).getAlbum(),
                        MainActivity.audioList.get(i).getArtist()));
            }
        }
        recyclerViewAdapter=new RecyclerViewAdapter(getContext(),artistAlbum);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}
