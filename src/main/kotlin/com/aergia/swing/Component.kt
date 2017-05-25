package com.aergia.swing

import net.miginfocom.layout.CC
import javax.swing.JComponent
import java.awt.Component as AwtComponent

abstract class Component<out T: AwtComponent>(val component: T) {

	var visible
		get() = component.isVisible()
		set(value) {
			component.setVisible(value)
		}

	var enabled
		get() = component.isEnabled()
		set(value) {
			component.setEnabled(value)
		}
	
	var size
		get() = component.size
		set(value) {
			component.size = value
		}

	var tooltipText
		get(): String = if (component is JComponent) component.toolTipText else ""
        set(value) {
			if (component is JComponent) {
				component.toolTipText = value
			}
		}

    val componentConstraints by lazy {
        CC()
    }

	fun constraints(init: CC.() -> Unit): CC {
        componentConstraints.init()
        return componentConstraints
    }

	fun size(width: Int, height: Int) {
		component.setSize(width, height)
	}
}