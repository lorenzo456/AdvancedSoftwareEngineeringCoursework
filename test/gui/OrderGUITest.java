package gui;

import domain.MenuList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class OrderGUITest {
    MenuList menuList;

    @Before
    public void setUp(){
        menuList = new MenuList();
    }

    @Test
    public void initGUI() {
        String error1 = "Failed to show GUI";
        OrderGUI orderGUI1 = new OrderGUI(this.menuList);
        orderGUI1.initGUI();
        boolean actual1 = orderGUI1.isVisible();
        assertEquals(error1, true, actual1);

        int expectedWidth = 1024;
        int expectedHeight = 800;
        String error2 = " It is not this width";
        String error3 = "It is not this height";
        OrderGUI orderGUI2 = new OrderGUI(this.menuList);
        int actualWidth = orderGUI2.getWidth();
        int actualHeight = orderGUI2.getHeight();
        assertEquals(error2, expectedWidth, actualWidth);
        assertEquals(error3,expectedHeight,actualHeight);

    }

    @Test
    public void testCreateBasketPanel() {
        OrderGUI orderGUI1 = new OrderGUI(this.menuList);
        JPanel basketPanel = orderGUI1.createBasketPanel();
        assertThat(basketPanel.getComponents()[0], instanceOf(JLabel.class));

        OrderGUI orderGUI2 = new OrderGUI(this.menuList);
        JPanel basketPanel1 = orderGUI2.createBasketPanel();
        assertThat(basketPanel1.getComponents()[1], instanceOf(JButton.class));
    }


    @Test
    public void actionPerformed() throws Exception {
        String error1 = "JFrame was not disposed";
        OrderGUI orderGUI2 = new OrderGUI(this.menuList);
        ActionEvent action = new ActionEvent(this, 1, "Hot Drinks");
        orderGUI2.actionPerformed(action);

        //Disposed JFrame is marked undisplayable
        assertEquals(error1, orderGUI2.isDisplayable(), false);
    }
}