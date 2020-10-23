package com.kvlg.model.presentation

data class Image(
    val url: String?,
    val height: Int = 0,
    val width: Int = 0
) : BaseModel()