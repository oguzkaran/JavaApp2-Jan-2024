/*----------------------------------------------------------------------
	FILE        : Command.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 24.02.2024

	Command annotation

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.util.console.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Commands.class)
public @interface Command {
    String value() default "";
}