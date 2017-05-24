package com.aergia

import com.aergia.views.WelcomeView
import javax.swing.UIManager

class Application {

    fun start() {
        WelcomeView.build().show()
    }
}

fun main(args: Array<String>) {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
	
	Application().start()
}