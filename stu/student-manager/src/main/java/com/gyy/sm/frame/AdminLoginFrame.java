package com.gyy.sm.frame;

import com.gyy.sm.factory.ServiceFactory;
import com.gyy.sm.utils.ResultEntity;

import javax.swing.*;

/**
 * @ClassName AdminLoginFrame
 * @Description TODO
 * @Author GYY
 * @Date 2020/11/21
 **/
public class AdminLoginFrame extends JFrame{
    private JPanel mainPanel;
    private JButton loginBtn;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton resetBun;
    private JLabel 账号;
    private JLabel 密码;

    public AdminLoginFrame(){
        this.setTitle("AdminLoginFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        loginBtn.addActionListener(e -> {
            String account = accountField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
            JOptionPane.showMessageDialog(mainPanel, resultEntity.getMessage());
            if (resultEntity.getCode() == 0){
                this.dispose();
                new MainFrame();
            } else {
                accountField.setText("");
                passwordField.setText("");
            }
        });

        resetBun.addActionListener(e -> {
            accountField.setText("");
            passwordField.setText("");
        });

    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}