package com.example.bacaberita.Model

import com.google.gson.annotations.SerializedName

data class ModelBerita(
    val title: String,
    val abstract: String,
    val media: List<MediaModel>
)
