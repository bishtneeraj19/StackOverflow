package com.creater.stackoverflow.model

import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("items") var items : List<AnswerItems>,
    @SerializedName("has_more") var hasMore : Boolean,
    @SerializedName("quota_max") var quotaMax : Int,
    @SerializedName("quota_remaining") var quotaRemaining : Int
)
