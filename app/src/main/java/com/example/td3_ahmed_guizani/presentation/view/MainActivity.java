package com.example.td3_ahmed_guizani.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.td3_ahmed_guizani.R;
import com.example.td3_ahmed_guizani.Singletons;
import com.example.td3_ahmed_guizani.presentation.controller.MainController;
import com.example.td3_ahmed_guizani.presentation.model.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferencesInstance(getApplicationContext())
        );
        controller.onStart();
    }



    public void showList(List<Pokemon> pokemonList) {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new ListAdapter(pokemonList, getApplicationContext(), new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pokemon item) {
                controller.onItemClick(item);

            }
        });
        recyclerView.setAdapter(mAdapter);
    }





    public void showError() {
        Toast.makeText(getApplicationContext(), "Api Error", Toast.LENGTH_SHORT).show();
    }


    public void navigateToDetails(Pokemon pokemon) {
        Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
        myIntent.putExtra("pokemonKey", Singletons.getGson().toJson(pokemon));
        MainActivity.this.startActivity(myIntent);
    }
}
