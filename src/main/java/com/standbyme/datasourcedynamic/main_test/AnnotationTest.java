package com.standbyme.datasourcedynamic.main_test;

import com.standbyme.datasourcedynamic.config.annotation.TestAnno;
import com.standbyme.datasourcedynamic.domain.CalcDate;
import com.standbyme.datasourcedynamic.domain.CalcTask;

import java.lang.annotation.Annotation;

public class AnnotationTest {

    public static void main(String[] args) {

        String testStr = "";
        Class<CalcDate> clazz = CalcDate.class;

        TestAnno annotation = clazz.getAnnotation(TestAnno.class);

        if (annotation != null) {
            testStr = annotation.test();
        }

        System.out.println("testStr = " + testStr);


    }

}
