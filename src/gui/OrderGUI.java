package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;


public class OrderGUI extends JFrame implements ActionListener{
    private boolean isMenuVisible = true;

    private JPanel centerPanel;
    private Font labelFont = new Font("Serif", Font.BOLD, 30);
    private Border border = BorderFactory.createLineBorder(Color.BLACK);

    public OrderGUI() {
        this.initGUI();

    }

    public void initGUI() {

        setupNorthPanel();
        setupCenterPanel();

        pack();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1024, 800);
        setVisible(true);
    }

    private void setupNorthPanel() {
        JPanel northPanel = new JPanel();

        northPanel.setLayout(new BorderLayout());
        northPanel.setPreferredSize(new Dimension(1024, 120));
        northPanel.setBorder(border);
        northPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Coffee Bar Menu");
        label.setFont(labelFont);
        northPanel.add(label, BorderLayout.WEST);

        this.add(northPanel, BorderLayout.NORTH);
    }


    private JPanel createBasketPanel(){
        JPanel basketPanel = new JPanel();
        basketPanel.setLayout(new BorderLayout());
        basketPanel.setBackground(Color.WHITE);
        basketPanel.setBorder(border);

        JLabel label = new JLabel("Basket");
        label.setFont(labelFont);
        basketPanel.add(label, BorderLayout.NORTH);

        return basketPanel;
    }

    private void setupCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);

        JPanel menuPanel = new MenuPanel(this);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridwidth = 1;
        c1.weightx = 4;
        c1.weighty = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        centerPanel.add(menuPanel, c1);

        JPanel basketPanel = this.createBasketPanel();
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.weightx = 6;
        c2.weighty = 1;
        c2.gridx = 1;
        c2.gridy = 0;
        centerPanel.add(basketPanel, c2);

        this.validate();
        this.add(centerPanel, BorderLayout.CENTER);
    }


    private void setupCenterPanel(String category) {
        if(centerPanel != null){
            this.getContentPane().remove(centerPanel);
            this.getContentPane().revalidate();
        }
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);

        JPanel menuPanel = new MenuItemsPanel(category, items);
        GridBagConstraints c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.BOTH;
        c1.gridwidth = 1;
        c1.weightx = 4;
        c1.weighty = 1;
        c1.gridx = 0;
        c1.gridy = 0;
        centerPanel.add(menuPanel, c1);

        JPanel basketPanel = this.createBasketPanel();
        GridBagConstraints c2 = new GridBagConstraints();
        c2.fill = GridBagConstraints.BOTH;
        c2.gridwidth = 1;
        c2.gridheight = 1;
        c2.weightx = 6;
        c2.weighty = 1;
        c2.gridx = 1;
        c2.gridy = 0;
        centerPanel.add(basketPanel, c2);

        this.validate();
        this.add(centerPanel, BorderLayout.CENTER);
    }


    public void startOrders(){}

    public void completeOrders(){}

    public void displayBill(){}

    public void applyDiscount(){}

    public void addToBill(){}

    public void removeFromBill(){}

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Hot Drinks")) {
            this.setupCenterPanel("Hot Drinks");
        }
        if (e.getActionCommand().equals("Cold Drinks")) {
            this.setupCenterPanel("Cold Drinks");
        }
        if (e.getActionCommand().equals("Dessert")) {
            this.setupCenterPanel("Dessert");
        }
        if (e.getActionCommand().equals("Meal")) {
            this.setupCenterPanel("Meal");
        }
    }
}





































