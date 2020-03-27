//0389 Assignment 1
import java.io.IOException;
public class Postfix {

    public final static int MAXCOLS = 80;

    public static void main(String[] args) throws IOException {
//asks for all of the values
        String infix, pfix;
        System.out.println("Enter a infix  String: ");
        infix = readString().trim();
        System.out.println("The original infix expr is:  " + infix);
        pfix = postfix(infix);
        System.out.println("The Postfix expr is:  " + pfix);
        System.out.println("The value is :  " + eval(pfix));
    } // end main

    
    public static boolean isOperand(char x) {//this is for the ()
    	if (x=='+' || x=='-' || x=='*' || x=='/' || x=='$') {

    		return true;
    	}

    		else {

    		return false;
    		}
    }

    
    public static int operPrecedence(char oper) {//sets the precedence of the item
    	if(oper == '+'||oper == '-' )       
        {
            return 1;
        }

        else if (oper == '*' || oper ==  '/')
        {
            return 2;
        }

        else if (oper == '$')
        {
            return 3;
        }
        return 0;
    }

    
    public static boolean precedence(char top, char symb) {//sees if it is has a precedence from the symbol and top of the stack
    	if (symb=='(') {

    		return false;
    	}
    	if (top=='(') {

    		return false;
    	}
    	if (symb==')') {

    		return true;
    	}

    		else{
    			return (operPrecedence(symb)>=operPrecedence(top)?true:false);
    		}
    }

    public static String readString() throws IOException {
        char[] charArray = new char[80];
        int position = 0;
        char c;
        while ((c = (char) System.in.read()) != '\n') {
            charArray[position++] = c;

        }
        return String.copyValueOf(charArray, 0, position); // turns a character array into a string, starting between zero and position-1

    }// end read string

    public static double eval(String infix) {

        char c;
        int position;
        double opnd1, opnd2, value;
        Stack opndstk = new Stack();
        for (position = 0; position < infix.length(); position++) {
            c = infix.charAt(position);
            if (Character.isDigit(c)) // operand-convert the character represent of
            // the digit into double and push it into the
            // stack
            {
                opndstk.push((double) Character.digit(c, 10));
            } else {

                // operator
                opnd2 = opndstk.pop();
                opnd1 = opndstk.pop();
                value = oper(c, opnd1, opnd2);
                opndstk.push(value);
            } // else
        } // end for
        return opndstk.pop();
    }// end eval

    public static String postfix(String infix) {
        int position, outpos = 0;
        char symb;
        char[] postr = new char[MAXCOLS];
        CharStack opstk = new CharStack(); //Creates character stack for for both operands and operators
        for (position = 0; position < infix.length(); position++) {
            symb = infix.charAt(position); //Searches through each symbol in the string 
            if (isOperand(symb)) {
                postr[outpos++] = symb;
            } 
            else {
                while (!opstk.empty() && precedence(opstk.peek(), symb)) {
                    postr[outpos++] = opstk.pop();
                } // end while
                if (symb != ')') {
                    opstk.push(symb);
                } else {
                    opstk.pop();
                }
            } // end else

        } // end for
        while (!opstk.empty()) {
            postr[outpos++] = opstk.pop();
        }
        return String.copyValueOf(postr, 0, outpos);

    }// end pos

    public static double oper(char symb, double op1, double op2) {

        double value = 0;
        switch (symb) {
            case '+':
                value = op1 + op2;
                break;
            case '-':
                value = op1 - op2;
                break;
            case '*':
                value = op1 * op2;
                break;
            case '/':
                value = op1 / op2;
                break;
            case '$':
                value = Math.pow(op1, op2);
                break;
            default:
                throw new RuntimeException("illegal operator: " + symb);

        }// end switch
        return value;
    }// end oper

}


