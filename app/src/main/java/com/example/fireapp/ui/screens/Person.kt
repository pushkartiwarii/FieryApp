package com.example.fireapp.ui.screens

import android.graphics.drawable.Icon
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.versionedparcelable.ParcelField
import androidx.versionedparcelable.VersionedParcelize
import com.example.fireapp.R


data class Person(
    val id :Int=0,
    val name: String="" ,
    val icon: Int= R.drawable.solid
)

val personList = listOf(
    Person(
        1,
        "Akshay",
        R.drawable.pktvoa
    ) ,
    Person(
        2,
        "Abhi",
        R.drawable.pktvoa
    ),Person(
        3,
        "Tushar",
        R.drawable.pktvoa
    ),Person(
        4,
        "Chris",
        R.drawable.pktvoa
    ),Person(
        5,
        "Alia",
        R.drawable.pktvoa
    )
)