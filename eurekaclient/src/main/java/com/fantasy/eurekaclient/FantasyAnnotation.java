package com.fantasy.eurekaclient;


import java.lang.reflect.Field;

public class FantasyAnnotation {

    @fantasy(fantasyName = "ming", fantasyAge = 22)
    private int age;

    @fantasy(fantasyName = "fantasy",fantasyAge = 25)
    private String name;


    public static void getFantasyAnnotation(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            fantasy fantasyAnnotation = (fantasy)field.getAnnotation(fantasy.class);
            System.out.printf(fantasyAnnotation.fantasyAge()+"");
            System.out.printf(fantasyAnnotation.fantasyName());
        }
    }

    public static void main(String[] args) {
        getFantasyAnnotation(FantasyAnnotation.class);
    }
}
