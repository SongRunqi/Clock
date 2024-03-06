package t;
import javax.swing.*;
public class house implements Runnable{
    private JProgressBar jp;
    private JLabel l;
    int limt = 0;
    int num;
    public house(JProgressBar jp,JLabel l,int num){
        this.jp = jp;
        this.l = l;
        this.num = num;
    }
    public void run(){
        while(limt++<100){
            jp.setValue(limt);
            l.setText("进度："+limt+"%");
            try{
                if(num ==10 )
                    Thread.sleep(100);
                else
                    Thread.sleep(300);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
