package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.util.*
import kotlin.collections.HashMap

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
    @SuppressWarnings("depcreated")
    interface Repositry{
        fun addQuiz(topic: QuizTopics)
        fun getRepository(): LinkedList<QuizTopics>
        fun delete(topic: QuizTopics)
    }

    @SuppressWarnings("unchecked")
    data class QuizTopics(val title: String, val takeQuiz: String, val other: String, val questions:List<Question>, val topicChoice: String)

    data class Question(val numQuestions: String, val answerOptions: Array<String>, val answers: Any)

    abstract class Quiz : Repositry {
        var read = LinkedList<QuizTopics>()
        var map = HashMap<String, String>();
        override fun addQuiz(topic: QuizTopics) {
            read.add(topic)
            read.addAll(read);
            Log.d("MAIN_ACTIVITY", read.toString())
            if(!map.containsKey("MAIN_ACTIVITY")){
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
    }
}