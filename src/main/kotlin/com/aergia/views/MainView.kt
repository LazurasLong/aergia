package com.aergia.views

import com.aergia.swing.Window
import com.aergia.util.Resources
import javax.swing.JFrame

class MainView {
    companion object {
        fun build(): Window {
            return Window("Aergia") {
                locationRelativeTo(null)
                defaultCloseOperation = JFrame.EXIT_ON_CLOSE

                icons(listOf(
                    Resources.ICON_APP_64,
                    Resources.ICON_APP_32,
                    Resources.ICON_APP_16
                ))
            }
        }
    }
}