package one;

import javax.swing.*;
import java.util.Random;

public class ShowThread implements Runnable{
    JLabel label;
    JTextField jt = new JTextField(10);
    public void run(){
        Random r = new Random();

        
        while(true){
            int t = r.nextInt(100);
            if(t<10){
                t = r.nextInt(100);
            }
            jt.setText(t+"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                label.setText(t+"");
                break;
            }
        }
    }
    public ShowThread(JLabel label,JTextField jt){
        this.label = label;
        this.jt = jt;
    }

}
