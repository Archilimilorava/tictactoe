package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var reset: Button
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var pplayer1: TextView
    private lateinit var pplayer2: TextView

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var firstplayerScore = ArrayList<Int>()
    private var secondplayerScore = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Player1 = intent.extras?.getString("name1")
        val Player2 = intent.extras?.getString("name2")
        pplayer1 = findViewById(R.id.textView3)
        pplayer1.text = Player1
        pplayer2 = findViewById(R.id.textView4)
        pplayer2.text = Player2
        if(pplayer1.text.isEmpty()){
            pplayer1.text="player1"
        }
        if(pplayer2.text.isEmpty()){
            pplayer2.text="player2"
        }
        init()
    }
    private fun init(){
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        reset=findViewById(R.id.reset)
        score1=findViewById(R.id.textView5)
        score2=findViewById(R.id.textView6)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        reset.setOnClickListener(this)
    }

    override fun onClick(clickedView: View) {
        if(clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
                R.id.reset -> buttonNumber = 0
            }
            if (buttonNumber != 0 && buttonNumber != -1){
                playGame(clickedView, buttonNumber)
            }else if(buttonNumber == 0){
                button1.text=""
                button2.text=""
                button3.text=""
                button4.text=""
                button5.text=""
                button6.text=""
                button7.text=""
                button8.text=""
                button9.text=""
                button1.setBackgroundColor(Color.rgb(95, 30, 240))
                button2.setBackgroundColor(Color.rgb(95, 30, 240))
                button3.setBackgroundColor(Color.rgb(95, 30, 240))
                button4.setBackgroundColor(Color.rgb(95, 30, 240))
                button5.setBackgroundColor(Color.rgb(95, 30, 240))
                button6.setBackgroundColor(Color.rgb(95, 30, 240))
                button7.setBackgroundColor(Color.rgb(95, 30, 240))
                button8.setBackgroundColor(Color.rgb(95, 30, 240))
                button9.setBackgroundColor(Color.rgb(95, 30, 240))
                button1.isEnabled=true
                button2.isEnabled=true
                button3.isEnabled=true
                button4.isEnabled=true
                button5.isEnabled=true
                button6.isEnabled=true
                button7.isEnabled=true
                button8.isEnabled=true
                button9.isEnabled=true
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer = 1
            }
            if(buttonNumber == -1) {
                button1.text = ""
                button2.text = ""
                button3.text = ""
                button4.text = ""
                button5.text = ""
                button6.text = ""
                button7.text = ""
                button8.text = ""
                button9.text = ""
                button1.setBackgroundColor(Color.rgb(95, 30, 240))
                button2.setBackgroundColor(Color.rgb(95, 30, 240))
                button3.setBackgroundColor(Color.rgb(95, 30, 240))
                button4.setBackgroundColor(Color.rgb(95, 30, 240))
                button5.setBackgroundColor(Color.rgb(95, 30, 240))
                button6.setBackgroundColor(Color.rgb(95, 30, 240))
                button7.setBackgroundColor(Color.rgb(95, 30, 240))
                button8.setBackgroundColor(Color.rgb(95, 30, 240))
                button9.setBackgroundColor(Color.rgb(95, 30, 240))
                button1.isEnabled = true
                button2.isEnabled = true
                button3.isEnabled = true
                button4.isEnabled = true
                button5.isEnabled = true
                button6.isEnabled = true
                button7.isEnabled = true
                button8.isEnabled = true
                button9.isEnabled = true
                firstPlayer.clear()
                secondPlayer.clear()
                activePlayer = 1
                firstplayerScore.clear()
                secondplayerScore.clear()
                score1.text = "0"
                score2.text = "0"
            }
        }
    }
    private fun playGame(clickedView: Button, buttonNumber: Int){
        if(activePlayer == 1){
            activePlayer = 2
            clickedView.text = "X"
            clickedView.setTextColor(Color.WHITE)
            firstPlayer.add(buttonNumber)
        }else if(activePlayer == 2){
            activePlayer = 1
            clickedView.text = "O"
            clickedView.setTextColor(Color.WHITE)
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled=false
        check()
    }
    private fun check(){
        firstplayerScore.add(0)
        secondplayerScore.add(0)
        var finalscore1 = firstplayerScore
        var finalscore2 = secondplayerScore
        var winnerPlayer = 0
        if(firstPlayer.contains(1)&&firstPlayer.contains(2)&&firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(4)&&firstPlayer.contains(5)&&firstPlayer.contains(6)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(7)&&firstPlayer.contains(8)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(1)&&firstPlayer.contains(4)&&firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(2)&&firstPlayer.contains(5)&&firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(3)&&firstPlayer.contains(6)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(1)&&firstPlayer.contains(5)&&firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if(firstPlayer.contains(3)&&firstPlayer.contains(5)&&firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(2)&&secondPlayer.contains(3)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(4)&&secondPlayer.contains(5)&&secondPlayer.contains(6)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(7)&&secondPlayer.contains(8)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(4)&&secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(2)&&secondPlayer.contains(5)&&secondPlayer.contains(8)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(3)&&secondPlayer.contains(6)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(1)&&secondPlayer.contains(5)&&secondPlayer.contains(9)){
            winnerPlayer = 2
        }
        if(secondPlayer.contains(3)&&secondPlayer.contains(5)&&secondPlayer.contains(7)){
            winnerPlayer = 2
        }
        if(winnerPlayer == 1){
            Toast.makeText(this,"1st player won", Toast.LENGTH_SHORT).show()
            finalscore1[0]+=1
            score1.text = finalscore1[0].toString()
        }
        if(winnerPlayer == 2){
            Toast.makeText(this,"2nd player won", Toast.LENGTH_SHORT).show()
            finalscore2[0]+=1
            score2.text = finalscore2[0].toString()
        }
        if(winnerPlayer != 0){
            button1.isEnabled=false
            button2.isEnabled=false
            button3.isEnabled=false
            button4.isEnabled=false
            button5.isEnabled=false
            button6.isEnabled=false
            button7.isEnabled=false
            button8.isEnabled=false
            button9.isEnabled=false
        }
        if(firstPlayer.size + secondPlayer.size == 9){
            Toast.makeText(this,"its a draw", Toast.LENGTH_SHORT).show()
        }
    }


}