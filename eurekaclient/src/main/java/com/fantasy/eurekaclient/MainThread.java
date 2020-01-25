package com.fantasy.eurekaclient;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MainThread {
    B b1 = new B(1);
    static B b3 = new B(3);
    MainThread(){
        System.out.println("fantasy init");
    }
    B b2 = new B(2);
    static class B{
        B(int m){
            System.out.println(m+"");
        }
    }
    public static void main(String args[]){
        MainThread M = new MainThread();
        log.info("sdfsfs");

    }
}
