package gui;

import domain.*;

import java.awt.*;
import java.awt.event.*;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;

import gui.HotDrinksGUI;


public class PaidGUI extends JFrame implements ActionListener{

    private Font labelFont = new Font("Serif", Font.BOLD, 30);
    private Border border = BorderFactory.createLineBorder(Color.BLACK);

    public PaidGUI() {

    }
     
    public void initGUI() {

        setupNorthPanel();

        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1024, 800);
        setVisible(true);
    }

    private void setupNorthPanel() {

    }

    public void actionPerformed(ActionEvent e) {

    }
}
