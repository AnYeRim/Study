package com.example.codingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        1. h 위치를 찾는다.

        2. h 앞의 wh 조합 수와 h 뒤의 e 조합 수를 체크한다.
        (e: 전체 경우 수 - 0개 혹은 1개인 경우 수)
        e가
        1개면 0
        2개면 1 = (4-3) = (2^2-(2+1))
        3개면 4 = (8-4) = (2^3-(3+1))
        4개면 6 = (16-5) = (2^4-(4+1))
        n개면 2^n-n-1 = (2^n-(n+1))

        3. 총합에 (wh 조합 수 * e 조합 수)를 더한다.
        4. 총합 % 1000000007
        */

        long total = 0;
        int i = 0, h_position, w_count, e_count;

        //Scanner sc = new Scanner(System.in);

        int length = 8;
        String text = "WAHEWHEE";

        while (i < length) {
            h_position = text.indexOf("H", i);
            w_count = count(text, "W", 0, h_position);
            e_count = count(text, "E", h_position, length);

            if (h_position != -1) {
                if (w_count > 0 && e_count > 1) {
                    total += w_count * (Math.pow(2, e_count) - e_count - 1);
                }
                i = h_position + 1;
            } else {
                break;
            }
        }

        System.out.println(total % 1000000007);

    }

    private int count(String text, String value, int start, int end) {
        int count = 0;

        start = text.indexOf(value, start);
        while (start != -1 && start < end) {
            count++;
            start = text.indexOf(value, start+1);
        }

        return count;
    }
}