package com.example.Pokedex.models;

import java.util.ArrayList;

public class PokemonRespuesta {
    private ArrayList<Pokemon> results = new ArrayList<Pokemon>();

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
