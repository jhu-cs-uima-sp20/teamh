package com.example.pinsplorer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FollowSwipeController extends ItemTouchHelper.Callback {

    private ArrayList<PinSet> list;
    private RecyclerView recycler;
    FollowSwipeController(ArrayList<PinSet> list, RecyclerView recycler) {
        super();
        this.list = list;
        this.recycler = recycler;
    }
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.RIGHT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
    }

    /* Callback method that is used to actually swipe the view holder.
     * Is used to stop the viewholder from swiping off the screen.
     */
    @Override
    public void onChildDraw(@NonNull Canvas c,
                            @NonNull RecyclerView recyclerView,
                            @NonNull RecyclerView.ViewHolder viewHolder,
                            float dX, float dY,
                            int actionState,
                            boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        final ColorDrawable background = new ColorDrawable(Color.CYAN);
        View item = viewHolder.itemView;
        background.setBounds(0, item.getTop(), (int) (item.getLeft() + dX), item.getBottom());
        background.draw(c);
    }
}
