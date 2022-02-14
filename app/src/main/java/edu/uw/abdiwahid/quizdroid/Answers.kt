package edu.uw.abdiwahid.quizdroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.BoolRes
import java.util.*
import kotlin.collections.HashMap

class Answers : AppCompatActivity() {
    var read = arrayListOf<QuizTopics>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answers)
    }

    @SuppressWarnings("depcreated")
    interface Repositry{
        fun addQuiz(topic: QuizTopics)
        fun getRepository(): LinkedList<QuizTopics>
        fun delete(topic: QuizTopics)
    }

    @SuppressWarnings("unchecked")
    data class QuizTopics(val title: String, val takeQuiz: String, val other: String, val questions:List<Question>, val topicChoice: Int)

    data class Question(val numQuestions: String, val answerOptions: Array<String>, val answers: Int)


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