package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class game_players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_players);
        final EditText playerOne=findViewById(R.id.player_one);
        final EditText playerTwo=findViewById(R.id.playerTwo);
        final Button start_btn=findViewById(R.id.startButton);


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String first_player=playerOne.getText().toString();
                final String second_player=playerTwo.getText().toString();
                if(first_player.isEmpty()|| second_player.isEmpty()){
                    Toast.makeText(game_players.this, "Please enter Player Name", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(game_players.this,MainActivity.class);
                    intent.putExtra("playerOne",first_player);
                    intent.putExtra("playerTwo",second_player);
                    startActivity(intent);
                }
            }
        });
    }
}