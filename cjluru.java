package com.shujuku_liu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class cjluru extends AJ implements ActionListener{
    JButton b3;
    JTextField t1,t2,t3;
    cjluru(){
        setSize(600,300);
        setTitle("成绩录入系统");
        setLocationRelativeTo(null);
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        JLabel l1 = new JLabel("学号：");
        JLabel l2 = new JLabel("课程号：");
        JLabel l3 = new JLabel("成绩：");
        setLayout(new GridLayout(5,2));
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        JPanel p7 = new JPanel();
        p1.add(l1);p2.add(l2);p3.add(l3);
        p1.add(t1);p2.add(t2);p3.add(t3);
        add(p1);add(p2);add(p3);
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
            String 课程号 = this.t2.getText();
            String 成绩 = this.t3.getText();
            sql_do x = new sql_do();
            try {
                x.OpenConn();
                String sql = "select * from 成绩 where 学号="+学号+" and 课程号="+"\""+课程号+"\"";
                x.rs = x.executeQuery(sql);
                if(x.rs.next()) new AJ().setTitle("添加失败！！！");
                else new AJ().setTitle("添加成功！！！");
                sql = "insert into 成绩(学号,课程号,成绩) values("+学号+",'"+课程号+"','"+成绩+"')";
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
        new cjluru().setVisible(true);
    }
}