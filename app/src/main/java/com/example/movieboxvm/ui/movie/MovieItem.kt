package com.example.movieboxvm.ui.movie

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieItem(
    var id: Int = 0,
    var name: String? = null,
    var overview: String? = null,
    var date: String? = null,
    var photo: String? = null
) : Parcelable

