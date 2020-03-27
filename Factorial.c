
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int result = 0;
int value = 0;
//computes the factorial for the system
int Factorial(int value) {
    result = 1;
    
    if(value <= 0)
        result = 1;
    
    for(int i = 1; i <= value; ++i){
        result *= i;
    }
    return result;
}

int main(int argc, char** argv) {
    int status;
    
    //asks for the integer
    
    printf("Please enter an integer: ");
    scanf("%d",&value);
    
    //forks to the child
    
    pid_t pid = fork();
    
    if(pid == 0) {
        //makes the factorial = to the result
        if(value >= 1 && value <= 5) {
            result = Factorial(value);
            exit(result);
            }
        else{
            return 1;
        }
    }
    else if( pid > 0) {
        //has the parent wait for the child to finish and see the status of
        //the child
        wait(&status);
        result = WEXITSTATUS(status);
        /*checks the result to see if it is in the correct range for the
        factorial
        It then gives the correct input for the correct */
        
        if(value == 0) {
            printf("Result are out of range!");
        }
        else if( value > 5) {
            printf("Results are out of range!");
        }
        else if( value < 1) {
            printf("Invalid Input");
        }
        else {
            printf("Factorial of %d = %d\n", value, result);
        }
    }
    else {
        printf("Fork Failed \n");
        return 1;
    }
    return 0;
}