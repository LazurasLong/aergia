package com.aergia.core

import com.aergia.swing.Window
import java.awt.Container as AwtContainer

abstract class View {

    var viewRoot: Window? = null

    abstract protected fun build(): Window

    fun open() {
        viewRoot = build()
        viewRoot?.show()
    }

    fun close() {
        viewRoot?.close()
    }
}

