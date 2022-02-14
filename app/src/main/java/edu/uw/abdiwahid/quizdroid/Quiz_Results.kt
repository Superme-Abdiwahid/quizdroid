package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Quiz_Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_results)



        var button: Button = findViewById<Button>(R.id.button2)

        button.setOnClickListener(){
            val intent = Intent(this@Quiz_Results, MainActivity::class.java)
            startActivity(intent)
        }
    }
}