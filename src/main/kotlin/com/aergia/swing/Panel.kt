package com.aergia.swing

import javax.swing.JPanel

class Panel: Container<JPanel>(JPanel()) {

}

fun Panel(init: Panel.() -> Unit): Panel {
    val panel = Panel()
    panel.init()
    return panel
}