package com.example.movieboxvm.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieItemResponse(
    var id: Int,
    var name: String,
    var overview: String,
    var date: String,
    var photo: String
): Parcelable