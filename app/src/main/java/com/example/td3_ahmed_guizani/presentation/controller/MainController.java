package com.example.td3_ahmed_guizani.presentation.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.td3_ahmed_guizani.Constants;
import com.example.td3_ahmed_guizani.Singletons;
import com.example.td3_ahmed_guizani.presentation.model.Pokemon;
import com.example.td3_ahmed_guizani.presentation.model.RestPokemonResponse;
import com.example.td3_ahmed_guizani.presentation.view.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private MainActivity view;

    public MainController(MainActivity mainActivity, Gson gson, SharedPreferences sharedPreferences) {
        this.view = mainActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void onStart(){

        List<Pokemon> pokemonList = getDataFromCache();
        if(pokemonList != null){
            view.showList(pokemonList);
        } else {
            makeApiCall();
        }
    }

    private void makeApiCall(){

        Log.d("ahmd", "before Callback: ");
        Call<RestPokemonResponse> call = Singletons.getPokeApi().getPokemonResponse();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                Log.d("ahmd", "inside Callback ");
                if (response.isSuccessful() && response.body() != null){
                    List<Pokemon> pokemonList = response.body().getPokemon();
                    saveList(pokemonList);
                    view.showList(pokemonList);

                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                view.showError();
            }
        });


        Log.d("ahmd", "After Callback: ");
    }

    private void saveList(List<Pokemon> pokemonList) {
        String jsonString = gson.toJson(pokemonList);
        sharedPreferences
                .edit()
                .putString(Constants.KEY_POKEMON_LIST, "jsonString")
                .apply();
    }

    private List<Pokemon> getDataFromCache() {
        String jsonPokemon = sharedPreferences.getString(Constants.KEY_POKEMON_LIST, null);
        if(jsonPokemon == null){
            return null;
        } else {
            Type listType = new TypeToken<List<Pokemon>>(){}.getType();
            return gson.fromJson(jsonPokemon, listType);
        }
    }

    public void onItemClick(Pokemon pokemon){
        view.navigateToDetails(pokemon);
    }

    public void onButtonAClick(){

    }

    public void onButtonBClick(){

    }



}
