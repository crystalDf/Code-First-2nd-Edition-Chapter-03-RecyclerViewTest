package com.star.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fruit_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.mFruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(parent.getContext(), "view " + fruit.getName(), Toast.LENGTH_LONG)
                        .show();
            }
        });

        holder.mFruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(parent.getContext(), "image " + fruit.getName(), Toast.LENGTH_LONG)
                        .show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Fruit fruit = mFruitList.get(position);

        holder.mFruitImage.setImageResource(fruit.getImageId());
        holder.mFruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private View mFruitView;

        private ImageView mFruitImage;
        private TextView mFruitName;

        public ViewHolder(View itemView) {
            super(itemView);

            mFruitView = itemView;

            mFruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            mFruitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
