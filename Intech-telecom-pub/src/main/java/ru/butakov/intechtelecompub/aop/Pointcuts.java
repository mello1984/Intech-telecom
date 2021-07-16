package ru.butakov.intechtelecompub.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("@annotation(ru.butakov.intechtelecompub.aop.Loggable)")
    public void loggableMethods() {
    }

    @Pointcut("@within(ru.butakov.intechtelecompub.aop.Loggable)")
    public void loggableClasses() {
    }

    @Pointcut("ru.butakov.intechtelecompub.aop.Pointcuts.loggableClasses() || " +
            "ru.butakov.intechtelecompub.aop.Pointcuts.loggableMethods()")
    public void loggable() {
    }
}
