package com.example.bacaberita.Response

import com.example.bacaberita.Model.MediaModel
import com.example.bacaberita.Model.ModelBerita

data class ResponseBerita(
    var status: String,
    val results: List<ModelBerita>
)
