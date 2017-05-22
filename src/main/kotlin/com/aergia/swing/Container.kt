package com.aergia.swing

import java.awt.Container as AwtContainer
import java.awt.Component as AwtComponent

abstract class Container<out T: AwtContainer>(component: T): Component<T>(component) {
	
	fun <P: AwtComponent> add(child: Component<P>) {
		component.add(child.component)
	}
}