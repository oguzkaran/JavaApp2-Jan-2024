/*----------------------------------------------------------------------
	FILE        : ILogin.java
	AUTHOR      : Oğuz Karan
    LAST UPDATE : 21.04.2023

	ILogin interface for login operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.util.net.ip.protocol.standard.text;

import java.io.IOException;

public interface ILogin {
    boolean login() throws IOException;
    boolean logout() throws IOException;
}
