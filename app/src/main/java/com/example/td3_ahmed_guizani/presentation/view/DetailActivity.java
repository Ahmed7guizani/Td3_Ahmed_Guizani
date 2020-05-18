package com.example.td3_ahmed_guizani.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.td3_ahmed_guizani.R;
import com.example.td3_ahmed_guizani.Singletons;
import com.example.td3_ahmed_guizani.presentation.model.Pokemon;

public class DetailActivity extends AppCompatActivity {

   private ImageView imgDetail;
    private TextView nmDetail;
    private TextView hgDetail;
    private TextView wgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

       imgDetail =(ImageView) findViewById(R.id.icon_detail);
        nmDetail= (TextView) findViewById(R.id.name_detail);
        hgDetail= (TextView) findViewById(R.id.height);
        wgDetail = (TextView) findViewById(R.id.weight);
        Intent intent = getIntent();
        String pokemonJson= intent.getStringExtra("pokemonKey");
        Pokemon pokemon = Singletons.getGson().fromJson(pokemonJson, Pokemon.class);
           showDetail(pokemon);     
    }

    private void showDetail(Pokemon pokemon) {
      Glide.with(getApplicationContext()).load(pokemon.getImg()).into(imgDetail);
        nmDetail.setText(pokemon.getName());
        hgDetail.setText(pokemon.getHeight());
        wgDetail.setText(pokemon.getWeight());

    }

}
