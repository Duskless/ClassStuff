/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awtPractice;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author mfaux02
 */
public class AWTPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowWorld ww = new WindowWorld();
    }
    
}

class WindowWorld extends Frame implements ActionListener{
    public Button hello;
    public Button goodbye;
    WindowWorld(){
        addWindowListener(new MyWindowAdapter());
        
        setSize(300,300);
        setTitle("Practice");
        hello = new Button();
        hello.setActionCommand("Hello");
        hello.setLabel("Hello");
        hello.addActionListener(this);
        
        goodbye = new Button();
        goodbye.setActionCommand("Goodbye");
        goodbye.setLabel("Goodbye");
        goodbye.addActionListener(this);
        
        add(hello);
        
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("Hello")){
           System.out.println("Hello World");
           removeAll();
           add(goodbye);
           setVisible(true);
       }else if(e.getActionCommand().equals("Goodbye")){
           System.out.println("Goodbye World");
           System.exit(0);
       }
    }
    
}

class MyWindowAdapter extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}

