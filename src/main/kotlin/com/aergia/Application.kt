package com.aergia

import javax.swing.UIManager
import javax.swing.JFrame.*
import com.aergia.swing.*

fun main(args: Array<String>) {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
	
	Window("Test Window") {
		defaultCloseOperation = EXIT_ON_CLOSE
		
		visible = true
		
		add(Button("Test Button") {
			
		})
	}
}