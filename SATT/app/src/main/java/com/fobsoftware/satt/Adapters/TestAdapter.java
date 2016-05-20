package com.fobsoftware.satt.Adapters;

import android.database.DataSetObserver;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fobsoftware.satt.Entities.Sensores;
import com.fobsoftware.satt.R;

import java.util.List;

/**
 * Created by danielordonez on 5/19/16.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private List<Sensores> mDataset;
    private TextView id,user,title;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout layout;
        public ViewHolder(LinearLayout v) {
            super(v);
            layout=v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TestAdapter(List<Sensores> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mini_album, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Sensores sensor = mDataset.get(position);
        title = (TextView)holder.layout.findViewById(R.id.tvTitle);

        id = (TextView)holder.layout.findViewById(R.id.tvId);

        user = (TextView)holder.layout.findViewById(R.id.tvUserId);
        Log.d("fill",title+"-"+id+"-"+user);
       title.setText(sensor.title);
        id.setText(sensor.id+"");
        user.setText(sensor.userId+"");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}