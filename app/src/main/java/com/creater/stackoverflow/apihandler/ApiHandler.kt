package com.creater.stackoverflow.apihandler

import com.creater.stackoverflow.model.Answer
import com.creater.stackoverflow.model.Question
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiHandler {
    @GET("questions")
    fun  getQuestion(
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("site") site: String
    ): Call<Question>

    @GET("questions/{id}/answers?")
    fun  getAnswer(
        @Path("id") Id:Int,
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("site") site: String
    ): Call<Answer>

}