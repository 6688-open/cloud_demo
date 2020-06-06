package com.dj.cloud.test;

import java.time.ZonedDateTime;

public class Test {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();  //默认时区
        System.out.println("now = " + now);
    }
}
