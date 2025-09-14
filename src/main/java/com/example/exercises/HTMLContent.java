package com.example.exercises;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HTMLContent{
    public static void main(String[] args){

        String input = "<h1>Nayeem loves counseling</h1>\n" +
                "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>\n" +
                "<Amee>safat codes like a ninja</amee>\n" +
                "<SA premium>Imtiaz has a secret crash</SA premium>";

        String input2 =" <h1>some</h1>\n" +
                "<h1>had<h1>public</h1></h1>\n" +
                "<h1>had<h1>public</h1515></h1>\n" +
                "<h1><h1></h1></h1>\n" +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n" +
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
                "<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>\n" +
                "<>hello</>\n" +
                "<>hello</><h>dim</h>\n" +
                "<>hello</><h>dim</h>>>>>";

        String[] lines = input2.split("\\r?\\n");

        for(int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String regex = "<([\\w\\s]+)>([^<>]*)</\\1>";
            String regexInvalids = "<([\\w\\s]+)>([^<>]*)<([^\\/])";

            Pattern p = Pattern.compile(regex);
            Pattern pInvalid = Pattern.compile(regexInvalids);
            List<String> contents = new ArrayList<>();

            boolean found;
            do {
                Matcher mInvalid = pInvalid.matcher(line);
                while(mInvalid.find()) {
                    line = line.replace(mInvalid.group(2), "");
                }
                Matcher m = p.matcher(line);
                found = false;
                while(m.find()) {
                    if(!m.group(2).isEmpty()) {
                        contents.add(m.group(2));
                    }
                    line = line.replace(m.group(), "");
                    found = true;
                }

            }while(found);
            if(contents.isEmpty()) {
                System.out.println("None");
            }else{
                contents.forEach(s -> System.out.println(s));
            }
        }
    }
}



