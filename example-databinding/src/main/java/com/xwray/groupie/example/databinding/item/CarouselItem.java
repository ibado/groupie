package com.xwray.groupie.example.databinding.item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.xwray.groupie.GroupieAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;
import com.xwray.groupie.databinding.BindableItem;
import com.xwray.groupie.databinding.GroupieViewHolder;
import com.xwray.groupie.example.databinding.R;
import com.xwray.groupie.example.databinding.databinding.ItemCarouselBinding;

/**
 * A horizontally scrolling RecyclerView, for use in a vertically scrolling RecyclerView.
 */
public class CarouselItem extends BindableItem<ItemCarouselBinding> implements OnItemClickListener {

    private GroupieAdapter adapter;
    private RecyclerView.ItemDecoration carouselDecoration;

    public CarouselItem(RecyclerView.ItemDecoration itemDecoration, GroupieAdapter adapter) {
        this.carouselDecoration = itemDecoration;
        this.adapter = adapter;
        adapter.setOnItemClickListener(this);
    }

    @Override
    public GroupieViewHolder<ItemCarouselBinding> createViewHolder(@NonNull View itemView) {
        GroupieViewHolder<ItemCarouselBinding> viewHolder = super.createViewHolder(itemView);
        RecyclerView recyclerView = viewHolder.binding.recyclerView;
        recyclerView.addItemDecoration(carouselDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        return viewHolder;
    }

    @Override public void bind(@NonNull ItemCarouselBinding viewBinding, int position) {
        viewBinding.recyclerView.setAdapter(adapter);
    }

    @Override public int getLayout() {
        return R.layout.item_carousel;
    }

    @Override
    public void onItemClick(Item item, View view) {
        adapter.remove(item);
    }
}
