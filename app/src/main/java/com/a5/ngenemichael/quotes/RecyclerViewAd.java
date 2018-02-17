package com.a5.ngenemichael.quotes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewAd extends RecyclerView.Adapter<RecyclerViewAd.MyViewHolder> {

    private  List<Quotes> mQuotes;int count = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView quote, name, id;
        public ImageView favorite, sample;
        public MyViewHolder(View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.title);
            name = (TextView) itemView.findViewById(R.id.name);
            id = (TextView) itemView.findViewById(R.id.id);
            favorite  = (ImageView) itemView.findViewById(R.id.like);
            sample  = (ImageView) itemView.findViewById(R.id.sample);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent i = new Intent(context,SingleView.class);
                    i.putExtra("key",getAdapterPosition());
                    context.startActivity(i);
                }
            });
        }

    }
    public RecyclerViewAd (List<Quotes> mquotes){
        this.mQuotes = mquotes;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
    Quotes quotes = mQuotes.get(position);
        holder.quote.setText(quotes.getQuote());
       holder.quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),SingleView.class);
                i.putExtra("key",position);
                v.getContext().startActivity(i);
            }
        });
        holder.name.setText(quotes.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),SingleView.class);
                i.putExtra("key",position);
                v.getContext().startActivity(i);
            }
        });
        holder.id.setText(quotes.getId());
        holder.id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),SingleView.class);
                i.putExtra("key",position);
                v.getContext().startActivity(i);
            }
        });
        holder.sample.setImageResource(R.drawable.abc_btn_rating_star_off_mtrl_alpha);
        holder.favorite.setImageResource(quotes.getLike());
        holder.favorite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(holder.favorite.getResources()== holder.sample.getResources()){
                holder.favorite.setImageResource(R.drawable.abc_ratingbar_full_material);
                holder.favorite.setBackgroundResource(R.drawable.fvgb2);}
                else{
                    holder.favorite.setImageResource(R.drawable.abc_btn_rating_star_off_mtrl_alpha);
                    holder.favorite.setBackgroundResource(R.drawable.fvgb);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }


}
