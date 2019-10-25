package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView rv;
    private TextView tv_total;
    private List<Food> foods = new ArrayList<>();
    private OrderAdapter adapter;

    private double total;

    private void bind(){
        rv = (RecyclerView)findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        tv_total = (TextView) findViewById(R.id.tv_total);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        bind();
        initMenu();
    }

    private void initMenu(){
        total = 0.0;
        for(int i = 0; i < Data.getFoods().size(); i++){
            Food food = Data.getFoods().get(i);
            if(food.getNum() > 0){
                foods.add(food);
                total += food.getNum() * food.getPrice();
            }
        }

        adapter = new OrderAdapter(this, foods);
        rv.setAdapter(adapter);
        tv_total.setText("Total:$" + total);
    }
}
