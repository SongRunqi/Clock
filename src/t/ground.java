package t;
import java.awt.*;
import javax.swing.*;
public class ground extends JFrame {
    public ground(){
        super();
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        JLabel l1 = new JLabel("进度：");
        JLabel l2 = new JLabel("进度");
        JProgressBar j1 = new JProgressBar(0,100);
        JProgressBar j2 = new JProgressBar(0,100);
        Thread t1 = new Thread(new house(j1,l1,10));
        Thread t2 = new Thread(new house(j2,l2,1));
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
        this.getContentPane().add(l1);
        this.getContentPane().add(j1);
        this.getContentPane().add(l2);
        this.getContentPane().add(j2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200,300,400,200);
        this.setVisible(true);
    }
    public static void main(String[] args){
        ground g = new ground();

    }
}
