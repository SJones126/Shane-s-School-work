import java.io.*;
//class of date uses this for every date value
class Date{ 

    private int day;
    private int month;
    private int year;
    //this get the information from the user
    private void readData(){    
        try{ 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\tPlease input the month: ");
            month = Integer.parseInt(br.readLine());
            System.out.print("\tPlease input the day: ");
            day = Integer.parseInt(br.readLine());
            System.out.print("\tPlease input the year: ");
            year = Integer.parseInt(br.readLine());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

   Date(){
        //where readData is called
        this.readData(); 
    }
   
   
    public void print(){
	//prints out the date
        System.out.print(month + "/" + day + "/" + year); 
    }
   
 }
//superclass
class Student{ 

    private String name; 
    private int ssn;
    private int numOfCourses;
    private Date birthDate;
    protected char gender;
//reads the data this is typed in
//Checks to see what type of gender is typed and asks the questions accordingly
// continues to print the gender specific questions
    private void readData(){ 
	//takes in info from student
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please input the name: ");
            name = br.readLine();
            System.out.print("Please input the ssn: ");
            ssn = Integer.parseInt(br.readLine());
            System.out.print("Male/Female (m/f): ");
            gender = (char)br.read();
            if(gender == 'm' || gender == 'M'){
		//gender check
                br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("How many courses he is taking? ");
                numOfCourses = Integer.parseInt(br.readLine());
                System.out.println("Please input his birth date:");
                birthDate = new Date();
            }else if(gender == 'f' || gender=='F'){ 
                br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("How many courses she is taking? ");
                numOfCourses = Integer.parseInt(br.readLine());
                System.out.println("Please input her birth date:");
                birthDate = new Date();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    Student(){
        
        this.readData(); 
    //readData is called
    
    }
   
   
    public void print(){ 
	//where everything is printed for student
        System.out.println();
        System.out.println("The information you input was");
        System.out.println(name + "'s ssn is " + ssn + ".");
        if(gender == 'm' || gender=='M'){ 
            System.out.println("He is taking " + numOfCourses + " courses."); 
            System.out.print("His birth date is ");
            birthDate.print();
            System.out.println();
           
        }else if(gender == 'f' || gender=='F'){ 
            System.out.println("She is taking " + numOfCourses + " courses.");
            System.out.print("Her birth date is ");
            birthDate.print();
            System.out.println();
       
        }
    }
//main clas that causes the program to run.
    public static void main(String[] args){ 
        GradTA ta = new GradTA();
        ta.print();
    }
   
 }
//Gradstudent is a subclass and uses the variables of super but can't change them.
class GradStudent extends Student {

    private String researchTopic; 
    private String advisor;
    private void readData(){
//reads the data that is typed in.
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if(gender == 'm' || gender=='M'){ 
                System.out.print("Please input his research topic: ");
                researchTopic = br.readLine();
                System.out.print("Please input his research advisor: ");
                advisor = br.readLine();
               
            }else if(gender == 'f' || gender=='F'){
                System.out.print("Please input her research topic: ");
                researchTopic = br.readLine();
                System.out.print("Please input her research advisor: ");
                advisor = br.readLine();
           
            }
        }catch(IOException e){
            System.out.println(e.getMessage()); 
        }
    }
   
    GradStudent(){
        this.readData(); 
    }
   //prints the values that is inputted
    public void print(){
        super.print(); 
        if(gender == 'm' || gender=='M'){ 
            System.out.println("His research topic is " + researchTopic + ".");
            System.out.println("His advisor is " + advisor + ".");
           
        }else if(gender == 'f' || gender=='F'){
            System.out.println("Her research topic is " + researchTopic + ".");
            System.out.println("Her advisor is " + advisor + ".");
       
        }
    }
 }
//GradTA is a subclass of gradstudent
class GradTA extends GradStudent{
    //private variables
    private String taCourse;
    private String taInstructor;
    private Date hireDate;
   
    private void readData(){
//reads the items that are typed in
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if(gender == 'm' || gender=='M'){ 
                System.out.print("Please input his Ta course: ");
                taCourse = br.readLine();
                System.out.print("Please input his Ta instructor: ");
                taInstructor = br.readLine();
                System.out.println("Please input his hire Date");
                hireDate = new Date();
            }else if(gender == 'f' || gender=='F'){ 
                System.out.print("Please input her Ta course: ");
                taCourse = br.readLine();
                System.out.print("Please input her Ta instructor: ");
                taInstructor = br.readLine();
                System.out.println("Please input her hire Date");
                hireDate = new Date();
            }

       }catch(IOException e){ 
            System.out.println(e.getMessage());
        }
    }
   
    GradTA(){
        this.readData();
    }


   //prints according to the gender
    public void print(){
        super.print();
        if(gender == 'm' || gender=='M'){ //checks if male
            System.out.println("His Ta Course is " + taCourse + ".");
            System.out.println("His Ta Instructor is " + taInstructor + ".");
            System.out.print("His hire date is ");
            hireDate.print();
            System.out.println();
           
        }else if(gender == 'f' || gender=='F'){
            System.out.println("Her Ta Course is " + taCourse + ".");
            System.out.println("Her Ta Instructor is " + taInstructor + ".");
            System.out.print("Her hire date is ");
            hireDate.print();
            System.out.println();
       
        }
    }
 


    
 }
	
