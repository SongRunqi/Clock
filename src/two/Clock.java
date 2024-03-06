package two;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.Date;
import java.util.concurrent.Flow;

public class Clock extends JFrame {
    //内部类绘画圆
    private int hour =0;
    private int min=0;
    private int sec=0;
    private int x=140,y=140;//圆♥
    private int r = 100;

    public Clock(){
        super("时钟程序");
//        JPanel p1 = new ClockThread();
        JPanel p1 = new ClockThread();
        this.add(p1);
        Thread t = new Thread((ClockThread)p1);
        t.start();
    }
    //花点


    public static void main(String[] args){
        Clock c = new Clock();
        c.setSize(500,500);
        c.setVisible(true);
        c.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}

