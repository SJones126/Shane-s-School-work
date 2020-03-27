
package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab4 extends JFrame{//public class extends to the JFrame
public Lab4(){//public class to refer back to
super("Lab 4");
ScreenSaver saver=new ScreenSaver();//screensaver constructor
setLayout(new BorderLayout());
add(saver, BorderLayout.CENTER);//layout of what is showed
}
class ScreenSaver extends JPanel implements ActionListener, MouseWheelListener {
    private int x[] = new int[60];//the max x interval
    private int y[] = new int[60];//max y interval
    private int numOfPoints = 0;//the number of points gor the screensaver
    private int radius = 10;//the back times it does a circle
    private int delay = 1000;//the number of seconds that it delays
    private Timer timer = null; // javax.swing.timer
    public ScreenSaver() {//constructor for the screensaver
        timer = new Timer(1000, this); // the interval is 1000 milliseconds
        timer.start();
    } 
    public void actionPerformed(ActionEvent e){ 
		/*insert your code here */
                addAPoint();//calls the addapoint constructor
                addMouseWheelListener(this);//adds the this to the constructor
		repaint();//prints the figure
    }
    public void addAPoint(){//defines the constructor
        int centerX = (int) (getSize().getWidth()/2);
        int centerY = (int) (getSize().getWidth()/2);
        double X = centerX + Math.cos(numOfPoints*Math.PI/3)*radius;
        double Y = centerY + Math.sin(numOfPoints*Math.PI/3)*radius;
        this.x[numOfPoints] = (int)X;//makes the points for x
        this.y[numOfPoints] = (int)Y;//makes the point for y
        numOfPoints++;//increase the number of points
        radius +=3;//increases radius by 3
        if(numOfPoints == 60){//Checks to make sure the points don't go over 60
            numOfPoints = 0;
            radius = 10;
        }
    }
    public void paintComponent(Graphics g){   
        g.clearRect(0,0,(int)getSize().getWidth(),(int)getSize().getHeight()); 
        g.drawPolyline(x, y, numOfPoints);
	//draws the polyline
    }
    public void mouseWheelMoved(MouseWheelEvent e){
        //this part of the program determines the mouse wheel turn then
        //changes the speed of the drawing
        int turns = e.getWheelRotation();
        if(turns > 0){
            if (delay < 2000){
                delay += turns;
            }
            this.timer.setDelay(delay);
        }
        else if (turns < 0){
            if (delay > -1){
                delay += turns;
            }
            this.timer.setDelay(delay);
        }
        System.out.println(turns);
        System.out.println(delay);
    } 
}

public static void main(String args[]){
    Lab4 lab4=new Lab4();
    lab4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
    lab4.setSize( 600, 600 ); // set frame size
    lab4.setResizable(true);
    lab4.setVisible( true ); // display frame
}
}
