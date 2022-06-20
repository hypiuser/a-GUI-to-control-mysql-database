package com.shujuku_liu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class chaxun extends AJ implements ActionListener{
    JButton b3;
    JTextField t0,t1,t2;
    chaxun(){
        setSize(600,300);
        setTitle("查看个人成绩");
        JLabel A=new JLabel("请输入课程号");
        setLocationRelativeTo(null);
        t0 = new JTextField(10);
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        JLabel l1 = new JLabel("课程号：");
        JLabel l2=new JLabel("成绩：");
        setLayout(new GridLayout(5,2));
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p0.add(A);p1.add(l1);p2.add(l2);
        p1.add(t1);p2.add(t2);
        add(p0);add(p1);add(p2);
        JPanel p10 = new JPanel();
        b3 = new JButton("查找");
        b3.addActionListener(this);
        p10.add(b3); add(p10);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b3) {
            String num = this.t1.getText();
            sql_do x = new sql_do();
            try {
                x.OpenConn();
                String sql = "select * from gaoxiao.成绩 where 课程号="+"\""+num+"\""+" and 学号="+user_s.name;
                x.rs = x.executeQuery(sql);
                while(x.rs.next()) {
                    t1.setText(x.rs.getString("课程号"));
                    t2.setText(x.rs.getString("成绩"));
                }
            }catch(Exception e1) {
                System.err.println(e1.getMessage());
            }
            x.closeStmt();
            x.closeConn();
        }
    }
    public static void main(String []args) {
        new chaxun().setVisible(true);
    }
}