package com.example.musicplayer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListFragment extends Fragment {


    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Audio> audioData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_list, container, false);
        String value = getArguments().getString("Name");
        audioData=new ArrayList<>();
        MainActivity.check=5;

        recyclerView=view.findViewById(R.id.ListRecyclerView);
        recyclerView.setHasFixedSize(true);
        for(int j=0;j<MainActivity.audioList.size();j++){
            if(MainActivity.audioList.get(j).getArtist().equalsIgnoreCase(value))
            {
                audioData.add(new Audio(MainActivity.audioList.get(j).getData(),
                        MainActivity.audioList.get(j).getTitle(),
                        MainActivity.audioList.get(j).getAlbum(),
                        MainActivity.audioList.get(j).getArtist()));
            }
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter=new RecyclerViewAdapter(getContext(),audioData);
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}