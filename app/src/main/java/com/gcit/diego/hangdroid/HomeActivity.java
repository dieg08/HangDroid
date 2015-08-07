package com.gcit.prashanth.hangdroid;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView txVwCustom = (TextView) findViewById(R.id.textView6);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Colored Crayons.ttf");
        txVwCustom.setTypeface(myCustomFont);
    }

    public void showGame(View view) {
        Intent game = new Intent(this, GameActivity.class);
        startActivity(game);
    }

    public void multiplayer(View view) {
        Intent word = new Intent(this, WordCapture.class);
        startActivity(word);
    }

    public void authors(View view) {
        Intent authors = new Intent(this, Authors.class);
        startActivity(authors);
    }
}
