package com.example.sberify.models.presentation

import com.example.sberify.models.domain.BaseModel

/**
 * @author Konstantin Koval
 * @since 24.12.2020
 */
data class ArtistModel(
    val id: String,
    val name: String,
    val externalUrl: String,
    val imageUrl: String?
) : BaseModel(id)
