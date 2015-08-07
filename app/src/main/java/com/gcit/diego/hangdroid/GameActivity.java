package com.gcit.prashanth.hangdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends ActionBarActivity {

    private String gamePlay = "GCIT";
    private int gameCounter = 0;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        count = gamePlay.length();
    }

    public void checkLetter(View view) {
        EditText userEntry = (EditText) findViewById(R.id.enteredLetter);
        String entry = userEntry.getText().toString();

        if(entry == null || entry.length() == 0) {
            Toast.makeText(this, "Please enter a valid character!", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean found = false;
        for(int i = 0; i < gamePlay.length(); i++) {

            if(Character.toLowerCase(gamePlay.charAt(i)) == Character.toLowerCase(entry.charAt(0))) {
                found = true;
                showCharacterAtLocation(i, entry);
                count--;

                if (count == 0) {
                    Toast.makeText(this, "You Win!!", Toast.LENGTH_LONG).show();
                    userEntry.setVisibility(View.INVISIBLE);
                }
            }

        }

        if(!found) {
            gameCounter++;
            ImageView hangMan = (ImageView) findViewById(R.id.hangMan);
            switch(gameCounter) {
                case 1: {
                    hangMan.setImageResource(R.drawable.hangdroid_1);
                    break;
                }
                case 2: {
                    hangMan.setImageResource(R.drawable.hangdroid_2);
                    break;
                }
                case 3: {
                    hangMan.setImageResource(R.drawable.hangdroid_3);
                    break;
                }
                case 4: {
                    hangMan.setImageResource(R.drawable.hangdroid_4);
                    break;
                }
                case 5: {
                    hangMan.setImageResource(R.drawable.hangdroid_5);
                    break;
                }
                case 6: {
                    hangMan.setImageResource(R.drawable.game_over);
                    Toast.makeText(this, "GAME OVER!", Toast.LENGTH_LONG).show();
                    userEntry.setVisibility(View.INVISIBLE);
                    break;
                }

            }

            userEntry.setText("");

        }
    }

    public void showCharacterAtLocation(int index, String entry) {
        LinearLayout word = (LinearLayout) findViewById(R.id.wordView);
        TextView tv = (TextView) word.getChildAt(index);
        tv.setText(entry);
        ((EditText) findViewById(R.id.enteredLetter)).setText("");
    }
}
