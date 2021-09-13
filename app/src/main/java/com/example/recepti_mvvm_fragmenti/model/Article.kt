package com.example.recepti_mvvm_fragmenti.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Article(
    var description: String,
    val title: String,
    val url: String,
    val urlToImage: String
): Parcelable