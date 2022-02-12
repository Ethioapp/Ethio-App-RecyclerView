package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView list;
ArrayList card,cardimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list =findViewById(R.id.list);

        card=new ArrayList();
        cardimg=new ArrayList();

        card.add("Popular");
        card.add("City");
        card.add("New");
        card.add("Religion");
        card.add("Nature");
        card.add("Culture");
        card.add("Art");
        card.add("Famous");
        card.add("Women");
        card.add("Other");

        cardimg=new ArrayList();
        cardimg.add(R.drawable.pop);
        cardimg.add(R.drawable.city);
        cardimg.add(R.drawable.ne);
        cardimg.add(R.drawable.religion);
        cardimg.add(R.drawable.nature);
        cardimg.add(R.drawable.cultu);
        cardimg.add(R.drawable.art);
        cardimg.add(R.drawable.famous);
        cardimg.add(R.drawable.women);
        cardimg.add(R.drawable.other);

       // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        list.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new MSAdapter(card,cardimg);
        list.setAdapter(adapter);
        list.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);

                    Toast.makeText(getApplicationContext(), ""+card.get(position), Toast.LENGTH_SHORT).show();

                    if (position == 0){
                        Toast.makeText(getApplicationContext(), "Click Popular", Toast.LENGTH_SHORT).show();
                    }else {

                    }



                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });



    }
}