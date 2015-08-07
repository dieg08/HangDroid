package com.gcit.prashanth.hangdroid;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class WordCapture extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_capture);
        TextView txVwCustom = (TextView) findViewById(R.id.textView7);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/Colored Crayons.ttf");
        txVwCustom.setTypeface(myCustomFont);
    }

    public void startMultiGame(View view){
        Intent game = new Intent(this, MultiPlayerActivity.class);
        EditText txt = (EditText)findViewById(R.id.editText);
        String word = txt.getText().toString();
        game.putExtra("word", word);
        startActivity(game);
    }
}
