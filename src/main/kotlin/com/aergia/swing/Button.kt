package com.aergia.swing

import javax.swing.JButton
import javax.swing.Icon

class Button(text: String? = null, icon: Icon? = null, init: Button.() -> Unit = {}):
        Component<JButton>(JButton(text, icon)) {

    init {
        init()
    }
	
	var text
		get() = component.text
		set(value) {
			component.text = value
		}

    var mnemonic
        get() = component.mnemonic
        set(value) {
            component.mnemonic = value
        }

	fun listen(listener: () -> Unit) {
		component.addActionListener {
			listener()
		}
	}
}