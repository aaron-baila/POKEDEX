package com.example.Pokedex;

import android.os.Bundle;
import android.util.Log;

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
    private  ListaPokemonAdapter listaPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrofit = new Retrofit.Builder()
        //          .baseUrl("https://pokeapi.co/api/v2/")
        //         .addConverterFactory(GsonConverterFactory.create())
        //         .build();


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
    }

    public void obtenerDatos() {
        //  Log.e(" Punto ","obtener datos entrada");
        PokeApiService service = retrofit.create(PokeApiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon(151, 0);

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse( Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()) {
                    PokemonRespuesta pokemonRespuesta = response.body();
                  //  assert pokemonRespuesta != null;
                    ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();
                   // String a = listaPokemon.size() + "";

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
    }
}