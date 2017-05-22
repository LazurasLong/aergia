package com.aergia.swing

import java.awt.Window
import javax.swing.JDialog

class Dialog(parent: Container<Window>? = null, title: String = ""): Container<JDialog>(JDialog(parent?.component, title)) {

    var title
        get() = component.title
        set(value) {
            component.title = value
        }

    var resizable
        get() = component.isResizable
        set(value) {
            component.setResizable(value)
        }

    var defaultCloseOperation
        get() = component.defaultCloseOperation
        set(value) {
            component.defaultCloseOperation = value
        }

    fun show() {
        visible = true
    }

    fun hide() {
        visible = false
    }

    fun pack() {
        component.pack()
    }
}

fun Dialog(parent: Container<Window>? = null, title: String = "", init: Dialog.() -> Unit): Dialog {
    val dialog = Dialog(parent, title)
    dialog.init()
    return dialog
}