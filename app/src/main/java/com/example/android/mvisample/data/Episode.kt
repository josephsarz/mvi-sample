package com.example.android.mvisample.data

data class Episode(
        @SerializedName("info") var info:Info,
        @SerializedName("results") var results:List<Result>)

data class Info (
        @SerializedName("count") var count:Int,
        @SerializedName("pages") var pages:Int,
        @SerializedName("next") var next:String,
        @SerializedName("prev") var prev:String)

class Result(
        @SerializedName("id") var id: Int,
        @SerializedName("name") var name: String,
        @SerializedName("air_date") var airDate: String,
        @SerializedName("episode") var episode: String,
        @SerializedName("characters") var characters: List<String>,
        @SerializedName("url") var url: String,
        @SerializedName("created") var created: String)