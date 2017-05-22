package com.aergia

import com.aergia.views.MainView
import javax.swing.UIManager

class Application {

    fun start() {
        MainView.build().show()
    }
}

fun main(args: Array<String>) {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
	
	Application().start()
}