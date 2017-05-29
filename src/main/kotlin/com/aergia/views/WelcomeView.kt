package com.aergia.views

import com.aergia.controllers.WelcomeController
import com.aergia.core.View
import com.aergia.swing.*
import com.aergia.swing.extended.ImagePanel
import com.aergia.util.Resources
import java.awt.event.KeyEvent
import javax.swing.JFrame

class WelcomeView(val controller: WelcomeController): View() {

    override fun build(): Window {
        return Window("Aergia") {
            resizable = false
            defaultCloseOperation = JFrame.EXIT_ON_CLOSE

            icons {
                +Resources.ICON_APP_64
                +Resources.ICON_APP_32
                +Resources.ICON_APP_16
            }

            layout {
                constraints {
                    insets("15px", "15px", "0", "15px")
                    gridGap("10px", "10px")
                }

                columns("align center")
            }

            +ImagePanel(Resources.ICON_APP_64) {
                constraints {
                    dockWest()
                }
            }

            +Panel {
                layout {
                    constraints {
                        flowY()
                        gridGapY("10px")
                    }

                    columns {
                        fill()
                    }
                }

                +Button("New Game (Single Player)") {
                    mnemonic = KeyEvent.VK_N
                    tooltipText = "Start a new single player game."

                    listen(controller::btnNewGameClick)
                }

                +Button("New Game (Multiplayer)") {
                    mnemonic = KeyEvent.VK_M
                    tooltipText = "Start a new multiplayer game"
                    enabled = false
                }

                +Button("Load Game") {
                    mnemonic = KeyEvent.VK_L
                    tooltipText = "Load a single player game"
                }

                +Button("Exit") {
                    mnemonic = KeyEvent.VK_X

                    listen(controller::btnExitClick)
                }
            }

            +Panel {
                constraints {
                    dockSouth()
                    gap("10px", "10px", "0", "10px")
                }

                layout {
                    constraints {
                        alignX("center")
                    }
                }

                +"2017 Aergia - Fernando Marquardt"
            }

            pack()
            locationRelativeTo(null)
        }
    }
}
