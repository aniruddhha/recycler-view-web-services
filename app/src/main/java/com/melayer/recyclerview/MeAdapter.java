package com.melayer.recyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by root on 9/2/15.
 */
public class MeAdapter extends RecyclerView.Adapter<MeAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<MeRecyclerItem> listItem;

    private Click click;

    public MeAdapter(Context context, ArrayList<MeRecyclerItem> listItem){
        this.context = context;
        this.listItem = listItem;

        this.click = new Click();


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);

        MyViewHolder holder = new MyViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.getImageView().setId(position);
        click.setHolder(holder);
        holder.getImageView().setOnClickListener(click);
        holder.getTextView().setText(listItem.get(position).getNameImage());
        holder.getImageView().setImageResource(listItem.get(position).getIdImage());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView textView;
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);

            textView = (TextView) itemView.findViewById(R.id.infoText);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public CardView getCardView() {

            return cardView;
        }

    }

    private class Click implements View.OnClickListener {

        private MyViewHolder holder;

        public MyViewHolder getHolder() {
            return holder;
        }

        public void setHolder(MyViewHolder holder) {
            this.holder = holder;
        }

        @Override
        public void onClick(View view) {

            Log.i(""+MeAdapter.class,"Layout Position - "+holder.getLayoutPosition());
            Log.i(""+MeAdapter.class,"Adapter Position - "+holder.getAdapterPosition());
            Log.i(""+MeAdapter.class,"Old Position - "+holder.getOldPosition());
            removeItemFromRecycler(holder.getAdapterPosition(),holder);
        }
    }

    public void removeItemFromRecycler(int currentPostion, MyViewHolder holder){


        currentPostion = listItem.size() - currentPostion;
        notifyItemRemoved(currentPostion);


        //setAnimation(holder.getCardView(),currentPostion);
        //notifyDataSetChanged();

        listItem.remove(currentPostion);

    }
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated

            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
    }
}
