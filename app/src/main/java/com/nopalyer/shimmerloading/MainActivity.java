package com.nopalyer.shimmerloading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecylerViewAdapter recylerViewAdapter;
    RecyclerView recyclerView;
    ArrayList<model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recylerViewAdapter = new RecylerViewAdapter(models,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(recylerViewAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));
                models.add(new model("title1","description1"));

                recylerViewAdapter.isShimmer = false;

                recylerViewAdapter.notifyDataSetChanged();
            }
        },10000);
    }
}
