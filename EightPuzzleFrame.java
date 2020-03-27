import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class JEightPuzzleFrame extends JFrame implements ActionListener{
	
	private int wide;
    private int Long;     
    private int p[][];
    private int c[] = {1,2,3,4,5,6,7,8,9};  // keep track of where the pieces are 
    private Image image1;
    private JPanel Panel;
    private JButton[][] Btn = new JButton[3][3];
    private String Source;
    private String place;
    private int SC;
    
    public JEightPuzzleFrame(String Title, String Source){
    	
    	this.Source = Source;
        this.place = Title;
        
        SC = 0;
        if (SC == 0){
            SC++;
            set();

        }else{
            shuffle();
        }
    }
    private Image getIcon(int a, int m){
         // Read the image from folder
        BufferedImage image=null;
        try{
            image = ImageIO.read(new File(Source));
        }catch(IOException e){
            System.err.println("Image not found");
            System.exit(1);
        }       
        // get the height and width of the image for the window size
         wide = image.getWidth();
         Long = image.getHeight(); 
         Image source = (Image) image;
         image1 = createImage(new FilteredImageSource(source.getSource(),
                 new CropImageFilter(m*wide/3, a*Long/3, 
                     (wide/3)+1, Long/3)));
         return image1;
    }
    private void set(){
        p = new int[][] {
                {0, 1, 2}, 
                {3, 4, 5}, 
                {6, 7, 8}};

         Panel = new JPanel();
         Panel.setLayout(new GridLayout(3, 3, 0, 0)); // 3x3 grid
         add(Panel, BorderLayout.CENTER);

        // Reads the image from the location
        BufferedImage image=null;
        try{
            image = ImageIO.read(new File(Source));
        }catch(IOException e){
            System.err.println("Image not found");
            System.exit(1);
        }       
        //get the size of the image and the size of the image to put on buttons.
        //after that it adds all of the buttons and makes sure that they are going in the appropriate way.
         wide = image.getWidth();
         Long = image.getHeight(); 
         Btn[0][0] = new JButton();
         Panel.add(Btn[0][0]);
         c [0] = 9;
         // Button 2
         Btn[0][1] = new JButton();
         Btn[0][1].addActionListener(this);
         Panel.add(Btn[0][1]);
         Btn[0][1].setIcon(new ImageIcon(getIcon(0,0)));
         Btn[0][1].setVisible(true);
         c[1] = 1;
         //Button 3
         Btn[0][2] = new JButton();
         Btn[0][2].addActionListener(this);
         Panel.add(Btn[0][2]);
         Btn[0][2].setIcon(new ImageIcon(getIcon(0,1)));
         Btn[0][2].setVisible(true);
         c[2] = 2;
       //Button 4
         Btn[1][0] = new JButton();
         Btn[1][0].addActionListener(this);
         Panel.add(Btn[1][0]);
         Btn[1][0].setIcon(new ImageIcon(getIcon(1,1)));
         Btn[1][0].setVisible(true);
         c[3] = 5;
       //Button 5
         Btn[1][1] = new JButton();
         Btn[1][1].addActionListener(this);
         Panel.add(Btn[1][1]);
         Btn[1][1].setIcon(new ImageIcon(getIcon(1,2)));
         Btn[1][1].setVisible(true);
         c[4] = 6;
       //Button 6
         Btn[1][2] = new JButton();
         Btn[1][2].addActionListener(this);
         Panel.add(Btn[1][2]);
         Btn[1][2].setIcon(new ImageIcon(getIcon(0,2)));
         Btn[1][2].setVisible(true);
         c[5] = 3;
       //Button 7
         Btn[2][0] = new JButton();
         Btn[2][0].addActionListener(this);
         Panel.add(Btn[2][0]);
         Btn[2][0].setIcon(new ImageIcon(getIcon(1,0)));
         Btn[2][0].setVisible(true);
         c[6] = 4;
       //Button 8
         Btn[2][1] = new JButton();
         Btn[2][1].addActionListener(this);
         Panel.add(Btn[2][1]);
         Btn[2][1].setIcon(new ImageIcon(getIcon(2,0)));
         Btn[2][1].setVisible(true);
         c[7] = 7;
       //Button 9
         Btn[2][2] = new JButton();
         Btn[2][2].addActionListener(this);
         Panel.add(Btn[2][2]);
         Btn[2][2].setIcon(new ImageIcon(getIcon(2,1)));
         Btn[2][2].setVisible(true);
         c[8] = 8;
         // makes sure that everything is ok. then it makes the title of the gui and the size of the gui
         //it also sets up the container of the gui program and makes it visible. 
        validate();
        setSize(wide, Long);
       setTitle(place);
       setResizable(true);
       setLocationRelativeTo(null); // center the image
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }
    public void shuffle(){
        set();

    }
    //the name of the file is placed where it can be used in the program
    public static void main(String[] args) {
            new JEightPuzzleFrame("FGCU", "FGCU_logo.png");   
    }
    //Action performed listens to what ever happens in the program and corresponds to the action.
    //makes sure that there is room for the button to move so the program can continue
    @Override
    public void actionPerformed(ActionEvent e){

     JButton button = (JButton) e.getSource();
        Dimension size = button.getSize();

        int emptyX = Btn[0][0].getX();
        int emptyY = Btn[0][0].getY();

        int buttonX = button.getX();
        int buttonY = button.getY();
        int buttonPosX = buttonX / size.width;
        int buttonPosY = buttonY / size.height;
        int buttonIndex = p[buttonPosY][buttonPosX];

        if (emptyX == buttonX && (emptyY - buttonY) == size.height ) {          

             int labelIndex = buttonIndex + 3;

             Panel.remove(buttonIndex);
             Panel.add(Btn[0][0], buttonIndex);
             Panel.add(button,labelIndex);
             Panel.validate();

             int a = c[buttonIndex];
             c[buttonIndex] = c[labelIndex];
             c[labelIndex] = a;              
        }

        if (emptyX == buttonX && (emptyY - buttonY) == -size.height ) {

             int labelIndex = buttonIndex - 3;
             Panel.remove(labelIndex);
             Panel.add(button,labelIndex);
             Panel.add(Btn[0][0], buttonIndex);

             Panel.validate();
             int a = c[buttonIndex];
             c[buttonIndex] = c[labelIndex];
             c[labelIndex] = a; 
        }

        if (emptyY == buttonY && (emptyX - buttonX) == size.width ) {

             int labelIndex = buttonIndex + 1;        
             Panel.remove(buttonIndex);
             Panel.add(Btn[0][0], buttonIndex);
             Panel.add(button,labelIndex);                                 
             Panel.validate(); 
             int a = c[buttonIndex];
             c[buttonIndex] = c[labelIndex];
             c[labelIndex] = a; 
        }

        if (emptyY == buttonY && (emptyX - buttonX) == -size.width ) {

             int labelIndex = buttonIndex - 1;            
             Panel.remove(buttonIndex);
             Panel.add(Btn[0][0], labelIndex);
             Panel.add(button,labelIndex);
             Panel.validate();

             int a = c[buttonIndex];
             c[buttonIndex] = c[labelIndex];
             c[labelIndex] = a; 
        } 
        //checks to see if the buttons are in the right order
        if(c[0] == 1 &&
                c[1] == 2 &&
                c[2] == 3 &&
                c[3] == 4 &&
                c[4] == 5 &&
                c[5] == 6 &&
                c[6] == 7 &&
                c[7] == 8 &&
                c[8] == 9){
//gives the final message when it checks to make sure it is in the right order
            JOptionPane.showMessageDialog(Panel,"You solved it");
            set();
         }
    }
}