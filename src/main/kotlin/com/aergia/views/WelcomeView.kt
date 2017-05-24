package com.aergia.views

import com.aergia.controllers.WelcomeController
import com.aergia.swing.*
import com.aergia.util.Resources
import java.awt.event.KeyEvent
import javax.swing.JFrame

class WelcomeView {

    companion object {
        fun build(): Window {
            val controller = WelcomeController.instance

            return Window("Aergia") {
                controller.view = this

                resizable = false
                defaultCloseOperation = JFrame.EXIT_ON_CLOSE

                icons(listOf(
                    Resources.ICON_APP_64,
                    Resources.ICON_APP_32,
                    Resources.ICON_APP_16
                ))

                add(Panel {
                    add(Button("New Game (Single Player)") {
                        mnemonic = KeyEvent.VK_N
                        tooltipText = "Start a new single player game."

                        listen(controller::btnNewGameClick)
                    })

                    add(Button("New Game (Multiplayer)") {
                        mnemonic = KeyEvent.VK_M
                        tooltipText = "Start a new multiplayer game"
                        enabled = false
                    })

                    add(Button("Load Game") {
                        mnemonic = KeyEvent.VK_L
                        tooltipText = "Load a single player game"
                    })

                    add(Button("Exit") {
                        mnemonic = KeyEvent.VK_X

                        listen(controller::btnExitClick)
                    })

                    add(Label("2017 Aergia - Fernando Marquardt"))
                })

                pack()
                locationRelativeTo(null)
            }
        }
    }
}