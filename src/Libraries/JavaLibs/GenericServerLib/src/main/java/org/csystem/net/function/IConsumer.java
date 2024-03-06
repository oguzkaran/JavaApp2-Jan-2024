/*----------------------------------------------------------
	FILE			: IRunnable.java
	AUTHOR			: JavaApp2-Jab-2024 Group
	LAST UPDATE		: 6th March 2024

	IConsumer functional interface

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.net.function;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t) throws Exception;
}
