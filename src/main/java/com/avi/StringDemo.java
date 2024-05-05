package com.avi;

import java.text.ParseException;

public class StringDemo {
    public static void main(String[] args) throws ParseException {

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
//        System.out.println(formatter.format(new Date()));
//        System.out.println(String.valueOf(new Date().getTime()));

//        String s = "nileshkemse@gmail.com";
//        System.out.println(s.replaceAll("(^[^@]{3}|(?!^)\\G)[^@]", "$1*"));

//        System.out.println(html2text("<p style=\"text-align: center;\"><span>Test To Be Merged Tested.</span></p><p style=\"text-align: center;\"><span>New Test</span></p><p style=\"text-align: left;\"><span>INitial&nbsp;</span></p><p style=\"text-align: center;\"><span>Center</span></p><p style=\"text-align: right;\">Right</p>"));

//        String originalInput = "password";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//        System.out.println(encodedString);

        String test = null;
        System.out.println(isNullBlankString(test));
        String test1 = "";
        System.out.println(isNullBlankString(test1));
        String test2 = "abc";
        System.out.println(isNullBlankString(test2));

        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = s1.intern();//returns string from pool, now it will be same as s2
        System.out.println(s1 == s2);//false because reference variables are pointing to different instance
        System.out.println(s2 == s3);//true because reference variables are pointing to same instance

    }

//    public static String html2text(String html) {
//        String htmlText = Jsoup.parse(html).html();
//        return Jsoup.parse(htmlText).wholeText();
//    }

    public static boolean isNullBlankString(String string) {
        return string == null || string.isBlank();
    }

}
