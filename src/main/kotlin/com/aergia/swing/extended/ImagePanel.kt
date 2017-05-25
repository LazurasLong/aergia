package com.aergia.swing.extended

import com.aergia.swing.Component
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image
import javax.swing.JPanel

class ImagePanel(image: Image, init: ImagePanel.() -> Unit = {}):
        Component<ImagePanel.ImagePanelImpl>(ImagePanelImpl(image)) {

    init {
        init()
    }

    class ImagePanelImpl(val image: Image): JPanel() {
        init {
            val dimension = Dimension(image.getWidth(null), image.getHeight(null))

            preferredSize = dimension
            minimumSize = dimension
            maximumSize = dimension
            size = dimension
            layout = null
        }

        override fun paintComponent(g: Graphics?) {
            g!!.drawImage(image, 0, 0, width, height, null)
        }
    }
}