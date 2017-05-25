package com.aergia.swing

import javax.swing.JLabel

class Label(text: String = "", init: Label.() -> Unit = {}): Component<JLabel>(JLabel(text)) {

    init {
        init()
    }

    var text
        get() = component.text
        set(value) {
            component.text = value
        }
}
