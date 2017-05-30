package com.aergia.controllers

import com.aergia.core.entities.CharacterDraft
import com.aergia.core.generateName
import com.aergia.swing.Container
import com.aergia.views.CharacterCreationView
import java.awt.Window

class CharacterCreationController(parent: Container<Window>?) {

    val view = CharacterCreationView(parent, this)

    val draft: CharacterDraft = CharacterDraft()

    fun showCharacterCreation() {
        view.open()
    }

    fun btnRandomClick() {
        updateName(generateName())
    }

    private fun updateName(name: String) {
        draft.name = name
        view.inputName?.text = draft.name
    }
}