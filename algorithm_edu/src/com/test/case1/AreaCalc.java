package com.test.case1;

import java.util.Scanner;

/*
If this is your first time at Remote Interview, we recommend you try our sample test first to get familiar with the test environment: Sample Test .
The screening test has 5 programming questions.
The programming questions can be solved in Java, Swift, Kotlin, C/C++, Objective-C or JavaScript (Node).
You have up to 210 minutes to complete the test. Once you start, you should complete the test in a single attempt.
Your websession will be maintained if you received the automated email invite, you can use that link to resume your test but please try not to close the window/tab during the test.
Make sure that your solution handles all possible corner cases and handles large inputs efficiently. Assume nothing, trust no one.
May the force be with you!
 */

/*
There are 5 questions in total.
Your code is automatically saved at all times and you can go back and forth between questions by clicking on the numbers to the left.
When you are done with writing the code for a question, click "Submit Solution" to submit your answer.
(You may edit your code until the time limit is over.)
You can change your preferred programming language next to the 'RUN' button.
You can click the 'RUN' button to execute your code against the sample input and compare it with the sample output.
For questions 1, you will be provided with a sample input/output result in C/C++, Java, and Python. 
You are free to use any programming language, but you must adhere to the following rules.
If you must use a programming language that is not provided by the system, write your code in plain text. 

You must display the time complexity of your code and provide a brief description.
Avoid using language-specific features. If necessary, leave a comment on your code describing the feature and expected time complexity.
*/

/*
The first line of the input is the horizontal and vertical lengths of the rectangle. 
The two lengths are separated by a blank space, and those numbers are integers between 0-1024.
*/

/*
 * time complexity  : O(1)
 * 넓이를 구하는 프로그램
 */
public class AreaCalc {
    public static int getArea(int width, int height){
        return width * height;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in).useRadix(10);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        if(width >= 0 && width <= 1024) {
        	if(height >= 0 && height <= 1024) {
        		System.out.println(getArea(width, height));		
        	}else {
        		System.out.println("세로길이가 기능 구현 범위 밖입니다.");
        	}
        }else {
        	System.out.println("가로길이가 기능 구현 범위 밖입니다.");
        }
    }
}
