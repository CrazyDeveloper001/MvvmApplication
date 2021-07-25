package com.io.practicemvvm.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MyBlog(

  @Expose
  @SerializedName("title")
  var title : String
)