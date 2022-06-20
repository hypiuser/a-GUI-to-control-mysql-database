package com.shujuku_liu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class zengjia extends AJ implements ActionListener{
    JButton b3;JTextField t1,t2,t3,t4,t5,t6,t7;
    zengjia(){
        setSize(600,300);
        setTitle("新增学生信息");
        setLocationRelativeTo(null);
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7 = new JTextField(10);
        JLabel l1 = new JLabel("学号：");
        JLabel l2 = new JLabel("姓名：");
        JLabel l3 = new JLabel("性别：");
        JLabel l4 = new JLabel("生源地：");
        JLabel l5 = new JLabel("已修学分总和：");
        JLabel l6 = new JLabel("是否少数民族：");
        JLabel l7 = new JLabel("班级号：");
        setLayout(new GridLayout(5,2));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        p1.add(l1);p2.add(l2);p3.add(l3);p4.add(l4);p5.add(l5);p6.add(l6);p7.add(l7);
        p1.add(t1);p2.add(t2);p3.add(t3);p4.add(t4);p5.add(t5);p6.add(t6);p7.add(t7);
        add(p1);add(p2);add(p3);add(p4);add(p5);add(p6);add(p7);
        JPanel p10 = new JPanel();
        b3 = new JButton("增加");
        b3.addActionListener(this);
        p10.add(b3); add(p10);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b3) {
            String 学号 = this.t1.getText();
            String 姓名 = this.t2.getText();
            String 性别 = this.t3.getText();
            String 生源地 = this.t4.getText();
            String 已修学分总和 = this.t5.getText();
            String 是否少数民族 = this.t6.getText();
            String 班级号 = this.t7.getText();
            sql_do x = new sql_do();
            try {
                x.OpenConn();
                String sql = "select * from 学生 where 学号="+学号;
                x.rs = x.executeQuery(sql);
                if(x.rs.next()) new AJ().setTitle("添加失败！！！");
                else new AJ().setTitle("添加成功！！！");
                sql = "insert into 学生(学号,姓名,性别,生源地,已修学分总和,是否少数民族,班级号) values("+学号+",'"+姓名+"','"+性别+"','"+生源地+"','"+已修学分总和+"','"+是否少数民族+"','"+班级号+"')";
                System.out.println(sql);
                x.execute(sql);
            }catch(Exception e1) {
                System.err.println(e1.getMessage());
            }
            x.closeStmt();
            x.closeConn();
        }
    }
    public static void main(String []args) {
        new zengjia().setVisible(true);
    }
}
