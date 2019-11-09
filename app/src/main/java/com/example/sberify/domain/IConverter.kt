package com.example.sberify.domain

interface IConverter<From, To> {
    fun convert(from: From, someItems: List<Any>? = null): To
}