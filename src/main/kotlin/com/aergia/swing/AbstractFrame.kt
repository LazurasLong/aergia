package com.aergia.swing

import java.awt.*
import java.awt.Component
import java.awt.Dialog
import java.awt.Window
import javax.swing.JDialog
import javax.swing.JFrame
import javax.swing.WindowConstants

/**
 * Abstract common base class for Dialog and Window.
 *
 * JDialog and JFrame have a lot in common, but a few things are duplicated in Dialog and Frame classes. This class
 * serves the purpose of avoiding to copy all common behavior.
 *
 * @see Dialog
 * @see Frame
 * @see JDialog
 * @see JFrame
 */
abstract class AbstractFrame<out T: Window>(component: T): Container<T>(component) {

    /**
     * The title of the window displayed at the window border.
     *
     * @see Dialog#setTitle
     * @see Frame#setTitle
     */
    var title
        get() = (component as? Dialog)?.title ?: (component as? Frame)?.title ?: ""
        set(value) {
            when (component) {
                is Dialog -> component.title = value
                is Frame -> component.title = value
            }
        }

    /**
     * Indicates if the window may be resized by the user.
     *
     * @see Dialog#setResizable
     * @see Frame#setResizable
     */
    var resizable
        get() = (component as? Dialog)?.isResizable ?: (component as? Frame)?.isResizable ?: false
        set(value) {
            when (component) {
                is Dialog -> component.setResizable(value)
                is Frame -> component.setResizable(value)
            }
        }

    /**
     * The default operation which occurs when the user closes the window.
     *
     * @see JDialog#setDefaultCloseOperation
     * @see JFrame#setDefaultCloseOperation
     */
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

    /**
     * Show the window. It will turn then window visible and request focus bringing it to front.
     */
    fun show() {
        visible = true
        component.toFront()
        component.requestFocus()
    }

    /**
     * Hide the window setting its visible property to false.
     */
    fun hide() {
        visible = false
    }

    /**
     * Close the window, hiding and disposing of it.
     */
    fun close() {
        hide()
        component.dispose()
    }

    /**
     * Size the window to its preferred size and layout.
     *
     * @see Window#pack
     */
    fun pack() {
        component.pack()
    }

    /**
     * Set the location of the window relative to the specified component.
     *
     * @see Window#setLocationRelativeTo
     */
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