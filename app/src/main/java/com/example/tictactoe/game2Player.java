package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class game2Player extends AppCompatActivity {
        boolean gameActive = true;
        int p1score=0;
        int p2score=0;

    // Player representation
    // 0 - X
    // 1 - O
    int activePlayer = 0;
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    //    State meanings:
    //    0 - X
    //    1 - O
    //    2 - Null
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
//    String player1 = getIntent().getStringExtra("p1");
//    String player2 = getIntent().getStringExtra("p2");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_player);
        TextView player1Score = (TextView) findViewById(
                R.id.textView2);
        String p1s=twoPlayerActivity.p1+ " = " + p1score;
        player1Score.setText(p1s);
        TextView player2Score = (TextView) findViewById(
                R.id.textView4);
        String p2s=twoPlayerActivity.p2 +" = "+ p2score;
        player2Score.setText(p2s);


    }
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
            return;
        }
        if(gameState[tappedImage] == 2) {

            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                String s1=twoPlayerActivity.p2+"'s Turn - Tap to play";
                status.setText(s1);
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                String s2=twoPlayerActivity.p1+"'s Turn - Tap to play";
                status.setText(s2);

            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        // Check if any player has won
        for(int[] winPosition: winPositions){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]]!=2){
                // Somebody has won! - Find out who!
                String winnerStr;
                gameActive = false;
                if(gameState[winPosition[0]] == 0){
                    winnerStr = twoPlayerActivity.p1+" has won - Tap to reset";
                    p1score++;
                    TextView player1Score = (TextView) findViewById(
                            R.id.textView2);
                    String p1s=twoPlayerActivity.p1+ " = " + p1score;
                    player1Score.setText(p1s);

                    activePlayer = 0;
                }
                else{
                    winnerStr = twoPlayerActivity.p2+" has won - Tap to reset";
                    p2score++;
                    TextView player2Score = (TextView) findViewById(
                            R.id.textView4);
                    String p2s=twoPlayerActivity.p2 +" = "+ p2score;
                    player2Score.setText(p2s);
                    activePlayer = 1;
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
                break;

            }else if(gameState[0]!=2 && gameState[1]!=2 && gameState[2]!=2 && gameState[3]!=2 && gameState[4]!=2 && gameState[5]!=2 && gameState[6]!=2 && gameState[7]!=2 && gameState[8]!=2 ){
                gameActive = false;
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("It's a Tie - Tap to reset");

                activePlayer = 1;
            }



        }

    }

    public void gameReset(View view) {
        gameActive = true;
//        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        if(activePlayer==0){
            String a=twoPlayerActivity.p1+"'s Turn";
            status.setText(a);
        }else{
            String a= twoPlayerActivity.p2+"'s Turn";
            status.setText(a);
        }

    }

}