package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class MSAdapter extends  RecyclerView.Adapter<MSAdapter.ViewHolder>
{
    private ArrayList<String> card ;
    private ArrayList<Integer> cardimg ;


    public MSAdapter(ArrayList<String> card, ArrayList cardimg) {
        this.card = card;
        this.cardimg = cardimg;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.text.setText(card.get(i));
        viewHolder.img.setImageResource(cardimg.get(i));
    }

    @Override
    public int getItemCount() {

        return card.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        private ImageView img;
        public ViewHolder(View view) {
            super(view);


            text = (TextView)view.findViewById(R.id.cardtext);
            img = (ImageView)view.findViewById(R.id.cardimg);
        }
    }


}