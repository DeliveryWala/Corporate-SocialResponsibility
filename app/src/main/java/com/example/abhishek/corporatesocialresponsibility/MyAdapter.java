package com.example.abhishek.corporatesocialresponsibility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Abhishek on 04-12-2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {

    private String[] mDataset;
    private int[] mimgDataset;
private Context mcontext;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mimgView;
        public CardView mView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView)itemView.findViewById(R.id.info_text);
            mimgView=(ImageView)itemView.findViewById(R.id.imageView);
            mView = (CardView)itemView.findViewById(R.id.cardview);

        }
        /*
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }*/
    }
        public MyAdapter(Context context,String[] myDataset,int[] myimgDataset) {
            mDataset = myDataset;
            mimgDataset=myimgDataset;
            mcontext=context;
        }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card_view, parent, false);
        // set the view's size, margins, paddings and slayout paramete
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);
        holder.mimgView.setImageResource(mimgDataset[position]);
        holder.mView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("test", "onclick here"+position);
                if(position==0){


                }
                else if(position==1){
                    Intent i=new Intent("android.intent.action.StateGovtSchemes");
                     mcontext.startActivity(i);
                }
                else if(position==2){
                    Intent i=new Intent("android.intent.action.ProjectOutcomes");
                    mcontext.startActivity(i);

                }
                else if(position==3)
                {
                }
            }
        }) ;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}
