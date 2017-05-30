package com.aergia.controllers

import com.aergia.views.WelcomeView

class WelcomeController {

    private val view = WelcomeView(this)

    fun showWelcome() {
        view.open()
    }

    fun btnNewGameClick() {
        CharacterCreationController(view.viewRoot).showCharacterCreation()
    }

    fun btnExitClick() {
        view.close()
    }
}