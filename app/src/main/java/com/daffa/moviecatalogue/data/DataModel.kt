package com.daffa.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
    val title: String?,
    val overview: String?,
    val poster: String?,
    val genres: String?,
    val language: String?,
    val runtime: String?,
    val budget: String?,
    val revenue: String?,
    val rating: String?,
    val year: String?,
    val star: String
): Parcelable