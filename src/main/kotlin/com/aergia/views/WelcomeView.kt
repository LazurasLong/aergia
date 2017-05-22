package com.aergia.views

import com.aergia.swing.*
import java.awt.event.KeyEvent

class WelcomeView {

    companion object {
        fun build(): Dialog {
            return Dialog(title = "Aergia") {
                resizable = false

                add(Panel {
                    add(Button("New Game (Single Player)") {
                        mnemonic = KeyEvent.VK_N
                        tooltipText = "Start a new single player game."
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
                    })

                    add(Label("2017 Aergia - Fernando Marquardt"))
                })

                pack()
            }
        }
    }
}