package two;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
public class ClockThread extends JPanel implements Runnable {
    /**
     * 定义包裹住圆的最小矩形的左上角的x、y坐标
     */
    private final int x = 140;
    private final int y = 140;
    /**
     * 定义圆的半径
     */
    private final int r = 100;
    Calendar c = Calendar.getInstance();
    double hour = c.get(Calendar.HOUR_OF_DAY);
    double min = c.get(Calendar.MINUTE);
    double sec = c.get(Calendar.SECOND);

    @SuppressWarnings("all")
    public void run() {
        while(true){
            Calendar calendar = Calendar.getInstance();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            min = calendar.get(Calendar.MINUTE);
            sec = calendar.get(Calendar.SECOND);
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
            // 重绘组件，调用paintComponent方法
            repaint();

        }

    }


    public void paintComponent(Graphics g) {
//        this.removeAll();
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // 画圆，圆心(x + r, y + r), 半径r
        // drawOval方法的四个参数分别是圆的外切矩形的左上角的x、y坐标和外切矩形的宽度和高度
        g2.drawOval(x, y, 200, 200);
        // 画刻度
        for (int i = 0; i < 12; i++) {
            // 假设在一个二维坐标中，角度为y轴与指针的夹角，那么x = r * sin(角度)，y = r * cos(角度)
            // 一个刻度的角度 5min
            double angle = 2 * Math.PI * 1 / 12;
            double realAngle = angle * i;
            double labelX = r * Math.sin(realAngle);
            double labelY = r * Math.cos(realAngle);
            // 圆心坐标
            int circleY = y + r;
            int circleX = x + r;
            // 刻度的坐标kx= cx + labelX, ky = cy - labelY(因为坐标系的y轴是向下的)
            // 画一个半径为2.5的圆点作为刻度，圆心应为(cx + labelX, cy - labelY)，考虑到drawOval x,y的坐标是最小矩形的左上角的坐标
            // 所以应该是(cx + labelX - 2.5, cy - labelY - 2.5)
            g2.drawOval((int) (circleX + labelX - 2.5), (int) (circleY - labelY - 2.5), 5, 5);
            g2.fillOval((int) (circleX + labelX - 2.5), (int) (circleY - labelY - 2.5), 5, 5);
            // 写上数字
            g2.drawString(i+1 + "", (int) (x + r + (r + 10) * Math.sin(Math.PI * (i+1) / 6)-5), (int) (y + r - (r + 10) * Math.cos(Math.PI * (i+1) / 6)+3.5));
        }
        // 画圆心
        g2.drawOval(x + r - 5, y + r - 5, 10, 10);
        g2.fillOval(x + r - 5, y + r - 5, 10, 10);
        // 画时针
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
