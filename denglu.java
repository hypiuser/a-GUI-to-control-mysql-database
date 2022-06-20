package com.shujuku_liu; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class AJ extends JFrame{
    AJ(){
        setTitle("高校信息发布系统");
        setSize(400,150);
        setVisible(true);
    }
}
class BJ extends AJ{
    JTextField t1;
    JPasswordField pass;
    BJ(){
        t1 = new JTextField(12);
        pass = new JPasswordField(12);
        JLabel l1 = new JLabel("账号："); JLabel l2 = new JLabel("密码：");
        setLayout(new GridLayout(2,1));
        JPanel p1 = new JPanel();JPanel p2 = new JPanel();
        p1.add(l1); p2.add(l2);
        p1.add(t1); p2.add(pass);
        add(p1); add(p2);
    }
}
class choose extends AJ implements ActionListener{
    JButton a,b;
    choose(){
        setLayout(new GridLayout(2,1));
        JButton a=new JButton("我是老师");
        JButton b=new JButton("我是学生");
        a.addActionListener(this);
        b.addActionListener(this);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.add(a); p2.add(b);
        add(p1);add(p2);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="我是老师"){
            new user_t().setVisible(true);
        }
        else if(e.getActionCommand()=="我是学生"){
            new user_s().setVisible(true);
        }
    }
}

class user_t extends BJ implements ActionListener{
    JButton b1;
    user_t(){
        setLayout(new GridLayout(3,1));
        JPanel p3 = new JPanel();
        b1 = new JButton("老师登录");
        b1.addActionListener(this);
        p3.add(b1);add(p3);
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b1){
            String name = this.t1.getText();
            String passw = new String(pass.getPassword());
            boolean t = false;
            try {
                sql_do x = new sql_do();
                x.OpenConn();
                t = x.login_t(name,passw);
            } catch (Exception e1){
                e1.printStackTrace();
            }
            if(t == true)
            {
                System.out.println("登陆成功！");
                new Running_t().setVisible(true);
            }
            else {
                System.out.println("登陆失败！");
                new AJ().setTitle("登录失败！！！");
            }
        }
    }
}
class user_s extends BJ implements ActionListener{
    JButton b1;
    public static String name;

    user_s(){
        setLayout(new GridLayout(3,1));
        JPanel p3 = new JPanel();
        b1 = new JButton("学生登录");
        b1.addActionListener(this);
        p3.add(b1);add(p3);
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b1){
            name = this.t1.getText();
            String passw = new String(pass.getPassword());
            boolean t = false;
            try {
                sql_do x = new sql_do();
                x.OpenConn();
                t = x.login(name,passw);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            if(t == true)
            {
                System.out.println("登陆成功！");
                new Running_s().setVisible(true);
            }
            else {
                System.out.println("登陆失败！");
                new AJ().setTitle("登录失败！！！");
            }
        }
    }
}
class Running_s extends AJ implements ActionListener{
    JMenuBar mainMenu = new JMenuBar();
    JMenu menuSystem = new JMenu("系统管理");
    JMenuItem itemExit = new JMenuItem("退出");
    JMenu menuStu = new JMenu("学生管理");
    JMenuItem itemSearch = new JMenuItem("个人成绩查询");
    JMenuItem itemSearch1 = new JMenuItem("课程查询");
    Running_s(){
        itemSearch.addActionListener(this);
        itemExit.addActionListener(this);
        itemSearch1.addActionListener(this);
        this.pack();
        setTitle("学生管理信息系统主界面"); setSize(400,300);setLocationRelativeTo(null);
        menuSystem.setFont(new Font("Dialog",0,12));
        menuSystem.add(itemExit);menuStu.add(itemSearch);menuStu.add(itemSearch1);
        mainMenu.add(menuSystem); mainMenu.add(menuStu);
        this.setJMenuBar(mainMenu);
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == itemSearch) {
            new chaxun().setVisible(true);
        }
        else if(obj == itemExit) {
            this.dispose();
        }
        else if(obj == itemSearch1){
            new chaxun_k().setVisible(true);
        }
    }
}
class Running_t extends AJ implements ActionListener{
    JMenuBar mainMenu = new JMenuBar();
    JMenu menuSystem = new JMenu("系统管理");
    JMenuItem itemExit = new JMenuItem("退出");
    JMenu menuStu = new JMenu("学生管理");
    JMenuItem itemAdds1 = new JMenuItem("增加学生信息");
    JMenuItem itemAdds2 = new JMenuItem("学生成绩录入");
    JMenuItem itemSearch1 = new JMenuItem("学生信息查询");
    JMenuItem itemSearch2 = new JMenuItem("课程查询");
    JMenuItem itemSearch3 = new JMenuItem("学生成绩查询");
    Running_t(){
        itemAdds1.addActionListener(this);itemSearch1.addActionListener(this);
        itemSearch2.addActionListener(this);itemSearch3.addActionListener(this);
        itemExit.addActionListener(this);itemAdds2.addActionListener(this);
        this.pack();
        setTitle("学生管理信息系统主界面"); setSize(400,300);setLocationRelativeTo(null);
        menuSystem.setFont(new Font("Dialog",0,12));
        menuSystem.add(itemExit);menuStu.add(itemAdds1);menuStu.add(itemSearch1);menuStu.add(itemSearch2);
        menuStu.add(itemSearch3);menuStu.add(itemAdds2);
        mainMenu.add(menuSystem); mainMenu.add(menuStu);
        this.setJMenuBar(mainMenu);
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == itemAdds1){
            new zengjia().setVisible(true);
        }
        else if(obj ==itemAdds2){
            new cjluru().setVisible(true);
        }
        else if(obj == itemSearch1) {
            new chaxun_s().setVisible(true);
        }
        else if(obj == itemSearch2) {
            new chaxun_k().setVisible(true);
        }
        else if(obj == itemSearch3) {
            new chaxun_score().setVisible(true);
        }
        else if(obj == itemExit) {
            this.dispose();
        }
    }
}
public class denglu{
    public static void main(String[] args){
        choose x = new choose();
        x.setVisible(true);
        x.setResizable(false);
        x.setLocationRelativeTo(null);
    }
}
