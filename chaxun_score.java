package com.shujuku_liu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class chaxun_score extends AJ implements ActionListener{
    JButton b3;
    JTextField t1,t2,t3;
    chaxun_score(){
        setSize(600,300);
        setTitle("查看成绩信息");
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
        p1.add(l1);p2.add(l2);p3.add(l3);
        p1.add(t1);p2.add(t2);p3.add(t3);
        add(p1);add(p2);add(p3);
        b3 = new JButton("查找");
        b3.addActionListener(this);
        p4.add(b3); add(p4);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b3) {
            String num = this.t1.getText();
            String num2= this.t2.getText();
            sql_do x = new sql_do();
            try {
                x.OpenConn();
                String sql = "select * from gaoxiao.成绩 where 学号="+num+" and "+"课程号="+"\""+num2+"\"";
                x.rs = x.executeQuery(sql);
                while(x.rs.next()) {
                    t1.setText(x.rs.getString("学号"));
                    t2.setText(x.rs.getString("课程号"));
                    t3.setText(x.rs.getString("成绩"));
                }
            }catch(Exception e1) {
                System.err.println(e1.getMessage());
            }
            x.closeStmt();
            x.closeConn();
        }
    }
    public static void main(String []args) {
        new chaxun_score().setVisible(true);
    }
}
