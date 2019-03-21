package OrderSystemGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Staff;
import utils.Logger;

public class OrderSystemController implements ActionListener {
    private OrderSystemModel orderSystemModel;
    private OrderSystemView orderSystemView;

    private static Logger logger = Logger.getInstance();

    public OrderSystemController(OrderSystemModel orderSystemModel) {
        this.orderSystemModel = orderSystemModel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("StartProcessing")) {
            if (!orderSystemModel.isInitialized()) {
                logger.info("Programs started processing orders");
                orderSystemModel.StartProgram();
                orderSystemView.AddInitialStaffUI();
                orderSystemModel.setInitialized(true);
            }
        }

        if (actionEvent.getActionCommand().equals("+")) {
            int speed = this.orderSystemModel.increaseSpeed();
            this.orderSystemModel.SetStaffSpeed(speed);
            orderSystemView.SetSpeedText(speed);
        }

        if (actionEvent.getActionCommand().equals("-")) {
            int speed = this.orderSystemModel.decreaseSpeed();
            this.orderSystemModel.SetStaffSpeed(speed);
            orderSystemView.SetSpeedText(speed);
        }

        if (actionEvent.getActionCommand().equals("OrderOnline")) {
            orderSystemModel.OrderOnline();
        }

        if (actionEvent.getActionCommand().equals("AddStaff")) {
            if (orderSystemModel.isInitialized()) {
                logger.info("Added staff member");
                Staff temp = orderSystemModel.AddStaff();
                orderSystemView.AddStaffUI(temp);
                temp.start();
            }
        }

        if (actionEvent.getActionCommand().equals("RemoveStaff")) {
            if (orderSystemModel.hasStaff() && orderSystemModel.isInitialized()){
                logger.info("Removed staff member");
                Staff temp = orderSystemModel.RemoveStaff();
                orderSystemView.RemoveStaffUI(temp);
                temp.finish();
            }
        }
    }

    public void setView(OrderSystemView orderSystemView) {
        this.orderSystemView = orderSystemView;
    }
}
