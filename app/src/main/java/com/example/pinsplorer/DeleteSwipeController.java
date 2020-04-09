package com.example.pinsplorer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteSwipeController extends ItemTouchHelper.Callback {
    private ArrayList<PinSet> setList;
    private ArrayList<Pin> pinList;
    private boolean isPinList;
    private RecyclerView recycler;
    DeleteSwipeController(ArrayList<PinSet> list, RecyclerView recycler) {
        this.isPinList = false;
        this.setList = list;
        this.recycler = recycler;
    }
    // Need to have superfluous parameter or constructor has same erasure as previous
    DeleteSwipeController(ArrayList<Pin> list, RecyclerView recycler, boolean isPinList) {
        super();
        this.isPinList = true;
        this.pinList = list;
        this.recycler = recycler;
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.LEFT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (isPinList) {
            pinList.remove(viewHolder.getAdapterPosition());
        } else {
            setList.remove(viewHolder.getAdapterPosition());
        }
        recycler.getAdapter().notifyDataSetChanged();
    }
}
