package com.example.sberify.presentation.ui

import java.text.Normalizer

fun String.normalize(): String = Normalizer.normalize(this, Normalizer.Form.NFD)
