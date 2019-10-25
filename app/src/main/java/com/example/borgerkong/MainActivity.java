package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedHashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private Button btn;
    private List<Food> foods;
    private FoodAdapter adapter;

    private void bind(){
        rv = (RecyclerView)findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        btn = (Button)findViewById(R.id.button);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind();
    }

    private void initMenu(){
        if (Data.getFoods().size() == 0){
            Data.getFoods().add(new Food("Hunmurger", "Delicious vegetable burger", 0, R.drawable.hamburger, 2.45));
            Data.getFoods().add(new Food("Egg", "Excellent proteinizer", 0, R.drawable.egg, 0.25));
            Data.getFoods().add(new Food("Beefsoup", "Delicious beef soup, cheap and lots", 0, R.drawable.beefsoup, 1.79));
            Data.getFoods().add(new Food("Burrito", "Very recommended very delicious burritos", 0, R.drawable.burrito, 2.28));
            Data.getFoods().add(new Food("Doughnut", "Donuts to meet your morning health needs", 0, R.drawable.doughnut, 1.56));
            Data.getFoods().add(new Food("Hotdog", "Awesome hot dog, are you sure you don't try it?", 0, R.drawable.hotdog, 2.02));
            Data.getFoods().add(new Food("Noodles", "Simple noodles, fast, cheap and delicious", 0, R.drawable.noodles, 1.98));
            Data.getFoods().add(new Food("Oyster", "Oysters, fresh and juicy", 0, R.drawable.oyster, 2.78));
            Data.getFoods().add(new Food("Pizza", "Fruit pizza, if you party, you must not miss it", 0, R.drawable.pizza, 1.99));
            Data.getFoods().add(new Food("Porkribs", "Homely ribs, delicious in the lonely late night", 0, R.drawable.porkribs, 3.03));
            Data.getFoods().add(new Food("Salad", "Refreshing salad, very delicious", 0, R.drawable.salad, 1.79));
            Data.getFoods().add(new Food("Samdwich", "Sandwiches to meet the health needs of the day", 0, R.drawable.sandwich, 1.88));
            Data.getFoods().add(new Food("Sausage", "Sausage, beef, there are many flavors", 0, R.drawable.sausage, 1.43));
            Data.getFoods().add(new Food("Shrimpacke", "Shrimp cake with oversized shrimp cake consisting of seven prawns", 0, R.drawable.shrimpcake, 3.45));
            Data.getFoods().add(new Food("Spaghetti", "Oh, it’s delicious pasta, don’t miss it.", 0, R.drawable.spaghetti, 2.28));
        }
        foods = Data.getFoods();
        adapter = new FoodAdapter(this, foods);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new FoodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, MoreActivity.class);
                Food food = Data.getFoods().get(position);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMenu();
    }
}
