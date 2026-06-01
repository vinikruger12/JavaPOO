package Interface;

import javax.swing.JFrame;


public class Main {
    public static void main(String[] args){
        MyFrame myFrame = new MyFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.setResizable(true);
        myFrame.setTitle("MyFrame");


    }
}
