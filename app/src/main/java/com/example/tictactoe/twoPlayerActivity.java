package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class twoPlayerActivity extends AppCompatActivity {
    public static String p1;
    public static String p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
    }
    public void startGame(View view){
        // We will handle the click on the button here
        //Build an Intent to open another activity
        Intent game2 = new Intent(this, game2Player.class);
        EditText playerName1 = findViewById(R.id.playerName1);
        EditText playerName2 = findViewById(R.id.playerName2);
        p1=playerName1.getText().toString();
        p2=playerName2.getText().toString();
//        String message = "Order for " + editText1.getText().toString() + ", "
//                + editText2.getText().toString() + " & "
//                + editText3.getText().toString() + " has been successfully placed";

//        game2.putExtra("p1", playerName1.getText().toString());
//        game2.putExtra("p2", playerName2.getText().toString());
        startActivity(game2);

    }
}