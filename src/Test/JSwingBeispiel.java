package Test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class JSwingBeispiel extends JFrame implements ActionListener {

    // Steuerlemente des Programms:
    // ohne Hilfselemente (JLabel, JPanel etc.)

    // Schaltflaechen und Eingabefelder
    JButton button1, button2;

    JCheckBox checkBox;

    JPasswordField passwortField;

    JRadioButton radioButtonJava, radioButtonWindows, radioButtonMotif;

    ButtonGroup buttonGroup;

    JToolBar toolBar;

    // Rollbalken, Slider, Fortschrittsbalken
    JProgressBar progressBar;

    JScrollBar scrollBar;

    JSlider slider;

    // verschiedene Fenstertypen
    JSplitPane splitPane;

    JTabbedPane tabbedPane;

    // Listen
    JComboBox comboBox;

    JList listComponent;

    // Tabellen und Baeume
    JTable table;

    JTree tree;

    public static void main(String[] args) {
        new JSwingBeispiel();
    }

    public JSwingBeispiel() {

        setSize(800, 600);
        setTitle("Uebersicht der Swing-Elemente");

        // Layoutmanager erzeugen und zuordnen
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagLayoutWerte = new GridBagConstraints();

        gridBagLayoutWerte.fill = GridBagConstraints.BOTH;
        gridBagLayoutWerte.weightx = 1;
        gridBagLayoutWerte.weighty = 1;
        gridBagLayoutWerte.anchor = GridBagConstraints.NORTHWEST;
        getContentPane().setLayout(gridBagLayout);

        // Steuerelemente erzeugen und zuordnen
        button1 = new JButton("Schaltflaeche 1");
        button1.setToolTipText("JButton: Schaltflaeche 1");
        button1.registerKeyboardAction(this, "Beenden", KeyStroke
                        .getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        button2 = new JButton("Schaltflaeche 2");
        button2.setToolTipText("JButton: Schaltflaeche 2");

        toolBar = new JToolBar();
        toolBar.setPreferredSize(new Dimension(133, 66));
        toolBar.add(button1);
        toolBar.add(button2);
        toolBar.setToolTipText("JToolBar: Werkzeugleiste");
        toolBar
                .setBorder(BorderFactory
                        .createTitledBorder("JToolBar: Werkzeugleisteleiste mit Schaltflaechen (JButton)"));

        gridBagLayoutWerte.gridwidth = 1;
        gridBagLayoutWerte.gridheight = 1;
        gridBagLayoutWerte.gridx = 0;
        gridBagLayoutWerte.gridy = 0;
        gridBagLayout.setConstraints(toolBar, gridBagLayoutWerte);
        getContentPane().add(toolBar);
        buttonGroup = new ButtonGroup();

        JPanel RadioPanel = new JPanel();
        RadioPanel.setLayout(new GridLayout(3, 1));
        radioButtonJava = new JRadioButton("Java Look and Feel", true);
        radioButtonJava.setActionCommand("Java");
        radioButtonJava.addActionListener(this);
        RadioPanel.add(radioButtonJava);
        buttonGroup.add(radioButtonJava);

        radioButtonWindows = new JRadioButton("Windows Look and Feel", false);
        radioButtonWindows.setActionCommand("Windows");
        radioButtonWindows.addActionListener(this);
        RadioPanel.add(radioButtonWindows);
        buttonGroup.add(radioButtonWindows);

        radioButtonMotif = new JRadioButton("Motif Look and Feel", false);
        radioButtonMotif.setActionCommand("Motif");
        radioButtonMotif.addActionListener(this);
        RadioPanel.add(radioButtonMotif);
        buttonGroup.add(radioButtonMotif);

        RadioPanel.setBorder(BorderFactory
                .createTitledBorder("JRadioButton: Radiobuttons als Gruppe"));
        RadioPanel.setToolTipText("JRadioButton: Auswahlschalter");
        gridBagLayoutWerte.gridwidth = 1;
        gridBagLayoutWerte.gridheight = 3;
        gridBagLayoutWerte.gridx = 0;
        gridBagLayoutWerte.gridy = 1;
        gridBagLayout.setConstraints(RadioPanel, gridBagLayoutWerte);
        getContentPane().add(RadioPanel);

        checkBox = new JCheckBox("bereits angekreuzt", true);
        checkBox.setToolTipText("JCheckBox: Checkbox");
        checkBox.setBorder(BorderFactory
                .createTitledBorder("JCheckBox: einfache Checkbox"));

        JPanel CheckPanel = new JPanel();
        CheckPanel.add(checkBox);
        CheckPanel.setBorder(BorderFactory
                .createTitledBorder("JRadioButton: Radiobuttons als Gruppe"));
        gridBagLayoutWerte.gridwidth = 1;
        gridBagLayoutWerte.gridheight = 1;
        gridBagLayoutWerte.gridx = 0;
        gridBagLayoutWerte.gridy = 4;
        gridBagLayout.setConstraints(CheckPanel, gridBagLayoutWerte);
        getContentPane().add(CheckPanel);

        progressBar = new JProgressBar();
        progressBar.setOrientation(JProgressBar.HORIZONTAL);
        progressBar.setMaximum(100);
        progressBar.setMinimum(1);
        progressBar.setValue(33);
        progressBar.setToolTipText("JProgressBar: Fortschrittsbalken");
        progressBar.setBorder(BorderFactory
                .createTitledBorder("JProgressBar: Fortschrittsbalken"));
        progressBar.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e){
                int value = progressBar.getValue();
                progressBar.setValue(e.getWheelRotation()+value);
            }
        });

        gridBagLayoutWerte.gridwidth = 1;
        gridBagLayoutWerte.gridheight = 1;
        gridBagLayoutWerte.gridx = 1;
        gridBagLayoutWerte.gridy = 0;
        gridBagLayout.setConstraints(progressBar, gridBagLayoutWerte);
        getContentPane().add(progressBar);

        scrollBar = new JScrollBar();
        scrollBar.setOrientation(JProgressBar.HORIZONTAL);
        scrollBar.setMaximum(100);
        scrollBar.setMinimum(1);
        scrollBar.setValue(33);
        scrollBar.setPreferredSize(new Dimension(100, 25));
        scrollBar.setToolTipText("JScrollBar: Rollbalken");
        scrollBar.setBorder(BorderFactory
                .createTitledBorder("JScrollBar: ein Rollbalken"));
        scrollBar.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e){
                int value = scrollBar.getValue();
                scrollBar.setValue(e.getWheelRotation()+value);
            }
        });
        gridBagLayoutWerte.gridx = 1;
        gridBagLayoutWerte.gridy = 1;
        gridBagLayout.setConstraints(scrollBar, gridBagLayoutWerte);
        getContentPane().add(scrollBar);

        slider = new JSlider();
        slider.setOrientation(JProgressBar.HORIZONTAL);
        slider.setMaximum(100);
        slider.setMinimum(1);
        slider.setValue(33);
        slider.createStandardLabels(10);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory
                .createTitledBorder("JSlider - Stellregler"));
        slider.setToolTipText("JSlider: Stellregler");
        slider.setBorder(BorderFactory
                .createTitledBorder("JSlider: ein Stellregler"));
        slider.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e){
                int value = slider.getValue();
                slider.setValue(e.getWheelRotation()+value);
            }
        });

        gridBagLayoutWerte.gridx = 1;
        gridBagLayoutWerte.gridy = 2;
        gridBagLayout.setConstraints(slider, gridBagLayoutWerte);
        getContentPane().add(slider);

        passwortField = new JPasswordField("test");
        passwortField.setToolTipText("JPasswordField: Passworteingabefeld");
        passwortField
                .setBorder(BorderFactory
                        .createTitledBorder("JPasswordField: Eingabefeld fuer Passwoerter"));
        gridBagLayoutWerte.gridx = 1;
        gridBagLayoutWerte.gridy = 3;
        gridBagLayout.setConstraints(passwortField, gridBagLayoutWerte);
        getContentPane().add(passwortField);

        Object[] comboBoxArray = { "Zeile 1", "Zeile 2", "Zeile 3",
                "Zeile 4", "Zeile 5" };
        comboBox = new JComboBox(comboBoxArray);
        comboBox.setEditable(true);
        comboBox.setPreferredSize(new Dimension(100, 30));
        comboBox.setSelectedItem(comboBoxArray[2]);
        comboBox.setToolTipText("JComboBox: Klappliste");
        comboBox.setBorder(BorderFactory
                .createTitledBorder("JComboBox: editierbare Klappliste"));
        gridBagLayoutWerte.gridx = 1;
        gridBagLayoutWerte.gridy = 4;
        gridBagLayout.setConstraints(comboBox, gridBagLayoutWerte);
        getContentPane().add(comboBox);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(
                "Pakete");
        DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode("java");
        DefaultMutableTreeNode node = new DefaultMutableTreeNode("awt");
        parentNode.add(node);
        node = new DefaultMutableTreeNode("lang");
        parentNode.add(node);
        node = new DefaultMutableTreeNode("io");
        parentNode.add(node);
        node = new DefaultMutableTreeNode("net");
        parentNode.add(node);
        rootNode.add(parentNode);

        parentNode = new DefaultMutableTreeNode("javax");
        node = new DefaultMutableTreeNode("swing");
        parentNode.add(node);
        node = new DefaultMutableTreeNode("servlet");
        parentNode.add(node);
        rootNode.add(parentNode);

        tree = new JTree(rootNode);
        tree.setPreferredSize(new Dimension(150, 200));
        tree.setToolTipText("JTree: Baum-/Outlinesicht");
        tree.setBorder(BorderFactory
                .createTitledBorder("JTree: expandierbarer Hierarchieviewer"));
        gridBagLayoutWerte.gridwidth = 1;
        gridBagLayoutWerte.gridheight = 5;
        gridBagLayoutWerte.gridx = 2;
        gridBagLayoutWerte.gridy = 0;
        gridBagLayout.setConstraints(tree, gridBagLayoutWerte);
        getContentPane().add(tree);

        JPanel leftSide = new JPanel();
        JPanel rightSide = new JPanel();
        rightSide.setBackground(Color.lightGray);
        rightSide.add(new JLabel("rechts"));
        leftSide.add(new JLabel("links"));
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
                leftSide, rightSide);
        splitPane.setToolTipText("JSplitPane: \"Fensterteiler\"");
        splitPane.setBorder(BorderFactory
                .createTitledBorder("JSlitPane: Splitter mit Textlabels"));
        gridBagLayoutWerte.gridwidth = 3;
        gridBagLayoutWerte.gridheight = 1;
        gridBagLayoutWerte.gridx = 0;
        gridBagLayoutWerte.gridy = 5;
        gridBagLayout.setConstraints(splitPane, gridBagLayoutWerte);

        listComponent = new JList(comboBoxArray);
        listComponent.setVisibleRowCount(1);
        listComponent.setFixedCellHeight(15);
        listComponent.setSize(100, 30);
        listComponent.setToolTipText("JListe: einfache Liste");
        JScrollPane aScrollPane = new JScrollPane(listComponent);
        aScrollPane.setBorder(BorderFactory
                .createTitledBorder("JList: Liste (in einem JScrollPane)"));

        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(200, 200));
        tabbedPane.addTab("erster", aScrollPane);
        tabbedPane.addTab("zweiter", new JLabel("Tab2"));
        tabbedPane.addTab("dritter", new JButton("Tab3"));
        tabbedPane.addTab("vierter", new JToggleButton("Tab4"));
        tabbedPane.setToolTipText("JTabbedPane: Registerkarten");
        tabbedPane.setBorder(BorderFactory
                .createTitledBorder("JTabbedPane: Registerkarten"));
        gridBagLayoutWerte.gridwidth = 1;
        gridBagLayoutWerte.gridheight = 1;
        gridBagLayoutWerte.gridx = 0;
        gridBagLayoutWerte.gridy = 6;
        gridBagLayout.setConstraints(tabbedPane, gridBagLayoutWerte);
        getContentPane().add(tabbedPane);

        Object[][] TabellenInhalt = {
                { "Zeile 1, ZelleA", "Zeile 1, ZelleB", "Zeile 1, ZelleC",
                        "Zeile 1, ZelleD" },
                { "Zeile 2, ZelleA", "Zeile 2, ZelleB", "Zeile 2, ZelleC",
                        "Zeile 2, ZelleD" },
                { "Zeile 3, ZelleA", "Zeile 3, ZelleB", "Zeile 3, ZelleC",
                        "Zeile 3, ZelleD" },
                { "Zeile 4, ZelleA", "Zeile 4, ZelleB", "Zeile 4, ZelleC",
                        "Zeile 4, ZelleD" },
                { "Zeile 5, ZelleA", "Zeile 5, ZelleB", "Zeile 5, ZelleC",
                        "Zeile 5, ZelleD" }, };
        Object[] SpaltenNamen = new Object[4];
        SpaltenNamen[0] = new String("Spalte 1");
        SpaltenNamen[1] = new String("Spalte 2");
        SpaltenNamen[2] = new String("Spalte 3");
        SpaltenNamen[3] = new String("Spalte 4");
        table = new JTable(TabellenInhalt, SpaltenNamen);
        table.setGridColor(Color.black);
        table.setShowGrid(true);
        table.setToolTipText("JTable: Tabelle");
        JPanel TabellenPanel = new JPanel();
        TabellenPanel.add(table);
        TabellenPanel
                .setBorder(BorderFactory
                        .createTitledBorder("JTable: beliebig konfigurierbare Tabellen"));

        gridBagLayoutWerte.gridwidth = 2;
        gridBagLayoutWerte.gridheight = 1;
        gridBagLayoutWerte.gridx = 1;
        gridBagLayoutWerte.gridy = 6;
        gridBagLayout.setConstraints(TabellenPanel, gridBagLayoutWerte);
        getContentPane().add(TabellenPanel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Implementierung des ActionListener
    public void actionPerformed(ActionEvent e) {
        String command = new String(e.getActionCommand());
        try {
            if (command.equals("Beenden")) {
                System.exit(0);
            }
            if (command.equals("Java")) {
                radioButtonMotif.setSelected(false);
                radioButtonWindows.setSelected(false);

                UIManager
                        .setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }
            if (command.equals("Windows")) {
                radioButtonMotif.setSelected(false);
                radioButtonJava.setSelected(false);
                UIManager
                        .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }
            if (command.equals("Motif")) {
                radioButtonJava.setSelected(false);
                radioButtonWindows.setSelected(false);
                UIManager
                        .setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                SwingUtilities.updateComponentTreeUI(this);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
