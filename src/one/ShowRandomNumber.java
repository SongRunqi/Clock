package one;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShowRandomNumber extends JFrame implements ActionListener {
    JLabel label1 = new JLabel("准备");
    JLabel label2 = new JLabel("开始中");
    JTextField jt1 = new JTextField(10);
    JTextField jt2 = new JTextField(10);
    Thread start1,start2;
    public ShowRandomNumber(ShowThread t1,ShowThread t2,JLabel label1,JLabel label2,JTextField jt1,JTextField jt2){
        super();
        System.out.println(1/2);
        this.jt1 = jt1;
        this.jt2 = jt2;
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        JPanel p[]={new JPanel(),new JPanel()};
        this.label1 = label1;
        this.label2 = label2;
        label1.setBackground(Color.PINK);
        label2.setBackground(Color.PINK);
        label1.setOpaque(true);
        label2.setOpaque(true);
        JButton b[] = {new JButton("开始"),new JButton("取消")};
        start1=new Thread(t1);
        start2=new Thread(t2);
        for(JPanel temp:p ){
            temp.setLayout(new FlowLayout());
        }
        //设置布局管理器
        //添加组件
        p[0].add(label1);
        p[0].add(label2);
        p[0].add(b[0]);
        p[0].add(b[1]);
        p[1].add(jt1);
        p[1].add(jt2);
        c.add("South",p[0]);
        c.add("Center",p[1]);
        //添加监听器
        b[0].addActionListener(this);
        b[1].addActionListener(this);
        this.setSize(140,100);
        this.setVisible(true);
    }
    public static void main(String[] args){
        JLabel label1 = new JLabel("准备");
        JLabel label2 = new JLabel("开始中");
        JTextField jt1 = new JTextField(10);
        JTextField jt2 = new JTextField(10);
        ShowThread t1 = new ShowThread(label1,jt1);
        ShowThread t2 = new ShowThread(label2,jt2);
        ShowRandomNumber t = new ShowRandomNumber(t1,t2,label1,label2,jt1,jt2);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("开始")){
            start1 = new Thread(new ShowThread(label1,jt1));
            start2 = new Thread(new ShowThread(label2,jt2));
            start1.start();
            start2.start();
            setVisible(false);
            setVisible(true);
        }
        else if(e.getActionCommand().equals("取消")){
            start1.interrupt();
            start2.interrupt();
        }
    }

}
