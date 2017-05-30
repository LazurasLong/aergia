package com.aergia.core

import com.aergia.swing.AbstractFrame
import com.aergia.swing.Container
import java.awt.Window
import java.awt.Container as AwtContainer

abstract class View(val parentComponent: Container<Window>? = null) {

    var viewRoot: AbstractFrame<Window>? = null

    abstract protected fun build(): AbstractFrame<Window>

    fun open() {
        viewRoot = build()
        viewRoot?.show()
    }

    fun close() {
        viewRoot?.close()
    }
}

