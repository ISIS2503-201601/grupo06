package com.fobsoftware.satt.Adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fobsoftware.satt.Entities.Boletin;
import com.fobsoftware.satt.Entities.Evento;
import com.fobsoftware.satt.Entities.Sensor;
import com.fobsoftware.satt.R;

import java.util.List;

/**
 * Created by danielordonez on 5/19/16.
 */
public class BoletinAdapter extends RecyclerView.Adapter<BoletinAdapter.ViewHolder> {
    private List<Boletin> mDataset;
    private TextView numero, zona,perfil,altura,tiempo;
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
    public BoletinAdapter(List<Boletin> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BoletinAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mini_boletin, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder((LinearLayout) v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Boletin boletin = mDataset.get(position);

        numero = (TextView)holder.layout.findViewById(R.id.tvNumero);
        zona = (TextView)holder.layout.findViewById(R.id.tvZona);

        altura = (TextView)holder.layout.findViewById(R.id.tvAltura);

        tiempo = (TextView)holder.layout.findViewById(R.id.tvTiempo);

        perfil = (TextView)holder.layout.findViewById(R.id.tvPerfil);

        numero.setText("Boletin "+boletin.id);
        tiempo.setText("Tiempo de llegada: "+boletin.tiempo+" horas");
        zona.setText("Zona Geográfica: "+boletin.zona);

        altura.setText("Altura de ola: "+boletin.altura+" metros");
        perfil.setText("Perfil de acción: "+boletin.perfil);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}