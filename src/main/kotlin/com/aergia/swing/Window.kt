package com.aergia.swing

import javax.swing.JFrame

class Window(title: String = ""): Container<JFrame>(JFrame(title)) {

	var title
		get() = component.title
		set(value) {
			component.title = value
		}
	
	var resizable
		get() = component.isResizable()
		set(value) {
			component.setResizable(value)
		}
	
	var defaultCloseOperation
		get() = component.defaultCloseOperation
		set(value) {
			component.defaultCloseOperation = value
		}
}

fun Window(title: String = "", init: Window.() -> Unit): Window {
	val window = Window(title)
	window.init()
	return window
}