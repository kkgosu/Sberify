package com.kvlg.design.fluidlayout

/**
 * @author Konstantin Koval
 * @since 15.11.2020
 */
internal data class KeyboardVisibilityChanged(
    val visible: Boolean,
    val contentHeight: Int,
    val contentHeightBeforeResize: Int
)