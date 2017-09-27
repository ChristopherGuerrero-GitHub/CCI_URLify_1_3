package com.example.java;

public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution for CCI book problem 1.3 URLify. The goal is to replace in a string for every
            blank space replace the blank space with the characters %20. ie. Mr John Smith would be Mr%20John%20Smith
         */
        char [] arryChar = new char[20];

        String string1 = "Mr John Smith    ";

        arryChar = string1.toCharArray();
        replaceSpaces(arryChar,13);



	}


	static void replaceSpaces(char [] str, int trueLength){

        int i = 0, index, spaceCount = 0;

        //Count and accumulate how many spaces in the character array
        for (i = 0; i < trueLength; i++) {

            if (str[i] == ' ')
                spaceCount++;

        }

        //calculate index to include how much more space is required to accomodate the %20 for each blank space.
        index = trueLength + spaceCount * 2;

        //add null terminator to truncate extra trailing spaces if the true length is less than the string total length.
        if (trueLength < str.length)
            str[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0 ; i--) {

            //Use index since it is greater than trueLength because it accomodates two additional spaces for each
            // blank space. When a blank space is encountered than replace what would be just on blank space with instead
            // a %20 with the use of index.  str[i] where i is the length of trueLength which only includes blank space
            // without the extra two spaces required to fill in a %20.
            if (str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else {

                str[index - 1] = str[i];
                index--;

            }
        }

        //print out results
        System.out.println("Output is : " + new String(str));


    }
}
