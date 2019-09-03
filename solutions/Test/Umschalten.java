package Test;

import javax.swing.*;


public class Umschalten {

    public static void main(String[] args) {
        Model m = new Model();
        Views v = new Views(m);

        JFrame frame = new JFrame("Umschalten");
       // frame.setContentPane(v);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static class Model {

    }

    private static class Views {
        private Model m;

        public Views(Model model){
            m=model;
        }
    }
}
