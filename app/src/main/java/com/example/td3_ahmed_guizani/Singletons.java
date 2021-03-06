package com.example.td3_ahmed_guizani;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.td3_ahmed_guizani.data.PokeApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Singletons {

    private static Gson gsonInstance;
    private static PokeApi pokeApiInstance;
    private static SharedPreferences sharedPreferencesInstance;

    public static Gson getGson(){
        if(gsonInstance == null){
            gsonInstance = new GsonBuilder()
                    .setLenient()
                    .create();
        }
        return gsonInstance;
    }

    public static PokeApi getPokeApi(){
        if(pokeApiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();

            pokeApiInstance = retrofit.create(PokeApi.class);
        }
        return pokeApiInstance;
    }


    public static SharedPreferences getSharedPreferencesInstance(Context context){
        if(sharedPreferencesInstance == null){
            sharedPreferencesInstance = context. getSharedPreferences("application_esiea", Context.MODE_PRIVATE);
        }
        return sharedPreferencesInstance;
    }

}
