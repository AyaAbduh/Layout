package com.example.layout;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= 21){
            Slide slide = new Slide();
            slide.setDuration(5000);
            getWindow().setEnterTransition(slide);
        }
        setContentView(R.layout.activity_second);
        back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
