package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class onePlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);
    }
    public void enterGame(View view){
        Intent BotFirstWithX = new Intent(this, game1BotFirstWithX.class);
        startActivity(BotFirstWithX);
//        CheckBox botStartsFirstCheckBox = (CheckBox) findViewById(R.id.checkbox);
//        boolean botStartsFirst = botStartsFirstCheckBox.isChecked();
//
//        CheckBox xIsBotCheckBox = (CheckBox) findViewById(R.id.symbol);
//        boolean XisBot = xIsBotCheckBox.isChecked();
//
//        if(botStartsFirst && XisBot){
//            Intent BotFirstWithX = new Intent(this, game1BotFirstWithX.class);
//            startActivity(BotFirstWithX);
//
//        }else{
//            Intent BotFirstWithX = new Intent(this, game1BotFirstWithX.class);
//            startActivity(BotFirstWithX);
//        }
    }
}