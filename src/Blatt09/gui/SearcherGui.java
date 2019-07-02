package Blatt09.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class SearcherGui extends Frame {



    public static void main(String[] args) {
        new SearcherGui();
    }


    public SearcherGui(){
        Frame frame;
        Checkbox box;
        TextField field;
        boolean[] recursiv = {false};
        frame = new Frame("Test");
        frame.addWindowListener(new MyWindowListener());
        box = new Checkbox("Recursive Suche");
        box.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(recursiv[0]){
                    recursiv[0]= false;
                }else recursiv[0]=true;
                System.out.println(recursiv[0]);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        field = new TextField("Suchwort",20);
        field.addKeyListener(new KeyListener() {
            LinkedList<String> list= new LinkedList();
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        frame.add(box);
        frame.add(field);
        pack();
        frame.setVisible(true);
        frame.setSize(200,200);
    }


}
