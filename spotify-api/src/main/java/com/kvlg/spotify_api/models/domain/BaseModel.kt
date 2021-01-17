package com.kvlg.spotify_api.models.domain

abstract class BaseModel(val baseId: String = "") {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseModel) return false

        if (baseId != other.baseId) return false

        return true
    }

    override fun hashCode(): Int {
        return baseId.hashCode()
    }
}