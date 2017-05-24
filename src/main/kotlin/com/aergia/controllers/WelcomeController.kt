package com.aergia.controllers

import com.aergia.swing.Window
import com.aergia.views.MainView

class WelcomeController {

    var view: Window? = null

    fun btnNewGameClick() {
        MainView.build().show()
        view?.close() // Find a better way to do this
    }

    fun btnExitClick() {
        view?.close()
    }

    companion object {
        val instance by lazy {
            WelcomeController()
        }
    }
}