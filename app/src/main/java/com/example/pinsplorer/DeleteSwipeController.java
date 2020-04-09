package com.example.pinsplorer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeleteSwipeController extends ItemTouchHelper.Callback {
    private ArrayList<PinSet> list;
    private RecyclerView recycler;
    DeleteSwipeController(ArrayList<PinSet> list, RecyclerView recycler) {
        this.list = list;
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
        list.remove(viewHolder.getAdapterPosition());
        recycler.getAdapter().notifyDataSetChanged();
    }
}
