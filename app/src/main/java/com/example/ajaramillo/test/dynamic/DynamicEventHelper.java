package com.example.ajaramillo.test.dynamic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class DynamicEventHelper extends ItemTouchHelper.Callback {

    private DynamicEventsCallBack callback;

    public DynamicEventHelper(DynamicEventsCallBack callback) {
        this.callback = callback;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {

        int dragsFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.END | ItemTouchHelper.START;

        return makeMovementFlags(dragsFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        callback.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        callback.removeItem(viewHolder.getAdapterPosition());

    }

    public interface DynamicEventsCallBack
    {

        void onItemMove(int initialPosition, int finalPosition);
        void removeItem(int position);

    }


}
