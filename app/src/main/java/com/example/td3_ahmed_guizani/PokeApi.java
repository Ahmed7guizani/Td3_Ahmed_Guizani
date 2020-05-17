package com.example.td3_ahmed_guizani;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApi {
    @GET("pokedex.json")
    Call<RestPokemonResponse> getPokemonResponse();
}
