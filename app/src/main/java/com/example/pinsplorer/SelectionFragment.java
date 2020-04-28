package com.example.pinsplorer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectionFragment extends Fragment {

    protected static RecyclerView SelectionRecycler;
    protected static ArrayList<PinSet> CombinedList;

    public SelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        CombinedList.addAll(SavedFragment.PinSetList);
        CombinedList.addAll(FollowFragment.PinSetFollowedList);

        SelectionRecycler = getView().findViewById(R.id.selectionRecycler);
        SelectionRecycler.setAdapter(new SelectionAdapter(CombinedList));
        SelectionRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}
