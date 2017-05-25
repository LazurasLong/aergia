package com.aergia.swing

import java.awt.Window
import javax.swing.JDialog

class Dialog(parent: Container<Window>? = null, title: String = "", init: Dialog.() -> Unit = {}):
        Container<JDialog>(JDialog(parent?.component, title)) {

    init {
        init()
    }

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

    var modalityType
        get() = component.modalityType
        set(value) {
            component.modalityType = value
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