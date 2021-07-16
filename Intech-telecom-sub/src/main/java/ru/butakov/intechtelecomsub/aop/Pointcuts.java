package ru.butakov.intechtelecomsub.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("@annotation(ru.butakov.intechtelecomsub.aop.Loggable)")
    public void loggableMethods() {
    }

    @Pointcut("@within(ru.butakov.intechtelecomsub.aop.Loggable)")
    public void loggableClasses() {
    }

    @Pointcut("ru.butakov.intechtelecomsub.aop.Pointcuts.loggableClasses() || " +
            "ru.butakov.intechtelecomsub.aop.Pointcuts.loggableMethods()")
    public void loggable() {
    }
}
