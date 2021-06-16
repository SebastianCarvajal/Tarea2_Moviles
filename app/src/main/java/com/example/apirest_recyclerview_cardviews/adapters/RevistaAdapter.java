package com.example.apirest_recyclerview_cardviews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.example.apirest_recyclerview_cardviews.R;
import com.example.apirest_recyclerview_cardviews.models.revista;


public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.ViewHolderDIS>{
    private int resource;
    private ArrayList<revista> revistaList;
    private Context ctx;

    public RevistaAdapter(ArrayList<revista> revistaList_, int resource_, Context ctx_){
        this.resource = resource_;
        this.revistaList = revistaList_;
        this.ctx = ctx_;
    }

    @NonNull
    @Override
    public ViewHolderDIS onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new RevistaAdapter.ViewHolderDIS(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDIS holder, int position) {
        revista revista = revistaList.get(position);
        holder.txtTitle.setText(revista.getTitle());
        holder.txtVolume.setText(String.valueOf(revista.getVolume()));
        holder.txtNumber.setText(String.valueOf(revista.getNumber()));
        holder.txtYear.setText("("+String.valueOf(revista.getYear())+")");

        Glide.with(ctx)
                .load(revista.getCover())
                //.load("https://s22.postimg.cc/572fvlmg1/vlad-baranov-767980-unsplash.jpg")
                .into(holder.imgPortada);


    }

    @Override
    public int getItemCount() {
        return revistaList.size();
    }


    public class ViewHolderDIS extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtVolume;
        private TextView txtNumber;
        private TextView txtYear;
        private ImageView imgPortada;

        public View view;

        public ViewHolderDIS(View view){
            super(view);
            this.imgPortada = (ImageView) view.findViewById(R.id.imgViewPortada);
            this.txtTitle = (TextView) view.findViewById(R.id.txtViewTitulo);
            this.txtVolume = (TextView) view.findViewById(R.id.txtviewVol);
            this.txtNumber = (TextView) view.findViewById(R.id.txtviewNum);
            this.txtYear = (TextView) view.findViewById(R.id.txtviewYear);
        }
    }

}
