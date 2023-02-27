package com.cydeo.tests.Day09_review_javafaker;

import org.testng.annotations.Test;

public class Singleton_Practice {

    @Test
    public void singleton_understanding_test1(){

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);


    }

}
