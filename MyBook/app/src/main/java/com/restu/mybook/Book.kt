package com.restu.mybook

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    var title: String = "",
    var author: String= "",
    var release_date: String= "",
    var publisher: String= "",
    var detail: String= "",
    var photo: Int= 0,
    var isFav: Boolean = false
) :Parcelable
