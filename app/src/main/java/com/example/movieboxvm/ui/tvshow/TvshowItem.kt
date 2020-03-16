package com.example.movieboxvm.ui.tvshow

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class TvshowItem(
    var id: Int = 0,
    var title: String? = null,
    var overview : String? = null,
    var release: String? = null,
    var photo: String? = null
) : Parcelable