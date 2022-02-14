package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Quiz_Overview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_overview)
        var button: Button = findViewById<Button>(R.id.math)

        button.setOnClickListener(){
            val intent = Intent(this@Quiz_Overview, Math_Quiz::class.java)
            startActivity(intent)

        }

    }

}