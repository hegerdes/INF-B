package Test;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

/**
 * Demonstration of different window types
 */

class WindowsTest extends Frame {
    // version number in case we want to serialize
    private static final long serialVersionUID = -7490649702405270752L;

    Window aNormalWindow;

    Frame aWindowWithAFrame;

    Dialog aModalDialogBox;

    FileDialog aFileOpenDialog;

    public static void main(String[] args) {
        new WindowsTest();
    }

    public WindowsTest() {
        // calling the constructor of the superclass
        super();

        // position, size and title of the main window
        setLocation(0, 0);
        setSize(100, 300);
        setTitle("The Main Window");

        // shows the main window on the screen
        setVisible(true);

        // initialize and show the different sub windows
        aWindowWithAFrame = new Frame("My Frame");
        aWindowWithAFrame.setSize(300, 100);
        aWindowWithAFrame.setLocation(100, 0);
        aWindowWithAFrame.setVisible(true);

        // a dialog (it is not a modal one if the third parameter in the constructor is false)
        aModalDialogBox = new Dialog(aWindowWithAFrame, "My Dialog",
                false);
        aModalDialogBox.setLocation(100, 100);
        aModalDialogBox.setSize(300, 200);
        aModalDialogBox.setVisible(true);

        aNormalWindow = new Window(aWindowWithAFrame);
        aNormalWindow.setLocation(0, 300);
        aNormalWindow.setSize(300, 100);
        aNormalWindow.setVisible(true);

        // FileDialog is always modal (i.e. blocks until a user input)
        aFileOpenDialog = new FileDialog(aWindowWithAFrame, "Open File");
        aFileOpenDialog.setVisible(true);
    }
}
