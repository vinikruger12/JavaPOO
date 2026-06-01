package Interface;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public MyFrame(){
        this.setSize(WIDTH, HEIGHT);

        GridLayout gl = new GridLayout(0,2);

        TextField temp = new TextField("Digite aqui o seu valor");
        this.add(temp);

        JButton button1 = new JButton("Botão 1");
        JButton button2 = new JButton("Botão 2");
        JButton button3 = new JButton("Botão 3");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp.setText("Hello World");
            }
        };
        ActionListener retorna = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp.setText("Digite aqui o seu valor");
            }
        };
        button3.addActionListener(listener);
        button2.addActionListener(retorna);
        this.setLayout(gl);

        this.add(button1);
        this.add(button2);
        this.add(button3);

        

        
        
    }

}
