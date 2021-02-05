package com.cse21;

public class FindDuplicateCount {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 3, 4, 2, 1, 3, 0, 5, 3, 2, 5, 0};
        int i = 0;
        while (i < arr.length) {
            int c = 0;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j])
                    c++;
            if (c == 0)
                System.out.println("There are no duplicates with value " + arr[i] + " beyond index " + i);
            else if (c == 1)
                System.out.println("There is only " + c + " more occurrences of value " + arr[i] + " starting index " + i);
            else
                System.out.println("There are " + c + " more occurrences of value " + arr[i] + " starting index " + i);
            i++;
        }
    }
}

/*
Part 3: (Assessment) Logic Check
Create a Word document or text file named Part3 that contains answers to the following:
1.	When did you take CSE-020?
    1.	I took CSE 020 during the summer at a community college and mainly learned C++, but I have been coding on Swift since the beginning of 2019.
2.	How long did this lab take to finish?
    1.	It took me around two hours, but several factors prevented me to finish right away.
3.	Any difficult topics for you in these two exercises? If so list them:
    1.	I do not think any parts of these exercises were difficult, once I realized what I needed to do it was easier to think for a solution and translate it to code.
4.	For the array given in FindDuplicateCount.java, which index is the last check we need to make to count all the duplicates?
    1.	The loops check every number first and if it recognizes the duplicate, it starts to seek for every repeated number after that and it starts displaying multiple occurrences of the number.
5.	Interpret the number 101011 in bases 2, 10, 16. For each, convert to the other two bases. You need to show all 6 conversions:
    1.	a)  When interpreting 101011 as a base 2 number, convert to bases 10 and 16;
        1.	101011 as base 2, 43 as base 10 and 2B as base 16
    2.	b)  When interpreting 101011 as a base 10 number, convert to bases 2 and 16;
        1.	101011 when converted to base 2 is 11000101010010011 and converted to base 16 is 18A93
    3.	c)  When interpreting 101011 as a base 16 number, convert to bases 2 and 10;
        1.	101011 when converted to base 2 is 100000001000000010001 and converted to base 10 is 1052689

 */