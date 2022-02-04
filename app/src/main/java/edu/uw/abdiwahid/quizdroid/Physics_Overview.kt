package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Physics_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_overview)
//
        var begin_quiz: Button = findViewById<Button>(R.id.physics_begin)

        begin_quiz.setOnClickListener(){
            var intent = Intent(this@Physics_Quiz, Physics_Quiz1::class.java)
            startActivity(intent)
        }
    }
}