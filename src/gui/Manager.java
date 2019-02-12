import java.awt.*; //for graphics, some components
import javax.swing.*;//for most components
import java.awt.event.*;//for event handling


public class Manager extends JFrame implements ActionListener {

    //Enum of the types of GUI available
    enum GuiType{
        main,
        staff
    }
    //These are variables that will be used in multiple methods
    CompetitorList competitor = new CompetitorList();
    //These are the variables that manipulate the MainGui
    JTextField text,result;
    JTextArea displayText;
    JFrame mainGuiFrame= new JFrame("Main program");
    JButton switchToStaffViewButton = new JButton("SwitchToStaffView");
    JButton getListByIDButton = new JButton("GetListByID");
    JButton getListByFirstNameButton = new JButton("GetListByFirstName");
    JButton updateButton = new JButton("Update");
    String[] choices = {"All","Karan", "Lorenzo", "Sabrina", "Timal"};
    JComboBox<String> choice = new JComboBox<String>(choices);
    JPanel searchIDPanel = new JPanel();
    JButton searchButton = new JButton("Search");
    Checkbox openExtraGui = new Checkbox("Open extra GUI", null, false);

    //These are the variables that manipulate the StaffGui
    JFrame staffFrame = new JFrame("StaffList");
    JTextField IDField = new JTextField("",10);
    JTextField idTextField = new JTextField("", 10);
    JTextField nameTextField = new JTextField("", 10);
    JTextField scoreTextField = new JTextField("", 10);
    JButton submitButton = new JButton("Submit");
    JTextField setScoreTextField = new JTextField("", 10);
    JButton switchToMainFrame = new JButton("Back");

    //These are the separate competitor GUI
    LorenzoGUI lorenzo;
    KaranGUI karanGui;
    SabrinaGUI sabrinaGui;
    GUIsection timalGui;
    //Manager Constructor Class
    public Manager()
    {
        //populate the competitorList
        competitor.populate();

        //Initializes all GUI elements, sets visibility to false
        MainGui();
        StaffGui();

        //Switches the visibility of main GUI
        SwitchGUI(GuiType.main);
    }


