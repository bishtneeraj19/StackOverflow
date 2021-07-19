package com.creater.stackoverflow.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.creater.stackoverflow.R
import com.creater.stackoverflow.adapter.QuesAdapter
import com.creater.stackoverflow.apihandler.ApiHandler
import com.creater.stackoverflow.model.Question
import com.creater.stackoverflow.model.QuestionItems
import kotlinx.android.synthetic.main.activity_question.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class QuestionActivity : AppCompatActivity() {
    var QuesAdapter: QuesAdapter?=null
    var QuestionItems:List<QuestionItems>?=null
    var  quesId= ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "StackOverflow"
        supportActionBar?.subtitle="Questions"
        val retrofit: Retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.stackexchange.com/2.3/")
            .build()
        val service=retrofit.create(ApiHandler::class.java)
        val call=service.getQuestion("desc","activity","stackoverflow")
        call.enqueue(object : Callback<Question> {
            override fun onResponse(call: Call<Question>, response: Response<Question>) {
                if(response.code()==200) {
                    animationView.visibility= View.GONE
                    toolbar.visibility= View.VISIBLE
                    Listques.visibility= View.VISIBLE

                    var Question: Question = response.body()!!
                    QuestionItems=Question!!.items
                    for (i in QuestionItems!!) {
                        if (i.isAnswered && i.answerCount > 1)
                            quesId.add(i.questionId)
                    }
                    Listques.layoutManager=
                        LinearLayoutManager(this@QuestionActivity, LinearLayoutManager.VERTICAL,false)
                    QuesAdapter= QuesAdapter(quesId,QuestionItems,this@QuestionActivity)
                    Listques.adapter=QuesAdapter
                }
            }

            override fun onFailure(call: Call<Question>, t: Throwable) {
                Log.e("errorApi","440")
            }
        })
    }
}