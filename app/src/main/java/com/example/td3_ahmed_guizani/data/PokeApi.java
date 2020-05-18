package com.example.td3_ahmed_guizani.data;

import com.example.td3_ahmed_guizani.presentation.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApi {
    @GET("pokedex.json")
    Call<RestPokemonResponse> getPokemonResponse();
}
