package com.aergia

import com.aergia.controllers.WelcomeController
import javax.swing.UIManager

class Application {

    fun start() {
        WelcomeController().showWelcome()
    }
}

fun main(args: Array<String>) {
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
	
	Application().start()
}