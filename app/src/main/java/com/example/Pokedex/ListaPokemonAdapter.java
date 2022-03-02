package com.example.Pokedex;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.Pokedex.models.Pokemon;

import java.util.ArrayList;


public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder> {

    private ArrayList<Pokemon> dataset;
    private Context context;

    public ListaPokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
<<<<<<< HEAD
<<<<<<< HEAD

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    // vamos a hacer que cuando clickes es un pokemon se vuelva shynni
=======
        return  new ViewHolder(view);
    }

>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
=======
        return  new ViewHolder(view);
    }

>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());
        boolean shiny = p.isClick();

        String loadPokemon = "";
        if (p.isClick()) {
            loadPokemon = "https://www.cpokemon.com/pokes/home/shiny/";
        } else {
            loadPokemon = "https://www.cpokemon.com/pokes/home/";
        }
        Glide.with(context)
                .load(loadPokemon + p.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

   /* @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());


        Glide.with(context)
                .load("https://www.cpokemon.com/pokes/home/"+ p.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
<<<<<<< HEAD
<<<<<<< HEAD
    }*/
=======
=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
       /*Glide.with(context)
               .load("https://www.cpokemon.com/pokes/home/"+ p.getNumber() + ".png")
               .centerCrop()
               .crossFade()
               .diskCacheStrategy(DiskCacheStrategy.ALL)
               .into(holder.fotoImageView);*/
    }
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

<<<<<<< HEAD
<<<<<<< HEAD
    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView nombreTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            fotoImageView = itemView.findViewById(R.id.fotoImagenView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }
}

