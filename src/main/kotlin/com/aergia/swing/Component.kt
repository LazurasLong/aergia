package com.aergia.swing

import net.miginfocom.layout.CC
import javax.swing.JComponent
import java.awt.Component as AwtComponent

/**
 * Base class for all components.
 */
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
		get() = (component as? JComponent)?.toolTipText ?: ""
        set(value) {
            (component as? JComponent)?.toolTipText = value
		}

    var parent
        get() = component.parent
        set(value) {
            component.parent
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