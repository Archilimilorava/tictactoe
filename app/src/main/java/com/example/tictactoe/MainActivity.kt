package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var play: Button
    private lateinit var player1: EditText
    private lateinit var player2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        play = findViewById(R.id.play)
        player1 = findViewById(R.id.editTextTextPersonName4)
        player2 = findViewById(R.id.editTextTextPersonName5)

        play.setOnClickListener {
            val Player1 = player1.text.toString()
            val Player2 = player1.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name1", Player1)
            intent.putExtra("name2", Player2)
            startActivity(intent)
        }
    }


}