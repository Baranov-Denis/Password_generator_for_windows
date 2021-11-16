package Viewer;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Viewer extends JFrame implements KeyListener {

    private final Controller controller;
    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    private String passwordText = "Here will be your password";

    private JTextField resourceTextField;
    private JTextField keyWordField;
    private JLabel passwordArea;

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

    public Viewer(Controller controller) {
        this.controller = controller;



        setFrameLocation();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(346, 265);
        frame.setTitle("Password generator");

        frame.setAlwaysOnTop(false);
        frame.setResizable(false);
        //size of frame won't be changed
        frame.add(panel);

        panel.setPreferredSize(new Dimension(340, 415));
        panel.setBackground(MyColors.BACKGROUND);
    }


    public void runMainPage() {

        panel.removeAll();


        JLabel resourceNameText = new JLabel("Enter resource name: ",SwingConstants.LEFT);
        resourceNameText.setForeground(MyColors.FONT);
        resourceNameText.setFont(MyFonts.myFont);
        resourceNameText.setPreferredSize(new Dimension(315,18));

        resourceTextField = new JTextField();
        resourceTextField.setFont(MyFonts.myFont);
        resourceTextField.setPreferredSize(new Dimension(315,30));
        resourceTextField.setBackground(MyColors.BACKGROUND);
        resourceTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));


        JLabel keyWordText = new JLabel("Enter resource name: ",SwingConstants.LEFT);
        keyWordText.setForeground(MyColors.FONT);
        keyWordText.setFont(MyFonts.myFont);
        keyWordText.setPreferredSize(new Dimension(315,18));

        keyWordField = new JTextField();
        keyWordField.setFont(MyFonts.myFont);
        keyWordField.setPreferredSize(new Dimension(315,30));
        keyWordField.setBackground(MyColors.BACKGROUND);
        keyWordField.setBorder(new BevelBorder(BevelBorder.LOWERED));




        passwordArea = new JLabel("",SwingConstants.CENTER);
        passwordArea.setFont(MyFonts.myBigFont);
        passwordArea.setText(passwordText);
        passwordArea.setPreferredSize(new Dimension(320, 51));





        MyButton startGenerateButton = new MyButton("Generate!!!");
        startGenerateButton.addActionListener(e -> buttonAction());






        frame.setFocusable(true);
        frame.addKeyListener(this);

        panel.setFocusable(false);

        startGenerateButton.setFocusable(false);


        panel.add(resourceNameText);
        panel.add(resourceTextField);

        panel.add(keyWordText);
        panel.add(keyWordField);

        panel.add(passwordArea);



        panel.add(startGenerateButton);

        SwingUtilities.updateComponentTreeUI(frame);
    }

    private void buttonAction(){
        String resourceString = resourceTextField.getText();
        String keyText = keyWordField.getText();
        if(!resourceString.equals("")&&!keyText.equals(""))
        controller.runGenerate(resourceString, keyText);

        StringSelection selection = new StringSelection(passwordArea.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }





    private void setFrameLocation() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        frame.setLocation((screenWidth - 360), (screenHeight - 450));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
