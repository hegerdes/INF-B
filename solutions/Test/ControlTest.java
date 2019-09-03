package Test;

import java.awt.*;

/**
 * Demonstration of different control elements
 */

public class ControlTest extends Frame {
    private static final long serialVersionUID = -9145074621694708583L;

    Panel aPanel;   // German: Feld
    Button aButton; // German: Schaltflaeche
    Canvas aCanvas; // German: Leinwand
    CheckboxGroup aCheckboxGroup; // German: Kreuzel Gruppe
    Checkbox aCheckbox;
    Choice aChoice; // German: Auswahl(liste)
    Label aLabel; // German: Beschriftung
    List aList;   // German: Liste, Kombinationsfeld
    Scrollbar aScrollbar; // German: Rollbalken
    TextField aTextField;
    TextArea aTextArea;

    public static void main(String[] args) {
        new ControlTest();
    }

    public ControlTest() {
        // calling the super constructor (i.e. that of class Frame)
        // setting the title of our main window
        super("Hauptfenster mit verschiedenen Steuerelementen");

        // set the position and size of the main window
        setLocation(0,0);
        setSize(450,150);

        // creating our button
        aButton = new Button("eine Schaltläche");

        // creating our canvas to paint on, set background color and size
        aCanvas = new Canvas();
        aCanvas.setBackground(Color.cyan);
        aCanvas.setSize(50,50);

        // creating our checkbox (field to mark)
        aCheckbox = new Checkbox("Hier ankreuzen!", aCheckboxGroup, true);

        // creating our choice element and insert three entries
        aChoice = new Choice();
        aChoice.addItem("erster Eintrag");
        aChoice.addItem("zweiter Eintrag");
        aChoice.addItem("dritter Eintrag");

        // creating our text line
        aLabel = new Label("Hier ist die Beschriftung (Label)");

        // creating our list with five entries
        aList = new List();
        aList.add("erster Eintrag");
        aList.add("zweiter Eintrag");
        aList.add("dritter Eintrag");
        aList.add("vierter Eintrag");
        aList.add("fünfter Eintrag");

        // creating our horizontal scrollbar (orientation, start value, visible, min value, max value)
        //  visible means: the size of the visible portion of the scrollable area. The scrollbar will use this value when paging up or down by a page.
        aScrollbar = new Scrollbar(Scrollbar.HORIZONTAL,40,100,00,100);

        // creating our text field (one line) with 20 columns
        aTextField = new TextField("Eintrag im Textfeld",20);

        // creating our text area for multiple entry lines (5 rows, 30 columns)
        aTextArea = new TextArea("Eintrag im Textbereich",5,30);

        // creating our panel area + set its size, position and layout manager
        aPanel = new Panel();
        aPanel.setSize(this.getSize());
        aPanel.setLocation(0,0);
        // aPanel.setLayout(new GridLayout(3,3));

        // now add all our control elements into our panel
        aPanel.add("Test",aButton);
        aPanel.add(aCanvas);
        aPanel.add(aCheckbox);
        aPanel.add(aChoice);
        aPanel.add(aLabel);
        aPanel.add(aList);
        aPanel.add(aScrollbar);
        aPanel.add(aTextField);
        aPanel.add(aTextArea);

        // now add the panel to our main window (next window hierarchy)
        add(aPanel);

        // show our main window
        pack();
        setVisible(true);
    }
}
