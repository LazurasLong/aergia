package com.aergia.swing

import javax.swing.JButton
import javax.swing.Icon

class Button(text: String? = null, icon: Icon? = null): Component<JButton>(JButton(text, icon)) {
	
	var text
		get() = component.text
		set(value) {
			component.text = value
		}
}

fun Button(text: String? = null, icon: Icon? = null, init: Button.() -> Unit): Button {
	val button = Button(text, icon)
	button.init()
	return button
}