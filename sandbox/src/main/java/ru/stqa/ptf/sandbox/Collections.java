package ru.stqa.ptf.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by neznaa on 3/17/2016.
 */
public class Collections {

    public static void main (String[] args) {
        String[] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

        for (String l: langs) {
            System.out.println("I want to learn " + l);
        }
    }

}
