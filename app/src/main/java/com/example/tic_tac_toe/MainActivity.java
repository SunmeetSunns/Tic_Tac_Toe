package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList= new ArrayList<>();
    private int[] boxPositions={0,0,0,0,0,0,0,0,0};
    private int playerTurn=1;
    private int TotalSelectedBoxes=1;
    private LinearLayout playerOneLayout,playerTwoLayout;
    private TextView playerOneName,playerTwoName;
    private ImageView image_1,image_2,image_3,image_4,image_5,image_6,image_7,image_8,image_9;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOneName=findViewById(R.id.PlayerOneName);
        playerTwoName=findViewById(R.id.PlayerTwoName);
        playerOneLayout=findViewById(R.id.PlayerOneLayout);
        playerTwoLayout=findViewById(R.id.PlayerTwoLayout);
        image_1=findViewById(R.id.img1);
        image_2=findViewById(R.id.img2);
        image_3=findViewById(R.id.img3);
        image_4=findViewById(R.id.img4);
        image_5=findViewById(R.id.img5);
        image_6=findViewById(R.id.img6);
        image_7=findViewById(R.id.img7);
        image_8=findViewById(R.id.img8);
        image_9=findViewById(R.id.img9);

        combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{0,4,8});
        combinationsList.add(new int[]{2,4,6});

        final String getPlayerOneName=getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName=getIntent().getStringExtra("playerTwo");
        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);
        image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){
                    performAction((ImageView) view,0);

                }

            }
        });
        image_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    performAction((ImageView) view,1);

                }

            }
        });
        image_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    performAction((ImageView) view,2);

                }

            }
        });
        image_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                    performAction((ImageView) view,3);

                }

            }
        });
        image_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    performAction((ImageView) view,4);

                }

            }
        });
        image_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    performAction((ImageView) view,5);

                }

            }
        });
        image_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView) view,6);

                }

            }
        });
        image_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    performAction((ImageView) view,7);

                }

            }
        });
        image_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    performAction((ImageView) view,8);

                }

            }
        });
    }
    private void performAction(ImageView imgView,int SelectedBoxPosition){
        boxPositions[SelectedBoxPosition]=playerTurn;
        if(playerTurn==1){
            imgView.setImageResource(R.drawable.cross);
            if(CheckPlayerWin()){
                WinDialog winDialog=new WinDialog(MainActivity.this,playerOneName.getText().toString()+" has win the match",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();

            }
            else if(TotalSelectedBoxes==9){
                WinDialog winDialog=new WinDialog(MainActivity.this," Match Draw",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();

            }
            else{
                changePlayerTurn(2);
                TotalSelectedBoxes++;
            }
        }
        else{
            imgView.setImageResource(R.drawable.jero);
            if(CheckPlayerWin()){
                WinDialog winDialog=new WinDialog(MainActivity.this,playerTwoName.getText().toString()+" has win the match",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(SelectedBoxPosition==9){
                WinDialog winDialog=new WinDialog(MainActivity.this," Match Draw",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else{
                changePlayerTurn(1);
                TotalSelectedBoxes++;
            }
        }
    }
    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn=currentPlayerTurn;
        if(currentPlayerTurn==1){
            playerOneLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
        else{
            playerTwoLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playerOneLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
    }
    private boolean CheckPlayerWin(){
        boolean response =false;
        for(int i=0;i< combinationsList.size();i++){
            final int[] combination= combinationsList.get(i);
            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn && boxPositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return response;
    }
    private boolean isBoxSelectable(int boxPosition){
        boolean response=false;
        if(boxPositions[boxPosition]==0){
            response=true;
        }
        return response;
    }
    public void restartMatch(){
        boxPositions=new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        TotalSelectedBoxes=1;
        image_1.setImageResource(R.drawable.transparent_pic);
        image_2.setImageResource(R.drawable.transparent_pic);
        image_3.setImageResource(R.drawable.transparent_pic);
        image_4.setImageResource(R.drawable.transparent_pic);
        image_5.setImageResource(R.drawable.transparent_pic);
        image_6.setImageResource(R.drawable.transparent_pic);
        image_7.setImageResource(R.drawable.transparent_pic);
        image_8.setImageResource(R.drawable.transparent_pic);
        image_9.setImageResource(R.drawable.transparent_pic);
    }
}
