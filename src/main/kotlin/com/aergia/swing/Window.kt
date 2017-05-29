package com.aergia.swing

import javax.swing.JFrame

class Window(title: String = "", init: Window.() -> Unit = {}): AbstractFrame<JFrame>(JFrame(title)) {

    init {
		init()
	}
}