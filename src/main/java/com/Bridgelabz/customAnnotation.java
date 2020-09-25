package com.Bridgelabz;

import java.lang.annotation.*;
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MethodInfo {
    String author() default "Saurabh";
    String date();
    int revision() default 1;
    String  comments();

}
