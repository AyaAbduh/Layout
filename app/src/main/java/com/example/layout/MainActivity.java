package com.example.layout;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView imgOne, imgTwo;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= 21){
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transition_a);
            getWindow().setExitTransition(transition);
        }
        setContentView(R.layout.activity_main);
        imgOne = (ImageView) findViewById(R.id.imgOne);
        imgTwo = (ImageView) findViewById(R.id.imgTwo);

        imgOne.setOnClickListener(this);
        imgTwo.setOnClickListener(this);

        next=findViewById(R.id.next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityOptionsCompat compact = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, null);
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent, compact.toBundle());
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.imgOne:
                imgOne.setVisibility(View.GONE);
                imgTwo.setVisibility(View.VISIBLE);
                break;
            case R.id.imgTwo:
                imgOne.setVisibility(View.VISIBLE);
                imgTwo.setVisibility(View.GONE);
                break;
        }

    }
}
