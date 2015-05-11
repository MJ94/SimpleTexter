package edu.css.mjackson1.simpletexter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public String receiver = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickMichael(View v){

        receiver = "Michael";
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("receiver", receiver);
        startActivity(i);
    }
    public void onClickTom(View v){

        receiver = "Tom";
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("receiver", receiver);
        startActivity(i);
    }
    public void onClickMick(View v){

        receiver = "Mick";
        Intent i = new Intent(this, ResultsActivity.class);
        i.putExtra("receiver", receiver);
        startActivity(i);
    }

}