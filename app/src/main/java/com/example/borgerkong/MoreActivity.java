package com.example.borgerkong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoreActivity extends AppCompatActivity {

    private ImageView img;
    private ImageView add;
    private ImageView sub;
    private TextView tv_price;
    private TextView tv_name;
    private TextView tv_content;
    private EditText num;
    private Button btn;
    private int position;
    private Food food;

    private int nums = 0;

    private void bind(){
        img = (ImageView)findViewById(R.id.img_main);
        add = (ImageView)findViewById(R.id.img_add);
        sub = (ImageView)findViewById(R.id.img_sub);
        tv_price = (TextView)findViewById(R.id.tv_price);
        tv_name = (TextView)findViewById(R.id.tv_name);
        num = (EditText)findViewById(R.id.edit_num);
        btn = (Button)findViewById(R.id.btn_add);
        tv_content = (TextView)findViewById(R.id.content);
    }

    private void init(){
        bind();
        position = getIntent().getIntExtra("position", 0);
        food = Data.getFoods().get(position);

        img.setImageResource(food.getRid());
        tv_price.setText("$" + food.getPrice());
        tv_name.setText(food.getName());
        nums = food.getNum();
        num.setText("" + nums);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nums++;
                num.setText("" + nums);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nums > 0){
                    nums--;
                    num.setText("" + nums);
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.getFoods().get(position).setNum(nums);
                Toast.makeText(MoreActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        tv_content.setText(Data.getFoods().get(position).getIntro());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        init();
    }

}
