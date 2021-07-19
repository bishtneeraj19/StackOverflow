package com.creater.stackoverflow.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.creater.stackoverflow.R
import com.creater.stackoverflow.adapter.AnsAdapter
import com.creater.stackoverflow.apihandler.ApiHandler
import com.creater.stackoverflow.model.Answer
import com.creater.stackoverflow.model.AnswerItems
import kotlinx.android.synthetic.main.activity_answer.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnswerActivity : AppCompatActivity() {
    var AnsAdapter: AnsAdapter?=null
    var items:List<AnswerItems>?=null
    var  ans=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Answers"
        val retrofit: Retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.stackexchange.com/2.3/")
            .build()
        val service=retrofit.create(ApiHandler::class.java)
        val id:Int= intent.extras!!["question"] as Int
        val link:String=intent.extras!!["Link"] as String
        val call=service.getAnswer(id,"desc","votes","stackoverflow")
        call.enqueue(object : Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                if(response.code()==200) {
                    animationView2.visibility= View.GONE
                    toolbar.visibility= View.VISIBLE
                    Listans.visibility= View.VISIBLE
                    var Answer: Answer = response.body()!!
                    items=Answer!!.items
                    for (i in items!!) {
                        ans.add(i.answerId)
                    }
                    Listans.layoutManager=
                        LinearLayoutManager(this@AnswerActivity, LinearLayoutManager.VERTICAL,false)
                    AnsAdapter= AnsAdapter(link,ans,items,this@AnswerActivity)
                    Listans.adapter=AnsAdapter
                }   else{
                    Log.e("errorApi","440")
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                Log.e("errorApi","440")
            }
        })
    }
}