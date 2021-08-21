package com.example.musicplayer;

import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {
    RecyclerView recyclerView;
    private  RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Audio> audioAlbum;

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_album,container,false);
        recyclerView=view.findViewById(R.id.AlbumRecyclerView);
        recyclerView.setHasFixedSize(true);
        MainActivity.check=2;
        audioAlbum=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        int count[];

        count=new int[MainActivity.audioList.size()];
        for(int i=0;i<MainActivity.audioList.size();i++){
            count[i]=0;
        }
        for(int i=0;i<MainActivity.audioList.size();i++){
            for(int j=0;j<=i;j++){
                if(MainActivity.audioList.get(j).getAlbum().equalsIgnoreCase(MainActivity.audioList.get(i).getAlbum())){
                    count[i]++;
                }
            }

            }
        for(int i=0;i<MainActivity.audioList.size();i++) {
            if (count[i] == 1) {
                audioAlbum.add(new Audio(MainActivity.audioList.get(i).getData(),
                        MainActivity.audioList.get(i).getTitle(),
                        MainActivity.audioList.get(i).getAlbum(),
                        MainActivity.audioList.get(i).getArtist()));
            }
        }
        recyclerViewAdapter=new RecyclerViewAdapter(getContext(),audioAlbum);
        recyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }
}
