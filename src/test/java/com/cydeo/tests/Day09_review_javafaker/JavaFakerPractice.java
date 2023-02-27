package com.cydeo.tests.Day09_review_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test1(){
        //Create Java Faker object/
        Faker faker = new Faker();

        //print out a random first name using faker object
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        // print last name
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        // print out a fullname
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        //print out a city
        System.out.println("faker.address().city() = " + faker.address().city());

        //print out a zip code
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        // numerify() method is used to generate digits with specific formatting.
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));

        //letterify() method is used to generate RANDOM letters with specific formatting
        System.out.println("faker.letterify(\"????_????_????\") = " + faker.letterify("????_????_????"));

        //Bothify() method is used to generate random numbers and letters
        System.out.println("faker.bothify(\"#?#?#?#?#?#?#?#?#?#?#?#?#?#?#\") = " + faker.bothify("#?#?#?#?#?#?#?#?#?#?#?#?#?#?#"));

        //chuckNorris method is used to create chuckNorris facts
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
        System.out.println("faker.muhtar().fact() = "
                + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Muhtar"));
    }

}
