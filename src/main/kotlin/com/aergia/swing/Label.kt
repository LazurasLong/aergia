package com.aergia.swing

import javax.swing.JLabel

class Label(text: String = ""): Component<JLabel>(JLabel(text)) {

    var text
        get() = component.text
        set(value) {
            component.text = value
        }
}

fun Label(text: String = "", init: Label.() -> Unit): Label {
    val label = Label(text)
    label.init()
    return label
}
