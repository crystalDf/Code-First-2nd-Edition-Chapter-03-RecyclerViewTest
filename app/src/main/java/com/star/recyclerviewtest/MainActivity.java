package com.star.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final int SPAN_COUNT = 3;
    public static final int RANDOM_MAX = 20;

    private List<Fruit> mFruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruitList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(mFruitList);

        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruitList() {

        mFruitList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit(getRandomLengthNme("apple"),
                    R.drawable.apple_pic);
            mFruitList.add(apple);

            Fruit banana = new Fruit(getRandomLengthNme("banana"),
                    R.drawable.banana_pic);
            mFruitList.add(banana);

            Fruit orange = new Fruit(getRandomLengthNme("orange"),
                    R.drawable.orange_pic);
            mFruitList.add(orange);

            Fruit watermelon = new Fruit(getRandomLengthNme("watermelon"),
                    R.drawable.watermelon_pic);
            mFruitList.add(watermelon);

            Fruit pear = new Fruit(getRandomLengthNme("pear"),
                    R.drawable.pear_pic);
            mFruitList.add(pear);

            Fruit grape = new Fruit(getRandomLengthNme("grape"),
                    R.drawable.grape_pic);
            mFruitList.add(grape);

            Fruit pineapple = new Fruit(getRandomLengthNme("pineapple"),
                    R.drawable.pineapple_pic);
            mFruitList.add(pineapple);

            Fruit strawberry = new Fruit(getRandomLengthNme("strawberry"),
                    R.drawable.strawberry_pic);
            mFruitList.add(strawberry);

            Fruit cherry = new Fruit(getRandomLengthNme("cherry"),
                    R.drawable.cherry_pic);
            mFruitList.add(cherry);

            Fruit mango = new Fruit(getRandomLengthNme("mango"),
                    R.drawable.mango_pic);
            mFruitList.add(mango);
        }
    }

    private String getRandomLengthNme(String name) {

        int length = (int) (Math.random() * RANDOM_MAX) + 1;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(name);
        }

        return stringBuilder.toString();
    }
}
