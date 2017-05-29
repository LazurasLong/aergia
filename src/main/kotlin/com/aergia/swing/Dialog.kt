package com.aergia.swing

import java.awt.Window
import javax.swing.JDialog

class Dialog(parent: Container<Window>? = null, title: String = "", init: Dialog.() -> Unit = {}):
        AbstractFrame<JDialog>(JDialog(parent?.component, title)) {

    init {
        init()
    }

    var modalityType
        get() = component.modalityType
        set(value) {
            component.modalityType = value
        }
}