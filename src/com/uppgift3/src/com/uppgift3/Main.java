package com.uppgift3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("AjA","CooL","vaed", "sammmA","myth","brr","watch");

        System.out.println(findWordsContainingtwoOrMoreVowels(words));

        System.out.println("==========================================");

        Pattern p = Pattern.compile("[aeiouy][^ ]*[aeiouy]", Pattern.CASE_INSENSITIVE);
        ArrayList<String> arrayList = words.stream()
                .filter(s -> p.matcher(s).find())
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(arrayList);
        System.out.println("===========================================");

        Stream.of("AjA","CooL","vaed","sammaA","myth","brr","watch")
                .filter(s -> p.matcher(s).find())
                .forEach(System.out::println);


        //Testade bara lite olika metoder
    }
    public static List<String> findWordsContainingtwoOrMoreVowels(List<String> list) {

        List<String> matches;
        Pattern p = Pattern.compile("[aeiouy][^ ]*[aeiouy]", Pattern.CASE_INSENSITIVE);
        matches = list.stream()
                .filter(s -> p.matcher(s).find())
                .toList();

        return matches;
    }
}

