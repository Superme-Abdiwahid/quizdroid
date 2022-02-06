package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Super_Hero_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_quiz)

        val button: Button = findViewById<Button>(R.id.button)

        button.setOnClickListener(){
            val intent = Intent(this@Super_Hero_Quiz, Super_Hero_Quiz1::class.java)
            startActivity(intent)
        }
    }
}