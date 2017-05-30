package com.aergia.swing

import javax.swing.JTextField
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener

class TextField(text: String? = null, columns: Int = 0, init: TextField.() -> Unit):
        Component<JTextField>(JTextField(text, columns)) {

    init {
        init()
    }

    var text
        get() = component.text
        set(value) {
            component.text = value
        }

    var columns
        get() = component.columns
        set(value) {
            component.columns = value
        }

    fun listen(listener: (text: String) -> Unit) {
        component.document.addDocumentListener(object : DocumentListener {
            override fun insertUpdate(e: DocumentEvent?) {
                listener(component.text)
            }

            override fun removeUpdate(e: DocumentEvent?) {
                listener(component.text)
            }

            override fun changedUpdate(e: DocumentEvent?) {
                listener(component.text)
            }
        })
    }
}