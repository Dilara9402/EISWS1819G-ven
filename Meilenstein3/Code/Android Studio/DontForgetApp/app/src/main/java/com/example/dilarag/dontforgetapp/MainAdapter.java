package com.example.dilarag.dontforgetapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.ViewHolder> {

    private ArrayList<Gerät> geraeteListe;

    public MainAdapter(ArrayList<Gerät> geraeteListe) {
        this.geraeteListe = geraeteListe;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    // onBindViewHolder binds a model to a viewholder
    @Override
    public void onBindViewHolder( MainAdapter.ViewHolder holder, int pos) {
        final int position = pos;
        Gerät currentGerät = geraeteListe.get(pos);
        holder.title.setText(currentGerät.print());
    }

    @Override
    public int getItemCount() {
        return geraeteListe.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
