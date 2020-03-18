package com.example.sberify.presentation.ui.search

enum class SearchType {
    ARTIST, ALBUM, TRACK
}

var currentSearchType: SearchType = SearchType.ARTIST