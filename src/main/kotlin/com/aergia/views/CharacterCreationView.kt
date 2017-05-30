package com.aergia.views

import com.aergia.controllers.CharacterCreationController
import com.aergia.core.View
import com.aergia.swing.*
import java.awt.Dialog.ModalityType
import java.awt.Window
import javax.swing.WindowConstants

class CharacterCreationView(parent: Container<Window>?, val controller: CharacterCreationController): View(parent) {

    var inputName: TextField? = null

    override fun build(): Dialog {
        return Dialog(parentComponent, "Aergia - Character Creation") {
            resizable = false
            defaultCloseOperation = WindowConstants.HIDE_ON_CLOSE
            modalityType = ModalityType.APPLICATION_MODAL

            constraints {
                flowY()
            }

            +Panel {
                +"Name:"

                +TextField(controller.draft.name) {
                    inputName = this

                    constraints {
                        width("200px")
                    }

                    listen {
                        controller.draft.name = text
                    }
                }

                +Button("?") {
                    listen(controller::btnRandomClick)
                }
            }

            pack()
            locationRelativeTo(parentComponent?.component)
        }
    }
}