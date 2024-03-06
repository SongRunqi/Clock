package two;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
public class ClockThread extends JPanel implements Runnable {
    private int x = 140, y = 140;//圆♥
    private int r = 100;
    Calendar c = Calendar.getInstance();
    double hour = c.get(c.HOUR_OF_DAY);
    double min = c.get(c.MINUTE);
    double sec = c.get(c.SECOND);

    JPanel p;

    public void run() {

        while(true){
            Calendar calendar = Calendar.getInstance();
            hour = calendar.get(calendar.HOUR_OF_DAY);;
            min = calendar.get(calendar.MINUTE);
            sec = calendar.get(calendar.SECOND);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            repaint();

        }

    }


    public void paintComponent(Graphics g) {
//        this.removeAll();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawOval(x, y, 200, 200);
        for (int i = 0; i < 12; i++) {
            g2.drawOval((int) (x + r + r * Math.sin(Math.PI * (i+1) / 6)-2.5 ), (int) (y + r - r * Math.cos(Math.PI * (i+1) / 6)-2.5 ), 5, 5);
            g2.fillOval((int) (x + r + r * Math.sin(Math.PI * (i+1) / 6)-2.5 ), (int) (y + r - r * Math.cos(Math.PI * (i+1) / 6)-2.5 ), 5, 5);
            g2.drawString(i+1 + "", (int) (x + r + (r + 10) * Math.sin(Math.PI * (i+1) / 6)-5), (int) (y + r - (r + 10) * Math.cos(Math.PI * (i+1) / 6)+3.5));
        }
        g2.drawOval(x + r - 5, y + r - 5, 10, 10);
        g2.fillOval(x + r - 5, y + r - 5, 10, 10);
        paintHour(hour*3600+min*60+sec,g2);
        paintMin(min*60+sec,g2);
        paintSec(sec,g2);


    }
    public void paintHour(double sec,Graphics2D g){
        double a,b;
        double angle = sec*Math.PI/21600;
        a = x+r+(r-40)*Math.sin(angle);
        b = y+r-(r-40)*Math.cos(angle);
        g.drawLine(x+r,y+r,(int)a,(int)b);
    }
    public void paintMin(double sec,Graphics2D g){
        double a,b;
        double angle = sec*Math.PI/1800;
        a = x+r+(r-20)*Math.sin(angle);
        b = y+r-(r-20)*Math.cos(angle);
        g.drawLine(x+r,y+r,(int)a,(int)b);
    }
    public void paintSec(double sec,Graphics2D g){
        double a,b;
        double angle = sec*Math.PI/30;
        a = x+r+r*Math.sin(angle);
        b = y+r-r*Math.cos(angle);
        g.drawLine(x+r,y+r,(int)a,(int)b);
    }
}
