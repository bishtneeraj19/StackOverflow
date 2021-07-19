package com.creater.stackoverflow.model

import com.google.gson.annotations.SerializedName

data class Owner(

    @SerializedName("account_id") var accountId : Int,
    @SerializedName("reputation") var reputation : Int,
    @SerializedName("user_id") var userId : Int,
    @SerializedName("user_type") var userType : String,
    @SerializedName("profile_image") var profileImage : String,
    @SerializedName("display_name") var displayName : String,
    @SerializedName("link") var link : String
)
