package com.Josh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Destro on 4/25/2016.
 */
public class DogGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField dogAgeTextField;
    private JCheckBox puppyCheckBox;
    private JButton addDogToListButton;
    private JList dogJList;
    private JTextField dogNameTextField;
    private JButton deleteDogButton;

    DefaultListModel<Dog> dogListModel;
    protected DogGUI() {
        super("List of Dogs");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        dogListModel = new DefaultListModel<>();
        dogJList.setModel(dogListModel);
        dogJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addDogToListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dogName = dogNameTextField.getText();
                double dogAge;

                //validation to make sure picks a positive number//

                try {
                    dogAge = Double.parseDouble(dogAgeTextField.getText());
                    if (dogAge < 0) {
                        JOptionPane.showMessageDialog(DogGUI.this, "Enter a positive number for the age");
                        return;
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(DogGUI.this, "Enter a number for the age");
                    return;

                }
                boolean isPuppy = puppyCheckBox.isSelected();
                Dog newDog = new Dog(dogName, dogAge, isPuppy);
//                for (int x = 1, x < dogJList.)
//                if (newDog == dogJList.)
//                }else{
                    dogListModel.addElement((newDog));
//              }
            }
        });
        deleteDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dog toDelete = (Dog) dogJList.getSelectedValue();
                dogListModel.removeElement(toDelete);
            }
        });
    }


}
