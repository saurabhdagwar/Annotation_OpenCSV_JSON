package com.Bridgelabz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Saurabh", comments = "Main Method", date = "Sept 24 2020", revision = 1 )
    public String toString(){
        return "Overridden toString Method";
    }
    @Deprecated
    @MethodInfo(comments = "Deprecated method ", date = "Sept 25 2020")
    public static void oldMethod(){
            System.out.println("Old method doesn't use it.");
    }

    public static void main(String[] args) {
        try{
            for(Method method : AnnotationExample.class.getMethods()){
                if(method.isAnnotationPresent(MethodInfo.class)){
                    try{
                        for(Annotation annotation : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in Method :"+method+" : "+annotation);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if(methodAnno.revision() == 1){
                            System.out.println("Method with revision no 1 : "+method);
                        }
                    }catch (Throwable e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

}