import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
public class MyPanel extends JPanel implements MouseListener,
							MouseMotionListener {
	//value for the Arrays, Panels for the gui, adds the combobox checkbox
	//Buttons Lays them out appropriately 
    static ArrayList<String> itemsDrawn;
    static String shape, color;
    static JCheckBox fillBox;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java 2D Drawing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton cleared = new JButton("Clear");
        panel.add(cleared);
        JButton undoed = new JButton("Undo");
        panel.add(undoed);
        String[] Types = { "Oval", "Rectangle", "Edge" };
        JComboBox<String> shapeChooser = new JComboBox<>(Types);
        panel.add(shapeChooser);
        shape = "Oval";
        String[] colors = { "Red", "Green", "Blue", "Black" };
        JComboBox<String> colorChooser = new JComboBox<>(colors);
        panel.add(colorChooser);
        color = "Red";
        fillBox = new JCheckBox("Fill");
        panel.add(fillBox);
        frame.add(panel, BorderLayout.PAGE_START);
        MyPanel myPanel = new MyPanel();
        frame.add(myPanel, BorderLayout.CENTER);
        JPanel coord = new JPanel();
        coord.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(mousex+","+mousey,SwingConstants.LEFT);
        frame.add(label, BorderLayout.SOUTH);
        shapeChooser.addActionListener(new ActionListener() {
        	//Action listener for ComboBox of the type of shapes
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                shape = (String) cb.getSelectedItem();
            }
        });
        //action listener for the type of color that the user chooses
        colorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                color = (String) cb.getSelectedItem();
            }
        });
        //Action listener for the button of clear to be pressed
        cleared.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                itemsDrawn = new ArrayList<>();
                myPanel.repaint();
            }
        });
        //action listener for when the undo button is pressed
        undoed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                if (itemsDrawn.size() != 0) {
                    itemsDrawn.remove(itemsDrawn.size() - 1);
                    myPanel.repaint();
                }
            }
        });
        //sets the display to be visible to see.
        frame.setVisible(true);
    }
    /**
     * 
     */
    private static final long serialVersionUID = 5509155261502497671L;
    Point start, end;
    public MyPanel() {
        start = end = null;
        addMouseListener(this);
        addMouseMotionListener(this);
        itemsDrawn = new ArrayList<>();
    }
    @Override
    //paint for the the graphic to be used and printed correctly
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        int counter;
        String[] temp;
        //sets the color for the diagram.
        for (counter = 0; counter < itemsDrawn.size(); counter++) {
            temp = itemsDrawn.get(counter).split(" ");
            if (temp[1].equals("Red")) {
                g.setColor(Color.RED);
            } else if (temp[1].equals("Green")) {
                g.setColor(Color.GREEN);
            } else if (temp[1].equals("Blue")) {
                g.setColor(Color.BLUE);
            } else if (temp[1].equals("Black")) {
                g.setColor(Color.BLACK);
            }
            if (temp[0].equals("Rectangle")) {
            	//diagram for the rectangle
                if (Boolean.parseBoolean(temp[6])) {
                	//fills in the rectangle
                    g.fillRect(
                            Integer.parseInt(temp[2]) > Integer
                                    .parseInt(temp[4]) ? Integer
                                    .parseInt(temp[4]) : Integer
                                    .parseInt(temp[2]),
                            Integer.parseInt(temp[3]) > Integer
                                    .parseInt(temp[5]) ? Integer
                                    .parseInt(temp[5]) : Integer
                                    .parseInt(temp[3]), Math.abs(Integer
                                    .parseInt(temp[4])
                                    - Integer.parseInt(temp[2])), Math
                                    .abs(Integer.parseInt(temp[5])
                                            - Integer.parseInt(temp[3])));
                } else {
                	//draws a regular rectangle
                    g.drawRect(
                            Integer.parseInt(temp[2]) > Integer
                                    .parseInt(temp[4]) ? Integer
                                    .parseInt(temp[4]) : Integer
                                    .parseInt(temp[2]),
                            Integer.parseInt(temp[3]) > Integer
                                    .parseInt(temp[5]) ? Integer
                                    .parseInt(temp[5]) : Integer
                                    .parseInt(temp[3]), Math.abs(Integer
                                    .parseInt(temp[4])
                                    - Integer.parseInt(temp[2])), Math
                                    .abs(Integer.parseInt(temp[5])
                                            - Integer.parseInt(temp[3])));
                }
            } else if (temp[0].equals("Oval")) {
            	//this is for oval
                if (Boolean.parseBoolean(temp[6])) {
                    g.fillOval(
                    		//fills in the diagram for filled oval
                            Integer.parseInt(temp[2]) > Integer
                                    .parseInt(temp[4]) ? Integer
                                    .parseInt(temp[4]) : Integer
                                    .parseInt(temp[2]),
                            Integer.parseInt(temp[3]) > Integer
                                    .parseInt(temp[5]) ? Integer
                                    .parseInt(temp[5]) : Integer
                                    .parseInt(temp[3]), Math.abs(Integer
                                    .parseInt(temp[4])
                                    - Integer.parseInt(temp[2])), Math
                                    .abs(Integer.parseInt(temp[5])
                                            - Integer.parseInt(temp[3])));
                } else {
                    g.drawOval(
                    		//draws the oval into the diagram
                            Integer.parseInt(temp[2]) > Integer
                                    .parseInt(temp[4]) ? Integer
                                    .parseInt(temp[4]) : Integer
                                    .parseInt(temp[2]),
                            Integer.parseInt(temp[3]) > Integer
                                    .parseInt(temp[5]) ? Integer
                                    .parseInt(temp[5]) : Integer
                                    .parseInt(temp[3]), Math.abs(Integer
                                    .parseInt(temp[4])
                                    - Integer.parseInt(temp[2])), Math
                                    .abs(Integer.parseInt(temp[5])
                                            - Integer.parseInt(temp[3])));
                }
            } else if (temp[0].equals("Edge")) {
            	//this is for the Edge
                g.drawLine(Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3]), Integer.parseInt(temp[4]),
                        Integer.parseInt(temp[5]));
            }
        }
        //sets the color
        if (start != null && end != null) {
            if (color.equals("Red")) {
                g.setColor(Color.RED);
            } else if (color.equals("Green")) {
                g.setColor(Color.GREEN);
            } else if (color.equals("Blue")) {
                g.setColor(Color.BLUE);
            } else if (color.equals("Black")) {
                g.setColor(Color.BLACK);
            }
            //gets all of the right variables for the box
            if (shape.equals("Oval")) {
                if (fillBox.isSelected()) {
                    g.fillOval(start.x > end.x ? end.x : start.x,
                            start.y > end.y ? end.y : start.y,
                            Math.abs(end.x - start.x),
                            Math.abs(end.y - start.y));
                } else {
                	//gets the locations of the oval
                    g.drawOval(start.x > end.x ? end.x : start.x,
                            start.y > end.y ? end.y : start.y,
                            Math.abs(end.x - start.x),
                            Math.abs(end.y - start.y));
                }
                //gets the drawing location of the rectangle
            } else if (shape.equals("Rectangle")) {
                if (fillBox.isSelected()) {
                    g.fillRect(start.x > end.x ? end.x : start.x,
                            start.y > end.y ? end.y : start.y,
                            Math.abs(end.x - start.x),
                            Math.abs(end.y - start.y));
                } else {
                    g.drawRect(start.x > end.x ? end.x : start.x,
                            start.y > end.y ? end.y : start.y,
                            Math.abs(end.x - start.x),
                            Math.abs(end.y - start.y));
                }
            } else if (shape.equals("Edge")) {
                g.drawLine(start.x, start.y, end.x, end.y);
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        end = arg0.getPoint();
        repaint();
        //when the mouse is dragged it is repainted
    }
    @Override
    public void mouseMoved(MouseEvent arg0) {
    	//gets the event for when the mouse is moved
    	int mouseY = MouseInfo.getPointerInfo().getLocation().y;
    	int mouseX = MouseInfo.getPointerInfo().getLocation().x;
    }
    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
        start = arg0.getPoint();
    }
    @Override
    public void mouseReleased(MouseEvent arg0) {
    	//the new location of when the mouse is released after being clicked
        // TODO Auto-generated method stub
        if (start != null && end != null) {
            itemsDrawn.add(shape + " " + color + " " + start.x + " " + start.y
                    + " " + end.x + " " + end.y + " " + fillBox.isSelected());
        }
        start = null;
        end = null;
    }
    static double mousex = MouseInfo.getPointerInfo().getLocation().getX();
    static double mousey = MouseInfo.getPointerInfo().getLocation().getY();
    
}