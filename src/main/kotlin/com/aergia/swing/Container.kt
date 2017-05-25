package com.aergia.swing

import com.aergia.swing.layout.Layout
import net.miginfocom.swing.MigLayout
import java.awt.Container as AwtContainer
import java.awt.Component as AwtComponent

abstract class Container<out T: AwtContainer>(component: T): Component<T>(component) {

    private val layout = Layout()

	init {
		component.layout = MigLayout(layout.layoutConstraints, layout.columnConstraints, layout.rowConstraints)
	}

    operator fun Component<AwtComponent>.unaryPlus() {
        add(this)
    }

    operator fun String.unaryPlus() {
        add(Label(this))
    }
	
	fun <P: AwtComponent> add(child: Component<P>) {
		component.add(child.component, child.componentConstraints)
	}

    fun layout(init: Layout.() -> Unit): Layout {
        layout.init()
        return layout
    }
}