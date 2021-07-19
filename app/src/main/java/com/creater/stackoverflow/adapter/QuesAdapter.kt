package com.creater.stackoverflow.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.creater.stackoverflow.R
import com.creater.stackoverflow.Activities.AnswerActivity
import com.creater.stackoverflow.model.QuestionItems
import kotlinx.android.synthetic.main.question.view.*

class QuesAdapter(val quesId:ArrayList<Int>, val items:List<QuestionItems>?, val activity:com.creater.stackoverflow.Activities.QuestionActivity )   :
    RecyclerView.Adapter<QuesAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val question=view.question
        val link=view.link
        val name=view.name
        val answer=view.answer

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.question, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ques:Int=quesId[position]
        for(i in items!!){
            if(i.questionId==ques) {
                holder.question.text = "Question ${position+1}-" + i.title
                holder.link.text = "Link-" + i.link
                holder.name.text = "Owner name-" + i.owner.displayName
                holder.answer.setOnClickListener {
                    val intent = Intent(activity, AnswerActivity::class.java)
                    intent.putExtra("question",ques)
                    intent.putExtra("Link",i.link)
                    ContextCompat.startActivity(activity, intent,null)
                }}}
    }

    override fun getItemCount(): Int {
        return  quesId.size
    }
}