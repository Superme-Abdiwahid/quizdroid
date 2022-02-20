package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class Math_Quiz2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_quiz2)
        var submit_button: Button = findViewById<Button>(R.id.submit_button)
        val SDK_INT = Build.VERSION.SDK_INT
        if (SDK_INT > 8) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val toast = Toast.makeText(this, "Downloading JSON file", Toast.LENGTH_LONG)
            toast.show()
            var t =  thread{
                val server = URL("http://tednewardsandbox.site44.com/questions.json")

                val client: HttpURLConnection = server.openConnection() as HttpURLConnection
                //    RetrieveFeedTask().execute(urlToRssFeed)
                client.requestMethod = "GET"

                //     client.headerFields["User-Agent"] = listOf("Android Demo 8.1")
                val result = BufferedReader(InputStreamReader(client.getInputStream()))
                var inputLine: String?
                while (result.readLine().also { inputLine = it } != null)
                    Log.i("MAin_Activity", inputLine!!)
                result.close()
            }
        }
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
            val intent = Intent(this@Math_Quiz2, Math_Quiz3::class.java)
            startActivity(intent)
        }

    }



    }