package com.aergia.swing

import java.awt.Component as AwtComponent

abstract class Component<T: AwtComponent>(val component: T) {

	var visible
		get() = component.isVisible()
		set(value) {
			component.setVisible(value)
		}
	
	var size
		get() = component.size
		set(value) {
			component.setSize(value)
		}
	
	fun size(width: Int, height: Int) {
		component.setSize(width, height)
	}
}