package com.aergia.controllers

import com.aergia.views.MainView
import com.aergia.views.WelcomeView

class WelcomeController {

    private val view = WelcomeView(this)

    fun showWelcome() {
        view.open()
    }

    fun btnNewGameClick() {
        MainView.build().show()
        view.close() // Find a better way to do this
    }

    fun btnExitClick() {
        view.close()
    }
}