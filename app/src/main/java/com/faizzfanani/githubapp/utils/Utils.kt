package com.faizzfanani.githubapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object{
        @SuppressLint("SimpleDateFormat")
        fun dateTimeFormatter(input: String): String {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val outputFormat = SimpleDateFormat("dd MMM yyyy, HH:mm")
            val date: Date? = inputFormat.parse(input)
            return outputFormat.format(Objects.requireNonNull(date))
        }
    }
}