package net.dankito.richtexteditor.java.fx.command

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import net.dankito.utils.image.ImageReference
import net.dankito.richtexteditor.command.InsertImageCommandBase
import net.dankito.utils.javafx.ui.image.JavaFXImageReference
import net.dankito.richtexteditor.java.fx.command.dialogs.EditImageDialog
import net.dankito.richtexteditor.java.fx.extensions.addKeyboardShortcut
import net.dankito.richtexteditor.java.fx.localization.Localization
import net.dankito.richtexteditor.java.fx.toolbar.EditorToolbar
import net.dankito.utils.image.JavaImageUtils
import java.io.File


open class InsertImageCommand(private val toolbar: EditorToolbar, private val localization: Localization, icon: ImageReference = JavaFXImageReference.fromIconsResourceName("ic_insert_photo_black_36dp.png"))
    : InsertImageCommandBase(icon) {

    val imageUtils = JavaImageUtils()


    init {
        this.addKeyboardShortcut(KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN)) {
            commandInvoked()
        }
    }


    override fun selectImageToInsert(imageSelected: (imageUrl: String, alternateText: String) -> Unit) {
        EditImageDialog.show(localization, toolbar.root.scene?.window, imageSelected)
    }


    override fun getImageRotation(localImage: File): Int {
        return imageUtils.getImageOrientationInDegree(localImage)
    }

}