package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    public MenuPanel(ActionListener parent){
        super();

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.WHITE);

        JButton showHotDrinks = new JButton("Hot Drinks");
        showHotDrinks.addActionListener(parent);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridwidth = 1;
        c1.weightx = 1;
        c1.weighty = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        c1.insets = new Insets(70,70,70,70);
        this.add(showHotDrinks, c1);

        JButton showColdDrinks= new JButton("Cold Drinks");
        showColdDrinks.addActionListener(this);
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridwidth = 1;
        c2.weightx = 1;
        c2.weighty = 1;
        c2.gridx = 1;
        c2.gridy = 0;
        c2.insets = new Insets(70,70,70,70);
        this.add(showColdDrinks, c2);

        JButton showMeal= new JButton("Meal");
        showMeal.addActionListener(this);
        GridBagConstraints c3 = new GridBagConstraints();
        c3.fill = GridBagConstraints.BOTH;
        c3.gridwidth = 1;
        c3.weightx = 0.5;
        c3.weighty = 1;
        c3.gridx = 0;
        c3.gridy = 1;
        c3.insets = new Insets(70,70,70,70);
        this.add(showMeal, c3);

        JButton showDessert = new JButton("Dessert");
        showDessert.addActionListener(this);
        GridBagConstraints c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.BOTH;
        c4.gridwidth = 1;
        c4.weightx = 0.5;
        c4.weighty = 1;
        c4.gridx = 1;
        c4.gridy = 1;
        c4.insets = new Insets(70,70,70,70);
        this.add(showDessert, c4);

        JPanel offerPanel = new JPanel();
        offerPanel.setLayout(new GridBagLayout());
        showDessert.addActionListener(this);
        GridBagConstraints o0 = new GridBagConstraints();
        o0.fill = GridBagConstraints.BOTH;
        o0.gridwidth = 2;
        o0.weightx = 0.5;
        o0.weighty = 1;
        o0.gridy = 2;

        JButton showOffer1 = new JButton("Offer 1");
        showOffer1.addActionListener(this);
        GridBagConstraints o1 = new GridBagConstraints();
        o1.fill = GridBagConstraints.BOTH;
        o1.gridwidth = 1;
        o1.weightx =  0.25;
        o1.weighty = 1;
        o1.gridx = 0;
        o1.gridy = 0;
        offerPanel.add(showOffer1, o1);

        JButton showOffer2 = new JButton("Offer 2");
        showOffer2.addActionListener(this);
        GridBagConstraints o2 = new GridBagConstraints();
        o2.fill = GridBagConstraints.BOTH;
        o2.gridwidth = 1;
        o2.weightx =  0.25;
        o2.weighty = 1;
        o2.gridx = 1;
        o2.gridy = 0;
        offerPanel.add(showOffer2, o2);

        JButton showOffer3 = new JButton("Offer 3");
        showOffer3.addActionListener(this);
        GridBagConstraints o3 = new GridBagConstraints();
        o3.fill = GridBagConstraints.BOTH;
        o3.gridwidth = 1;
        o3.weightx =  0.25;
        o3.weighty = 1;
        o3.gridx = 2;
        o3.gridy = 0;
        offerPanel.add(showOffer3, o3);

        this.add(offerPanel, o0);
    }
}
