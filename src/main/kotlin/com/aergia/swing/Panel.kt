package com.aergia.swing

import javax.swing.JPanel

class Panel(init: Panel.() -> Unit = {}): Container<JPanel>(JPanel()) {

    init {
        init()
    }
}