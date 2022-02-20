package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class Super_Hero_Quiz2 : AppCompatActivity() {
    var question: String = "";
    var question_1: String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_quiz3)
        val text: TextView = findViewById<TextView>(R.id.textView3)
        var answer_a: RadioButton = findViewById<RadioButton>(R.id.answer_a)
        var answer_b: RadioButton = findViewById<RadioButton>(R.id.answer_b)
        var answer_c: RadioButton = findViewById<RadioButton>(R.id.answer_c)
        var answer_d: RadioButton = findViewById<RadioButton>(R.id.answer_d)

        var submit: Button = findViewById(R.id.submit_button)
        var submit_button: Button = findViewById<Button>(R.id.submit_button)
        submit_button.isEnabled = false;

        submit.setOnClickListener(){

        }
try {
    val SDK_INT = Build.VERSION.SDK_INT
    if (SDK_INT > 8) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val toast = Toast.makeText(this, "Downloading JSON file", Toast.LENGTH_LONG)
        toast.show()
        var t = thread {
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
}catch(e: Exception){

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
                var left = obj.getJSONObject(1).getJSONArray("questions").getJSONObject(0)
                for(i in 0..left.length()) {
                    left = obj.getJSONObject(1).getJSONArray("questions").getJSONObject(0)


                    var left2 = obj.getJSONObject(1).getJSONArray("questions").getJSONObject(0)
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