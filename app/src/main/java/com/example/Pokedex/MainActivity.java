package com.example.Pokedex;

import android.os.Bundle;
import android.util.Log;
<<<<<<< HEAD
<<<<<<< HEAD
import android.view.View;
import android.widget.Button;
=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Pokedex.models.Pokemon;
import com.example.Pokedex.models.PokemonRespuesta;
import com.example.Pokedex.pokeApi.PokeApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Pokedex";
    private Retrofit retrofit;
    private RecyclerView recyclerView;
<<<<<<< HEAD
<<<<<<< HEAD
    private ListaPokemonAdapter listaPokemonAdapter;

    private Button botonShiny;

    private ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
=======
    private  ListaPokemonAdapter listaPokemonAdapter;
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
=======
    private  ListaPokemonAdapter listaPokemonAdapter;
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrofit = new Retrofit.Builder()
        //          .baseUrl("https://pokeapi.co/api/v2/")
        //         .addConverterFactory(GsonConverterFactory.create())
        //         .build();
<<<<<<< HEAD



=======


>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaPokemonAdapter = new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
<<<<<<< HEAD
<<<<<<< HEAD
        botonShiny = findViewById(R.id.btnShiny);
        botonShiny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pokemon p = new Pokemon();
                p.setClick(!p.isClick());
                obtenerDatos();
            }
        });

        listaPokemonAdapter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            int idPokemon = listaPokemon.get(recyclerView.getChildAdapterPosition(view)).getNumber();
            boolean booleanPokemon = listaPokemon.get(recyclerView.getChildAdapterPosition(view)).isClick();

               // listaPokemon.get(recyclerView.getChildAdapterPosition(view)).setClick(!booleanPokemon);
                //listaPokemon.get(recyclerView.getChildAdapterPosition(view)).setClick(!listaPokemon.get(recyclerView.getChildAdapterPosition(view)).isClick());

                 //  obtenerDatos();

            }
        });

=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
    }



    public void obtenerDatos() {

        //  Log.e(" Punto ","obtener datos entrada");
        PokeApiService service = retrofit.create(PokeApiService.class);

        Call<PokemonRespuesta> pokemonRespuestaCall =
                service.obtenerListaPokemon(898, 0);


        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse( Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()) {
                    PokemonRespuesta pokemonRespuesta = response.body();
<<<<<<< HEAD
<<<<<<< HEAD

                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

=======
                  //  assert pokemonRespuesta != null;
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                   // String a = listaPokemon.size() + "";
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
=======
                  //  assert pokemonRespuesta != null;
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                   // String a = listaPokemon.size() + "";
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)

                    listaPokemonAdapter.adicionarListaPokemon(listaPokemon);


                } else {
                    Log.e(TAG, " ERROR");
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e(TAG, " ERROR");
            }
        });
<<<<<<< HEAD


=======
>>>>>>> parent of ea3b539 (clickable las fotos y sale el nombre)
    }
}