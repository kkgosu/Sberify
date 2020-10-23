package com.kvlg.model.presentation

open class BaseModel(val baseId: String = "") {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseModel

        if (baseId != other.baseId) return false

        return true
    }

    override fun hashCode(): Int {
        return baseId.hashCode()
    }
}