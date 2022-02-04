package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var math_quiz: Button = findViewById<Button>(R.id.math_quiz)

        var physics_Quiz: Button = findViewById<Button>(R.id.physics_quiz)


        var super_hero_Quiz: Button = findViewById<Button>(R.id.super_hero_quiz)


        math_quiz.setOnClickListener(){
            val intent = Intent(this@MainActivity, Quiz_Overview::class.java)// first argument is the context
            startActivity(intent)  // send the intent
        }

        physics_Quiz.setOnClickListener(){
            val intent = Intent(this@MainActivity, Physics_Quiz::class.java)// first argument is the context
            startActivity(intent)  // send the intent
        }

        super_hero_Quiz.setOnClickListener(){
            val intent = Intent(this@MainActivity, Super_Hero_Quiz::class.java)// first argument is the context
            startActivity(intent)  // send the intent
        }
    }
}