    @Override //Overrides the actionPerformed class
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == switchToStaffViewButton)
        {
            disposeAllExtraAttributesGui();
            SwitchGUI(GuiType.staff);
        }else if(e.getSource() == getListByIDButton)
        {
            displayText.setText(competitor.getCompetitorsByID());
        }else if(e.getSource() == getListByFirstNameButton) {
            displayText.setText(competitor.getCompetitorsByName());
        }else if(e.getSource() == searchButton) {
            String temp = "";
            temp = text.getText();
            if(temp.length() == 3)
            {
                result.setText(competitor.readIDFromTextFile("Report",temp,"", ""));
            }else {
                result.setText("INVALID");
            }
        }else if(e.getSource() == updateButton)
        {
            String temp ="";
            temp = IDField.getText();
            if(temp.length() == 3)
            {
                idTextField.setText(competitor.readIDFromTextFile("Report", temp, "ID", ""));
                nameTextField.setText(competitor.readIDFromTextFile("Report", temp, "Name", ""));
                scoreTextField.setText(competitor.readIDFromTextFile("Report", temp, "Score",""));

            }
        }else if(e.getSource() == submitButton)
        {
            String[] parts = setScoreTextField.getText().split(" ");
            System.out.println(parts.length);
            boolean invalid = false;
            if(parts.length == 5 && IDField.getText() != null && IDField.getText() != "INVALID")
            {
                int[] tempScores = new int[5];

                for (int i = 0; i < parts.length; i++)
                {
                    if(isNumeric(parts[i]))
                    {
                        tempScores[i] = Integer.parseInt(parts[i]);
                    }else
                    {
                        invalid = true;
                        return;
                    }

                }
                if(invalid == false)
                {
                    competitor.setScore(tempScores, IDField.getText());
                }
            }
        }else if(e.getSource() == switchToMainFrame)
        {
            SwitchGUI(GuiType.main);
        }else if(e.getSource() == choice) {
            String currentSelectedItem = choice.getSelectedItem().toString();

            switch (currentSelectedItem) {
                case "All":  competitor.typeOfList = ListType.All;
                    break;
                case "Karan":  competitor.typeOfList = ListType.Karan;
                    break;
                case "Lorenzo":  competitor.typeOfList = ListType.Lorenzo;
                    break;
                case "Sabrina":  competitor.typeOfList = ListType.Sabrina;
                    break;
                case "Timal":  competitor.typeOfList = ListType.Timal;
                    break;
                default: competitor.typeOfList = ListType.All;
                    break;
            }
            if(openExtraGui.getState())
            {
                extraAttributesGui(competitor.typeOfList);
            }else {
                getListByIDButton.doClick();
            }
        }
    }
    //This method calls the GUI of other competitor classes
    private void extraAttributesGui(ListType currentList)
    {
        disposeAllExtraAttributesGui();
        if(currentList == ListType.Lorenzo)
        {
            lorenzo = new LorenzoGUI(displayText, competitor);
        }else if (currentList == ListType.Karan)
        {
            karanGui = new KaranGUI(competitor);
        }else if(currentList == ListType.Sabrina)
        {
            sabrinaGui = new SabrinaGUI(competitor);
        }else if(currentList == ListType.Timal)
        {
            timalGui = new GUIsection(competitor);
        }
    }

    //disposes all extra attribute GUIs if they exist
    private void disposeAllExtraAttributesGui()
    {
        if(lorenzo != null) {
            lorenzo.dispose();
        }
        if(karanGui != null) {
            karanGui.dispose();
        }

        if(sabrinaGui != null) {
            sabrinaGui.dispose();
        }

        if(timalGui != null) {
            timalGui.dispose();
        }
    }
    //Switches to visibility of a Gui on and/or off
    private void SwitchGUI(GuiType g)
    {
        if(g == g.staff) {
            mainGuiFrame.dispose();
            staffFrame.setVisible(true);
            staffFrame.setSize(400,400);
            staffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if(g == g.main) {
            staffFrame.dispose();
            mainGuiFrame.setVisible(true);
            mainGuiFrame.setSize(600,600);
            mainGuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    //creates the StaffGui
    private void StaffGui()
    {
        JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.setLayout(new GridLayout(7,1));
        mainPanel.setBackground(Color.BLACK);

        JPanel enterIDPanel = new JPanel();
        JLabel IDLabel = new JLabel("Enter ID");
        enterIDPanel.add(IDLabel);
        enterIDPanel.add(IDField);


        JPanel idTextPanel = new JPanel();
        JLabel idLabel = new JLabel("ID");
        idTextField.setEditable(false);
        idTextPanel.add(idLabel);
        idTextPanel.add(idTextField);

        JPanel nameTextPanel = new JPanel();
        JLabel nameLabel = new JLabel("Name");
        nameTextField.setEditable(false);
        nameTextPanel.add(nameLabel);
        nameTextPanel.add(nameTextField);

        JPanel scoreTextPanel = new JPanel();
        JLabel scoreTextLabel = new JLabel("Scores");
        scoreTextField.setEditable(false);
        scoreTextPanel.add(scoreTextLabel);
        scoreTextPanel.add(scoreTextField);

        JPanel updatePanel = new JPanel();
        JLabel updateLabel = new JLabel("Updated");
        updateButton.addActionListener(this);

        updatePanel.add(updateLabel);
        updatePanel.add(updateButton);


        JPanel setScorePanel = new JPanel();
        JLabel setScoreLabel = new JLabel("Score");
        setScorePanel.add(setScoreLabel);
        setScorePanel.add(setScoreTextField);

        JPanel submitPanel = new JPanel();
        submitButton.addActionListener(this);
        submitPanel.add(submitButton);

        switchToMainFrame.addActionListener(this);
        submitPanel.add(switchToMainFrame);

        mainPanel.add(enterIDPanel);
        mainPanel.add(updatePanel);
        mainPanel.add(idTextPanel);
        mainPanel.add(nameTextPanel);
        mainPanel.add(scoreTextPanel);
        mainPanel.add(setScorePanel);
        mainPanel.add(submitPanel, BorderLayout.EAST);
        staffFrame.add(mainPanel,BorderLayout.CENTER);
        staffFrame.pack();
    }

    //Checks if a string isNumeric or not
    public boolean isNumeric(String s) {
        if(s != null && s.matches("[-+]?\\d*\\.?\\d+"))
        {
            return true;
        }else
        {
            return false;
        }
    }

    //Creates the MainGui
    public void MainGui()
    {
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.blue);
        switchToStaffViewButton.addActionListener(this);
        getListByIDButton.addActionListener(this);
        getListByFirstNameButton.addActionListener(this);
        choice.addActionListener(this);
        topPanel.add(switchToStaffViewButton);
        topPanel.add(getListByIDButton);
        topPanel.add(getListByFirstNameButton);


        searchIDPanel.setBackground(Color.red);

        JLabel lab2 = new JLabel("Enter ID");
        searchButton.addActionListener(this);
        text = new JTextField("", 10);

        searchIDPanel.add(lab2);
        searchIDPanel.add(text);
        searchIDPanel.add(searchButton);
        searchIDPanel.add(choice);
        searchIDPanel.add(openExtraGui);
        JPanel searchResultsPanel = new JPanel();

        result = new JTextField(25);
        result.setEditable(false);
        searchResultsPanel.add(result);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(searchIDPanel);
        southPanel.add(searchResultsPanel);

        JPanel midPanel = new JPanel();
        displayText = new JTextArea(15,50);
        displayText.setFont(new Font(Font.MONOSPACED,Font.PLAIN,14));
        displayText.setEditable(false);
        JScrollPane scroll = new JScrollPane (displayText);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        midPanel.setLayout(new GridBagLayout());

        midPanel.setLayout(new BorderLayout());
        midPanel.add(scroll, BorderLayout.CENTER);
        midPanel.setBorder(BorderFactory.createEmptyBorder(35,10,35,10));

        midPanel.add(scroll);
        midPanel.setBackground(Color.cyan);
        //midPanel.add(displayText);

        mainGuiFrame.add(topPanel, BorderLayout.NORTH);
        mainGuiFrame.add(midPanel, BorderLayout.CENTER);
        mainGuiFrame.add(southPanel, BorderLayout.SOUTH);

        mainGuiFrame.pack();
        mainGuiFrame.setVisible(true);
    }


}