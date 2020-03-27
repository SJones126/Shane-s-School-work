import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class test extends JFrame {
	//label and field variable
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JTextField arab;
	private JTextField rom;
	private GridLayout gridLayout1;
	
    public static void main(String[] args) {
		//sets the gui to be viewed
	    
			
            	test Numeral =  new test();
        		Numeral.setVisible(true);
        		Numeral.setSize(350,125);
        		Numeral.setLocationRelativeTo(null);
        		
            }
		

	
	//constructor of the program
	public test(){
		super("Roman<-->Arabic");
		gridLayout1 = new GridLayout(2,2);
		setLayout(gridLayout1);
		
		//creates the components of the JLabel and TextField
		label1 = new JLabel("Arabic");
		label2 = new JLabel("Roman");
		arab = new JTextField();
		rom = new JTextField();
		
		
		//add components to the layout
		add(label1);
		add(arab);
		
		add(label2);
		add(rom);
		
		//adds the key listener to the Arabic text field
		arab.addKeyListener( new KeyAdapter() {
			
			
			public void keyReleased(KeyEvent e){
				
				String text = arab.getText();
				
				
				int result = 0;
				
				try{
					//makes sure that the text value is numbers
				     result = Integer.parseInt(text); 
				     
				     if (result >= 1 && result <= 3999){
				    	 
				    	
				    	 String roman="";
				         int repeat;
				        //the value of numeric to Roman value for the program to get the right string symbol for the numeric value
				         int magnitude[]={1000,900, 500, 400, 100, 
				        		 90, 50, 40, 10, 9, 5, 4, 1};
				         String symbol[]={"M","CM", "D", "CD", "C", "XC", "L",
				        		 "XL", "X", "IX", "V", "IV", "I"};
				        
				         repeat = result;
				         
				        //loop to determine the correct Roman value that needs to be printed
				         for(int j = 0; result > 0; j++){
				             repeat = result / magnitude[j];
				             
				             for(int i = 1; i <= repeat; i++){
				                 roman = roman + symbol[j];
				                 
				             }
				             result = result % magnitude[j];
				             rom.setText(roman);
				             
				         }
				  
				     }
				     else{
				    	 arab.setText(null);
						 rom.setText(null);
				    	 
				     }
				
				}
				//nulls if the value isn't a number
				catch(NumberFormatException error){
					 arab.setText(null);
					 rom.setText(null);
				     
				}
			
			}
						
		});
	
		//keyListener for the roman TextField
		rom.addKeyListener(new KeyAdapter() {
			
			//Keyevent for the roman
			public void keyReleased(KeyEvent e){
				
				String result = rom.getText();
				
				//makes sure that the value that is entered is capitalized when entered
				String romanNumeral = result.toUpperCase();
				
				///makes sure that the values entered are only the correct Roman values
				if (!(Pattern.matches("^[MCDLXVI]+$", romanNumeral))) {
					
					arab.setText(null);
					rom.setText(null);
				   
				}
				else{
				//makes sure that the Roman value is converted into an arabic number
					int decimalNum = 0;
					
					//Gets length of the string entered
					int len =  romanNumeral.length();
					
					int num = 0;
					int previousNum = 0;
					for (int i = len - 1; i >= 0 ;i--) { 
                        
						char x =  romanNumeral.charAt(i);
						x = Character.toUpperCase(x);
                    //goes through and the case to make sure that the Roman number is given the correct values
						switch(x){  
                           
							case 'I':
                                previousNum = num;
                                num = 1;
                                break;
                             case 'V':
                            	 previousNum = num;
                                 num = 5;
                                 break;
                             case 'X':
                            	 previousNum = num;
                                 num = 10;
                                 break;
                             case 'L':
                            	 previousNum = num;
                                 num = 50;
                                 break;
                             case 'C':
                                        previousNum = num;
                                num = 100;
                                break;
                             case 'D':
                                        previousNum = num;
                                num = 500;
                                break;
                             case 'M':
                                        previousNum = num;
                                num = 1000;
                                break;
                        }  
                
                        if (num<previousNum)
                        {decimalNum = decimalNum - num;}
                         
                        else
                        decimalNum = decimalNum + num;

			    
                }
					//sets the value in Arabic
                arab.setText((String.valueOf(decimalNum)));
                
				}    
			}
		});
	}

}

