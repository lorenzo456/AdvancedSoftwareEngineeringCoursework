package gui;

import domain.Basket;
import domain.MenuList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotDrinksGUI extends JFrame implements ActionListener {
    private String category;
    private MenuList menuList;
    private Basket basket;

    public HotDrinksGUI(String category, Basket basket, MenuList menuList){
        this.category = category;
        this.basket = basket;
        this.menuList = menuList;
        this.initGUI();
    }

    /**
     * Initialize GUI
     */
    public void initGUI() {
        setupNorthPanel();

        pack();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1024, 800);
        setVisible(true);
    }


    private void setupNorthPanel() {
        JPanel northPanel = new JPanel();

        JButton backToOrders = new JButton("Go Back");
        backToOrders.addActionListener(this);
        northPanel.add(backToOrders, BorderLayout.WEST);

        this.add(northPanel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Go Back")) {
            JFrame orderGui = new OrderGUI(this.basket);
            this.dispose();
        }
    }
}
