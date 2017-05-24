package com.aergia.swing

import java.awt.Component
import java.awt.Image
import javax.swing.JFrame

class Window(title: String = ""): Container<JFrame>(JFrame(title)) {

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

	fun icons(icons: List<Image>) {
		component.iconImages = icons
	}
}

fun Window(title: String = "", init: Window.() -> Unit): Window {
	val window = Window(title)
	window.init()
	return window
}