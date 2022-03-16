package com.example.java;

import android.util.Log;

public class RegexTest {

    public void run(){

        /* |(또는) */
        String text = "HI";

        System.out.println(text);
        System.out.println("HI | Hi | hi : "
                +text.matches("HI|Hi|hi"));

        /* [](한문자) */
        text = "카";
        System.out.println(text);

        System.out.println("[아자차카타파하] : "
                +text.matches("[아자차카타파하]"));

        System.out.println("[아-하] : "
                +text.matches("[아-하]"));

        System.out.println("[^가-사] : "
                +text.matches("[^가-사]"));

        /* () (그룹) */
        System.out.println("반갑다");

        System.out.println("반갑(다|습니다) : "
                +"반갑다".matches("반갑(다|습니다)"));

        System.out.println("반갑습니다");

        System.out.println("반갑(다|습니다) : "
                +"반갑습니다".matches("반갑(다|습니다)"));

        /* ? * + {} (반복) */
        System.out.println("카아?악 : "
                +"카악".matches("카아?악"));

        System.out.println("카아+악 : "
                +"카아악".matches("카아+악"));

        System.out.println("카아{2}악 : "
                +"카아아악".matches("카아{2}악"));

        System.out.println("카아{3,5}악 : "
                +"카아아아악".matches("카아{3,5}악"));

        System.out.println("카아{3,5}악 :  "
                +"카아아아아악".matches("카아{3,5}악"));

        System.out.println("카아{3,5}악 : "
                +"카아아아아아악".matches("카아{3,5}악"));

        System.out.println("카아*악 : "
                +"카아아아아아아악".matches("카아*악"));

        /* ^ $ \ (문자열이 아닌 위치나 특정 용도) */
        System.out.println("^첫끝$ : "
                +"첫끝".matches("^첫끝$"));

        System.out.println("^첫\\D끝$ : "
                +"첫과끝".matches("^첫\\D끝$"));

        System.out.println("^첫\\D+끝$ : "
                +"첫문자들끝".matches("^첫\\D+끝$"));

        /* . (임의의 한문자) */
        System.out.println("...."
                +"Ab가@".matches("...."));
    }
}
