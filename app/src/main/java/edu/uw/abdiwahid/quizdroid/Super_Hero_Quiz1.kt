package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class Super_Hero_Quiz1 : AppCompatActivity() {
     var question: String = "";
    var question_1: String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_quiz2)


        val text: TextView = findViewById<TextView>(R.id.textView3)
        var answer_a: RadioButton = findViewById<RadioButton>(R.id.answer_a)
        var answer_b: RadioButton = findViewById<RadioButton>(R.id.answer_b)
        var answer_c: RadioButton = findViewById<RadioButton>(R.id.answer_c)
        var answer_d: RadioButton = findViewById<RadioButton>(R.id.answer_d)

        var submit: Button = findViewById(R.id.submit_button)

        var submit_button: Button = findViewById<Button>(R.id.submit_button)

        submit_button.isEnabled = false;
        submit.setOnClickListener(){
            var intent = Intent(this@Super_Hero_Quiz1, Super_Hero_Quiz2::class.java)
            startActivity(intent)
        }

        fun readjson() {
            val fil = filesDir
            Log.i("MAIN_ACTIVITY", fil.absolutePath)
            var json: String? = null
            try {
                val inputStream: InputStream = assets.open("Quiz.JSON");

                json = inputStream.bufferedReader().use {it.readText() }

                var jsonArray = JSONArray(json)
                for(i in 0..jsonArray.length() - 1){
                    var jsonObject = jsonArray.getJSONObject(i)
                    var list = arrayListOf<String>()

                }
                val obj = JSONArray(json)
                var left = obj.getJSONObject(1).getJSONArray("questions").getJSONObject(2)
                for(i in 0..left.length()) {
                    left = obj.getJSONObject(1).getJSONArray("questions").getJSONObject(2)


                   var left2 = obj.getJSONObject(1).getJSONArray("questions").getJSONObject(2)
                    question = left.getString("text");
                    text.setText(question)
                    question_1 = left2.getString("answers")

                   var i = question_1.split(",")
                    answer_a.setText(i[0].split("[")[1].toString())

                   answer_b.setText(i[1].split("[")[0].toString())

                   answer_c.setText(i[2].split("[")[0].toString())

                    answer_d.setText(i[3].split("[")[0].split("]")[0].toString())
                    Log.i("ABDIWAHID", i[1].split("[").toString())
                }

                Log.i("SUCCESS_FILE", inputStream.toString())

            }catch(e: IOException){
                Log.i("FAILER", e.toString())
            }
        }
        
        readjson()

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

    }
}