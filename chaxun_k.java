package com.shujuku_liu;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class chaxun_k extends AJ implements ActionListener{
    JButton b3;
    JTextField t0,t1,t2,t3,t4,t5,t6;
    chaxun_k(){
        setSize(600,300);
        setTitle("查看课程信息");
        JLabel A=new JLabel("请使用课程号查询");
        setLocationRelativeTo(null);
        t0 = new JTextField(10);
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        JLabel l1 = new JLabel("课程号：");
        JLabel l2 = new JLabel("课程名：");
        JLabel l3 = new JLabel("教师名：");
        JLabel l4 = new JLabel("学时：");
        JLabel l5 = new JLabel("是否必修：");
        JLabel l6 = new JLabel("学分：");
        setLayout(new GridLayout(5,2));
        JPanel p0 = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        p0.add(A);p1.add(l1);p2.add(l2);p3.add(l3);p4.add(l4);p5.add(l5);p6.add(l6);
        p1.add(t1);p2.add(t2);p3.add(t3);p4.add(t4);p5.add(t5);p6.add(t6);
        add(p0);add(p1);add(p2);add(p3);add(p4);add(p5);add(p6);
        JPanel p10 = new JPanel();
        b3 = new JButton("查找");
        b3.addActionListener(this);
        p10.add(b3); add(p10);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == b3) {
            String num = t1.getText();
            sql_do y = new sql_do();
            try {
                y.OpenConn();
                String sql = "select * from gaoxiao.课程 where 课程号="+"\""+num+"\"";
                y.rs = y.executeQuery(sql);
                while(y.rs.next()) {
                    t1.setText(y.rs.getString("课程号"));
                    t2.setText(y.rs.getString("课程名"));
                    t3.setText(y.rs.getString("教师名"));
                    t4.setText(y.rs.getString("学时"));
                    if(y.rs.getInt("是否必修")==0)
                    t5.setText("是");
                    t6.setText(y.rs.getString("学分"));
                }
            }catch(Exception e1) {
                System.err.println(e1.getMessage());
            }
            y.closeStmt();
            y.closeConn();
        }
    }
    public static void main(String []args) {
        new chaxun_k().setVisible(true);
    }
}