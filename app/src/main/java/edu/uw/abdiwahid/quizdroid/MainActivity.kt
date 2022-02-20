package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.JsonReader
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONStringer
import java.io.*
import java.net.URLConnection
import java.util.*
import kotlin.collections.HashMap
import java.io.InputStreamReader

import java.io.BufferedReader
import java.net.HttpURLConnection

import java.net.URL
import kotlin.concurrent.thread
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var arr = arrayListOf<String>()
    lateinit var name:String
    var count = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val SDK_INT = Build.VERSION.SDK_INT
        val retry: TextView = findViewById<TextView>(R.id.retry)

        retry.visibility = View.INVISIBLE;
        val textView: TextView = findViewById<TextView>(R.id.textView6)
        try {

            if (SDK_INT > 8) {
                val policy = ThreadPolicy.Builder().permitAll().build()
                StrictMode.setThreadPolicy(policy)
                val toast = Toast.makeText(this, "Downloading JSON file", Toast.LENGTH_LONG)


                toast.show()
                var t = thread {
                    textView.setText("Starting the downloading from JSON FILE")
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
            count++;
            textView.setText("EROR JSON HAS NOT BEEN ABLE TO BE DOWNLOADED because of ${e}")
                retry.visibility = View.VISIBLE

            retry.setOnClickListener(){
                try {
                    textView.setText("Starting the downloading from JSON FILE.....")
                    if (SDK_INT > 8) {
                        val policy = ThreadPolicy.Builder().permitAll().build()
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
                }catch(e: Exception) {
                    textView.setTextColor(Color.RED)
                    textView.setText("EROR JSON HAS NOT BEEN ABLE TO BE DOWNLOADED because of ${e}")
               //     retry.visibility = View.INVISIBLE
                    count++;
                }
            }
        }
Log.i("Abdiwahid", "${count}")
        if(count == 0){
            textView.setText("DOWNLOAD WAS SUCCESFULL")
            textView.setTextColor(Color.GREEN)

        }


        var math_quiz: Button = findViewById<Button>(R.id.math_quiz)

        var physics_Quiz: Button = findViewById<Button>(R.id.physics_quiz)


        var super_hero_Quiz: Button = findViewById<Button>(R.id.super_hero_quiz)



        math_quiz.setOnClickListener() {
            val intent =
                Intent(this@MainActivity, Quiz_Overview::class.java)// first argument is the context
            startActivity(intent)  // send the intent
        }

        physics_Quiz.setOnClickListener() {
            val intent = Intent(this@MainActivity, Physics_Quiz::class.java)// first argument is the context
            startActivity(intent)  // send the intent
        }

        super_hero_Quiz.setOnClickListener() {
            val intent = Intent(
                this@MainActivity,
                Super_Hero_Quiz::class.java
            )// first argument is the context
            startActivity(intent)  // send the intent
        }



        fun find(){
            val fil = filesDir
        }
     //   readjson()


    }





    @SuppressWarnings("depcreated")
    interface Repositry {
        fun addQuiz(topic: QuizTopics)
        fun getRepository(): LinkedList<QuizTopics>
        fun delete(topic: QuizTopics)
    }

    @SuppressWarnings("unchecked")
    data class QuizTopics(
        val title: String,
        val takeQuiz: String,
        val other: String,
        val questions: Array<Question>,
        val topicChoice: Int
    )

    data class Question(
        val numQuestions: String,
        val answerOptions: Array<String>,
        val answers: Any
    )

    abstract class Quiz : Repositry {
        var read = LinkedList<QuizTopics>()
        var map = HashMap<String, String>();
        override fun addQuiz(topic: QuizTopics) {
            read.add(topic)
            read.addAll(read);
            Log.d("MAIN_ACTIVITY", read.toString())
            if (!map.containsKey("MAIN_ACTIVITY")) {
                map.put("MAIN_ACTIVITY", "Quiz_Data");
            }

        }

        override fun delete(choose: QuizTopics) {
            map.put("QUIZ_TOPIC", choose.toString());
            read.remove(choose);
        }

        override fun getRepository(): LinkedList<QuizTopics> {
            map.putAll(map);
            return read;
        }

        fun readJSON() {


        }
    }

}
