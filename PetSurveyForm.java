package com.maia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Maia on 3/22/2017.
 */
public class PetSurveyForm extends JFrame{
    private JCheckBox dogCheckBox;
    private JCheckBox fishCheckBox;
    private JCheckBox catCheckBox;
    private JButton quitButton;
    private JLabel surveyResultsLabel;
    private JPanel mainPanel;

    private boolean fish;
    private boolean dog;
    private boolean cat;

    PetSurveyForm(){
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setTitle("Pet Survey Program");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dog = dogCheckBox.isSelected();
                updateResults();
            }
        });


        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fish = fishCheckBox.isSelected();
                updateResults();

            }
        });



        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            cat = catCheckBox.isSelected();
            updateResults();

            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurveyForm.this,
                        "Are you sure?", "Quit",
                        JOptionPane.OK_CANCEL_OPTION);

                if (quit == JOptionPane.OK_OPTION){
                    System.exit(0);
                }

            }
        });
    }
    private void updateResults() {
        String hasDog = dog ? "one dog " : "no dogs";
        String hasCat = cat ? "one cat " : "no cats";
        String hasFish = fish ? "one fish " : "no fish";

        String results = "You have " + hasDog + " and " +
                hasCat + " and " + hasFish;
        surveyResultsLabel.setText(results);
    }

}
