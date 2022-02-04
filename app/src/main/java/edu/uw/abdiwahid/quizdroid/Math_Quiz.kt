package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class Math_Quiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_quiz)


        var submit_button: Button = findViewById<Button>(R.id.submit_button)

        submit_button.isEnabled = false;

        var answer_a: RadioButton = findViewById<RadioButton>(R.id.answer_a)

        var answer_b: RadioButton = findViewById<RadioButton>(R.id.answer_b)

        var answer_c: RadioButton = findViewById<RadioButton>(R.id.answer_c)

        var answer_d: RadioButton = findViewById<RadioButton>(R.id.answer_d)


        answer_a.setOnClickListener(){
            submit_button.isEnabled = true;
        }

        answer_b.setOnClickListener(){
            submit_button.isEnabled = true;

        }

        answer_c.setOnClickListener(){
            submit_button.isEnabled = true;

        }

        answer_d.setOnClickListener(){
            submit_button.isEnabled = true;

        }

        submit_button.setOnClickListener(){
            val intent = Intent(this@Math_Quiz, Math_Quiz2::class.java)
            startActivity(intent)
        }

    }
}