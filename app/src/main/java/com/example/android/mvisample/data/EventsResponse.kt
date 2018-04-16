package com.example.android.mvisample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class EventsResponse (@SerializedName("meta") @Expose var meta: Meta,
                           @SerializedName("in_hand") @Expose var inHand: InHand,
                           @SerializedName("events") @Expose var events: List<Event>)