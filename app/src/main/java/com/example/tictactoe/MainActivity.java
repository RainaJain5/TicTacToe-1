package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.tictactoe.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void TwoPlayer(View view){
        // We will handle the click on the button here
        //Build an Intent to open another activity
        Intent intent2 = new Intent(this, twoPlayerActivity.class);
//        EditText playerName1 = findViewById(R.id.playerName1);
//        EditText playerName2 = findViewById(R.id.playerName2);
//
//        String message = "Order for " + editText1.getText().toString() + ", "
//                + editText2.getText().toString() + " & "
//                + editText3.getText().toString() + " has been successfully placed";
//        intent2.putExtra(MSG, message);
        startActivity(intent2);

    }
    public void OnePlayer(View view){
        Intent intent1 = new Intent(this, onePlayerActivity.class);
        startActivity(intent1);
    }
}

