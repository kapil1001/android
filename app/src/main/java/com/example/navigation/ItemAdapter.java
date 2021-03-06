package com.example.navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<Item> mList;

    public ItemAdapter(ArrayList<Item> items){
        mList = ItemGiver.getInstance().getItems();
    }

    public void changeItems(ArrayList<Item> mList){
        this.mList = mList;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;
        public ImageView mDeleteImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.text);
            mTextView2 = itemView.findViewById(R.id.text2);
            mTextView3 = itemView.findViewById(R.id.text3);
            mTextView4 = itemView.findViewById(R.id.text4);
            mDeleteImage = itemView.findViewById(R.id.image_delete);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

        final Item currentItem = mList.get(position);
        holder.mImageView.setImageResource(currentItem.getImage());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(String.valueOf(currentItem.getAge()));
        holder.mTextView3.setText(currentItem.getText2());
        holder.mTextView4.setText(currentItem.getText3());

        holder.mDeleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemGiver giver = ItemGiver.getInstance();
                giver.deleteItem(currentItem); // error
                mList = giver.getItems();
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
