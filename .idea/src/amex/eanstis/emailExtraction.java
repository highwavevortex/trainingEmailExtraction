package amex.eanstis;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class emailExtraction {
    public static void main(String[] args) throws IOException {

        Path filePath = Paths.get("sample.txt"); // forms path to file
        String content = Files.readString(filePath, StandardCharsets.UTF_8); // opens file and reads into 'content'

        Pattern emailPattern = Pattern.compile("(\\w+)@softwire\\.com"); // compiles the regex
        Matcher matcher = emailPattern.matcher(content); // matches regex pattern to items in file

        AtomicInteger counter = new AtomicInteger(); // initialised counter

        matcher.results().forEach(e -> { // goes through every match and does the following (e -> = lambda)
            counter.getAndIncrement(); // increments counter
            System.out.println(e.group(0)); // prints matched emails
        });

        System.out.println(counter); // prints counter


    }
}