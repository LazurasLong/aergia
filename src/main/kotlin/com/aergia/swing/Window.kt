package com.aergia.swing

import java.awt.Component
import java.awt.Image
import javax.swing.JFrame

class Window(title: String = "", init: Window.() -> Unit = {}): Container<JFrame>(JFrame(title)) {

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

	fun show() {
		visible = true
		component.toFront()
		component.requestFocus()
	}

	fun hide() {
		visible = false
	}

	fun close() {
        hide()
		component.dispose()
	}

	fun pack() {
		component.pack()
	}

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