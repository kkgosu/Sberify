package com.example.sberify.models.domain

data class Token(val access_token: String,
                 val token_type: String,
                 val expires_in: Double) : BaseModel()