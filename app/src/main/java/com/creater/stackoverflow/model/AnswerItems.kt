package com.creater.stackoverflow.model

import com.google.gson.annotations.SerializedName

data class AnswerItems(
    @SerializedName("owner") var owner : Owner,
    @SerializedName("is_accepted") var isAccepted : Boolean,
    @SerializedName("score") var score : Int,
    @SerializedName("last_activity_date") var lastActivityDate : Int,
    @SerializedName("creation_date") var creationDate : Int,
    @SerializedName("answer_id") var answerId : Int,
    @SerializedName("question_id") var questionId : Int,
    @SerializedName("content_license") var contentLicense : String
)
