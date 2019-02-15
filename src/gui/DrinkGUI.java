

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinkGUI extends JFrame implements ActionListener {
    String category;

    public DrinkGUI(String category){
        this.category = category;
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
            JFrame orderGui = new OrderGUI();
            this.dispose();
        }
    }
}
