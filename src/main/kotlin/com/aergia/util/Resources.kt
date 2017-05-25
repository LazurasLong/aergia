package com.aergia.util

import java.awt.Image
import javax.imageio.ImageIO

class Resources {
    companion object {
        val ICON_APP_16: Image by lazy {
            loadImage("/icons/app_icon_16.png")
        }

        val ICON_APP_32: Image by lazy {
            loadImage("/icons/app_icon_32.png")
        }

        val ICON_APP_64: Image by lazy {
            loadImage("/icons/app_icon_64.png")
        }

        private fun loadImage(filename: String): Image {
            return ImageIO.read(Resources::class.java.getResource(filename))
        }
    }
}