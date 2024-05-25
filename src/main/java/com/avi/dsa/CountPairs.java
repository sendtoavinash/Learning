package com.avi.dsa;

public class CountPairs {

    static int pair(String str) {
        int i = 0;
        int x = 0;
        int y = 0;

        String[] strArr = str.split("");

        for (int j = 0; j < strArr.length / 2; j++) {
            if (strArr[j].equals("{")) {
                x++;
            }
        }
        for (int k = strArr.length / 2; k < strArr.length; k++) {
            if (strArr[k].equals("}")) {
                y++;
            }
        }
        i = Math.min(x, y);

        return i;
    }

    public static void main(String[] args) {
//        {}=1
//        {{}=1
//        }{=0
//        {{}}=2
//        {{{}}}=3

        System.out.println(pair("}{"));

    }
}
