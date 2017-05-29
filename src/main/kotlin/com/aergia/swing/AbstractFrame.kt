package com.aergia.swing

import java.awt.*
import java.awt.Component
import java.awt.Dialog
import java.awt.Window
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.WindowConstants

abstract class AbstractFrame<out T: Window>(component: T): Container<T>(component) {

    var title
        get() = (component as? Dialog)?.title ?: (component as? Frame)?.title ?: ""
        set(value) {
            when (component) {
                is Dialog -> component.title = value
                is Dialog -> component.title = value
            }
        }

    var resizable
        get() = (component as? Dialog)?.isResizable ?: (component as? Frame)?.isResizable ?: false
        set(value) {
            when (component) {
                is Dialog -> component.setResizable(value)
                is Frame -> component.setResizable(value)
            }
        }

    var defaultCloseOperation
        get() = when (component) {
            is JDialog -> component.defaultCloseOperation
            is JFrame -> component.defaultCloseOperation
            else -> WindowConstants.DO_NOTHING_ON_CLOSE
        }
        set(value) {
            when (component) {
                is JDialog -> component.defaultCloseOperation = value
                is JFrame -> component.defaultCloseOperation = value
            }
        }

    fun show() {
        visible = true
        component.toFront()
        component.requestFocus()
    }

    fun hide() {
        visible = false
    }

    fun close() {
        hide()
        component.dispose()
    }

    fun pack() {
        component.pack()
    }

    fun locationRelativeTo(relative: Component?) {
        component.setLocationRelativeTo(relative)
    }

    /**
     * Icons collection to hold the application icon images. Its purpose is for internal use only.
     */
    class Icons: ArrayList<Image>() {
        operator fun Image.unaryPlus() {
            add(this)
        }
    }

    fun icons(init: Icons.() -> Unit) {
        val list = Icons()
        list.init()
        component.iconImages = list
    }
}