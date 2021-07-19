package com.creater.stackoverflow.model

import com.google.gson.annotations.SerializedName

data class QuestionItems(
    @SerializedName("tags") var tags : List<String>,
    @SerializedName("owner") var owner : Owner,
    @SerializedName("is_answered") var isAnswered : Boolean,
    @SerializedName("view_count") var viewCount : Int,
    @SerializedName("answer_count") var answerCount : Int,
    @SerializedName("score") var score : Int,
    @SerializedName("last_activity_date") var lastActivityDate : Int,
    @SerializedName("creation_date") var creationDate : Int,
    @SerializedName("question_id") var questionId : Int,
    @SerializedName("content_license") var contentLicense : String,
    @SerializedName("link") var link : String,
    @SerializedName("title") var title : String
)
