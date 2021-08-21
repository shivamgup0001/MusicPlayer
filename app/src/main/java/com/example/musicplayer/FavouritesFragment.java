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

public class FavouritesFragment extends Fragment {
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Audio> audioFav;

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_favourites,container,false);

        MainActivity.check=4;
        audioFav=new ArrayList<>();
        recyclerView=view.findViewById(R.id.FavoriteRecyclerView);
        recyclerView.setHasFixedSize(true);

        FavDb db = new FavDb(getContext());
        audioFav =(ArrayList<Audio>) db.getalldata();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter=new RecyclerViewAdapter(getContext(),audioFav);
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}
