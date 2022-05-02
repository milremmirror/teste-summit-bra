package br.com.summit.phoneNumber;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNumber {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(System.in);

        System.out.println("enter your full phone number >");
        String input = s.next();

        String number = input.replaceFirst("(\\d{2})(\\d{2})(\\d{9})", "+$1 ($2) $3");

        System.out.println(number);

        String array[] = number.split(" ", 0);

        String countryCode = array[0];

        CountryFacade countryFacade = new CountryFacade();

        countryFacade.countryDetector(countryCode);

    }
}


