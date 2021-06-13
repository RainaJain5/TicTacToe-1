package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class game1BotFirstWithX extends AppCompatActivity {
    public  static char[][] board = {{'_', '_', '_'},
                                     {'_', '_', '_'},
                                     {'_', '_', '_'}};
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    boolean gameActive = true;
    int activePlayer = 0;// X ie Bot is the active player initially
    public static class Move
    {
        int row, col;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_bot_first_with_x);
        XTurn();

    }
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());


        if (!gameActive) {
            gameReset(view);
            return;
        }
        if (gameState[tappedImage] == 2) {

            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status1);
                String s1 = "Your Turn - Tap to play";
                status.setText(s1);
                img.animate().translationYBy(1000f).setDuration(300);
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status1);
//                String s2 = "Bot's Turn";
//                status.setText(s2);
                img.animate().translationYBy(1000f).setDuration(300);
                editBoardWithO(tappedImage);
                XTurn();

            }

        }
        // Check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                // Somebody has won! - Find out who!
                String winnerStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
                    winnerStr = "Bot has won - Tap to reset";

//                    activePlayer = 0;
                } else {
                    winnerStr = "You have won - Tap to reset";

//                    activePlayer = 1;
                }
                // Update the status bar for winner announcement
                TextView status = findViewById(R.id.status1);
                status.setText(winnerStr);

            } else if (gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2 && gameState[8] != 2) {
                gameActive = false;
                activePlayer = 0;
                TextView status = findViewById(R.id.status1);
                status.setText("It's a Tie - Tap to reset");

//                activePlayer = 1;
            }


        }

    }




    public void XTurn(){
        Move bestMove = findBestMove(board);
        int gameStateIndex=getGameState(bestMove.row, bestMove.col);
        gameState[gameStateIndex]=0;
        board[bestMove.row][bestMove.col]='x';
        appearX(bestMove.row, bestMove.col);
        activePlayer=1;

    }

    public void editBoardWithO(int imageTag){
        if (imageTag==0){
            board[0][0]='o';
        }else if(imageTag==1){
            board[0][1]='o';
        }else if(imageTag==2){
            board[0][2]='o';
        }else if(imageTag==3){
            board[1][0]='o';
        }else if(imageTag==4){
            board[1][1]='o';
        }else if(imageTag==5){
            board[1][2]='o';
        }else if(imageTag==6){
            board[2][0]='o';
        }else if(imageTag==7){
            board[2][1]='o';
        }else if(imageTag==8){
            board[2][2]='o';
        }
    }


    static char player = 'x', opponent = 'o';

    //imageChangeFunction
    public void appearX(int row, int col){
        int gameStateIndex = -1;
        if(row==0 && col==0){
            ((ImageView) findViewById(R.id.imageView01)).setImageResource(R.drawable.x);
        }else if(row==0 && col==1){
            ((ImageView) findViewById(R.id.imageView11)).setImageResource(R.drawable.x);
        }else if(row==0 && col==2){
            ((ImageView) findViewById(R.id.imageView21)).setImageResource(R.drawable.x);
        }else if(row==1 && col==0){
            ((ImageView) findViewById(R.id.imageView31)).setImageResource(R.drawable.x);
        }else if(row==1 && col==1){
            ((ImageView) findViewById(R.id.imageView41)).setImageResource(R.drawable.x);
        }else if(row==1 && col==2){
            ((ImageView) findViewById(R.id.imageView51)).setImageResource(R.drawable.x);
        }else if(row==2 && col==0){
            ((ImageView) findViewById(R.id.imageView61)).setImageResource(R.drawable.x);
        }else if(row==2 && col==1){
            ((ImageView) findViewById(R.id.imageView71)).setImageResource(R.drawable.x);
        }else if(row==2 && col==2){
            ((ImageView) findViewById(R.id.imageView81)).setImageResource(R.drawable.x);
        }

    }


    //  char board to gameState function
    static int getGameState(int row, int col ){
        int gameStateIndex = -1;
        if(row==0 && col==0){
            gameStateIndex=0;
        }else if(row==0 && col==1){
            gameStateIndex=1;
        }else if(row==0 && col==2){
            gameStateIndex=2;
        }else if(row==1 && col==0){
            gameStateIndex=3;
        }else if(row==1 && col==1){
            gameStateIndex=4;
        }else if(row==1 && col==2){
            gameStateIndex=5;
        }else if(row==2 && col==0){
            gameStateIndex=6;
        }else if(row==2 && col==1){
            gameStateIndex=7;
        }else if(row==2 && col==2){
            gameStateIndex=8;
        }
        return gameStateIndex;
    }

    // This function returns true if there are moves
// remaining on the board. It returns false if
// there are no moves left to play.
    static Boolean isMovesLeft(char[][] board)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '_')
                    return true;
        return false;
    }

    // This is the evaluation function as discussed

    static int evaluate(char[][] b)
    {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2])
            {
                if (b[row][0] == player)
                    return +10;
                else if (b[row][0] == opponent)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col])
            {
                if (b[0][col] == player)
                    return +10;

                else if (b[0][col] == opponent)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
        {
            if (b[0][0] == player)
                return +10;
            else if (b[0][0] == opponent)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
        {
            if (b[0][2] == player)
                return +10;
            else if (b[0][2] == opponent)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    // This is the minimax function. It considers all
// the possible ways the game can go and returns
// the value of the board
    static int minimax(char[][] board,
                       int depth, Boolean isMax)
    {
        int score = evaluate(board);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (!isMovesLeft(board) )
            return 0;

        // If this maximizer's move
        if (isMax)
        {
            int best = -1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j]=='_')
                    {
                        // Make the move
                        board[i][j] = player;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = '_';
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
            int best = 1000;

            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    // Check if cell is empty
                    if (board[i][j] == '_')
                    {
                        // Make the move
                        board[i][j] = opponent;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = '_';
                    }
                }
            }
            return best;
        }
    }

    // This will return the best possible
// move for the player
    static Move findBestMove(char[][] board)
    {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // Check if cell is empty
                if (board[i][j] == '_')
                {
                    // Make the move
                    board[i][j] = player;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax(board, 0, false);

                    // Undo the move
                    board[i][j] = '_';

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }

//        System.out.printf("The value of the best Move " +
//                "is : %d\n\n", bestVal);

        return bestMove;
    }

    // Driver code
//    public static void main(String[] args)
//    {

//
//        Move bestMove = findBestMove(board);
//
//        System.out.printf("The Optimal Move is :\n");
//        System.out.printf("ROW: %d COL: %d\n\n",
//                bestMove.row, bestMove.col );
//    }
    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);
        ((ImageView)findViewById(R.id.imageView01)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView31)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView41)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView51)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView61)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView71)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView81)).setImageResource(0);

        TextView status = findViewById(R.id.status1);
        for(int i = 0;i<3;i++){
            for(int j = 0; j<3;j++){
                board[i][j]='_';
            }
        }
        XTurn();
        status.setText("Your Turn");
//        if(activePlayer==0){
//            String a=twoPlayerActivity.p1+"'s Turn";
//            status.setText(a);
//        }else{
//            String a= twoPlayerActivity.p2+"'s Turn";
//            status.setText(a);
//        }

    }







}
