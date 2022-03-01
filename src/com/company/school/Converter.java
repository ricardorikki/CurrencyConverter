package com.company.school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class Converter extends JFrame{
    private JTextField tfInput;
    private JLabel lb_Input;
    private JComboBox cbCurrency;
    private JLabel lb_Currency;
    private JLabel lb_JMD;
    private JButton btnConvert;
    private JButton btnClear;
    private JFormattedTextField forTF;
    private JPanel mainPanel;
    private double Result;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Constructor
    public  Converter(){
        setContentPane(mainPanel);
        setTitle("Currency Converter");
        setSize(450,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //getContentPane().setLayout(new FlowLayout());//specify a layout manager
        getContentPane().setBackground(Color.darkGray);
        setVisible(true);


        //Only numbers can be entered
        tfInput.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_PERIOD))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

        try
        {
            for (UIManager.LookAndFeelInfo lnf :
                    UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(lnf.getName())) {
                    UIManager.setLookAndFeel(lnf.getClassName());
                    break;
                }
            }
        } catch (Exception e) { /* Lazy handling this >.> */ }
        btnConvert.setBackground(new Color(240,240,241));
        btnConvert.setFocusPainted(false);
        btnClear.setBackground(new Color(240,240,241));
        btnClear.setFocusPainted(false);
        //When the Convert Button is Pressed
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

        //When USD is Selected
        if(cbCurrency.getSelectedItem().equals("USD"))
        {
            double usd = 129.02;
            double amount = Double.parseDouble(tfInput.getText());
            Result =   usd * amount;

            BigDecimal bd = new BigDecimal(Result).setScale(2, RoundingMode.HALF_UP);
            double result2 = bd.doubleValue();
            //df.format(Result);
            String str = Double.toString(result2);
            forTF.setText("$"+str);

        }
                //When CAN is Selected
                if(cbCurrency.getSelectedItem().equals("CAN"))
                {
                    double can = 97.50;
                    double amount = Double.parseDouble(tfInput.getText());
                    Result =   can * amount;

                    BigDecimal bd = new BigDecimal(Result).setScale(2, RoundingMode.HALF_UP);
                    double result2 = bd.doubleValue();
                    //df.format(Result);
                    String str = Double.toString(result2);
                    forTF.setText("$"+str);

                }

                //When EURO is Selected
                if(cbCurrency.getSelectedItem().equals("Euro"))
                {
                    double euro = 164.33;
                    double amount = Double.parseDouble(tfInput.getText());
                    Result =   euro * amount;

                    BigDecimal bd = new BigDecimal(Result).setScale(2, RoundingMode.HALF_UP);
                    double result2 = bd.doubleValue();
                    //df.format(Result);
                    String str = Double.toString(result2);
                    forTF.setText("$"+str);

                }

                //Test if the currency field is empty
                if(tfInput.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,
                            "The input amount cannot be empty",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }
                //Test if the type of currency is not selected
                if(cbCurrency.getSelectedItem().equals("--Select--"))
                {
                    JOptionPane.showMessageDialog(null,
                            "Please select a currency to convert",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }



            }
        });

        //When the Clear Button is Pressed
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forTF.setText(null);
                tfInput.setText(null);
                cbCurrency.setSelectedItem("--Select--");

            }
        });
    }
}
