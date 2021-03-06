package net.dankito.richtexteditor.java.fx.command

import net.dankito.utils.Color
import net.dankito.utils.image.ImageReference
import net.dankito.richtexteditor.command.SetTextBackgroundColorCommandBase
import net.dankito.utils.javafx.ui.image.JavaFXImageReference


open class SetTextBackgroundColorCommand(defaultColor: Color = Color.Transparent, icon: ImageReference = JavaFXImageReference.fromIconsResourceName("ic_format_color_fill_black_36dp.png"), showColorInCommandView: Boolean = true)
    : SetTextBackgroundColorCommandBase(icon, defaultColor, showColorInCommandView) {

    override fun selectColor(currentColor: Color, colorSelected: (Color) -> Unit) {
        // nothing to do here
    }

}