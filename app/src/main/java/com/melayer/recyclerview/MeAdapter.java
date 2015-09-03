package com.melayer.recyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 9/2/15.
 */
public class MeAdapter extends RecyclerView.Adapter<MeAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<MeRecyclerItem> listItem;

    public MeAdapter(Context context, ArrayList<MeRecyclerItem> listItem){
        this.context = context;
        this.listItem = listItem;
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

    public void removeItemFromRecycler(int currentPostion){

        listItem.remove(currentPostion);
        notifyDataSetChanged();
    }

    public void haveFreshDataset(ArrayList<MeRecyclerItem> listItem){
        this.listItem.clear();
        this.listItem = new ArrayList<>(listItem);
        notifyDataSetChanged();
    }

    public void printListSize(){

        Log.i(MeAdapter.class.toString(),"Size of list is "+listItem.size());
    }
}
