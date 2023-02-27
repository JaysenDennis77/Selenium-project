package com.cydeo.tests.Day09_review_javafaker;

public class Singleton {

    //1- create private constructor
    private Singleton(){

    }
    //2- private static string
    private static String word; // by default word is null

    //3- utility method to return the private string we just created
    public static String getWord(){

        if(word == null){
            System.out.println("First time call, word object is null");
            System.out.println("Assigning value to it now");
            word = "something";
        }else{
            System.out.println("Word already has a value");
        }
        return word;
    }

}
