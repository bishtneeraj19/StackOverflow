package com.creater.stackoverflow.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.creater.stackoverflow.R
import com.creater.stackoverflow.model.AnswerItems
import kotlinx.android.synthetic.main.answer.view.*

class AnsAdapter (val link:String, val ans:ArrayList<Int>, val items:List<AnswerItems>?, context: Context)   : RecyclerView.Adapter<AnsAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val ans=view.ans
        val anslink=view.anslink
        val oname=view.oname
        val score=view.score

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.answer, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var ansId:Int=ans[position]
        for(i in items!!){
            if(i.answerId==ansId) {
                holder.ans.text = "Answer ${position+1}"
                holder.anslink.text = "Link-" + link+"/${ansId}#${ansId}"
                holder.oname.text = "Owner name-" + i.owner.displayName
                holder.score.text = "Score-" + i.score
            }
        }
    }
    override fun getItemCount(): Int {
        return  ans.size
    }

}