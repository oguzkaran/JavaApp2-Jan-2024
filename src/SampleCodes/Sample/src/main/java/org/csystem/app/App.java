/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örneğin genelleştirilmiş bir biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.console.Console;
import org.csystem.util.net.ip.protocol.standard.text.Pop3Client;

class App {
    public static void main(String[] args)
    {
        try  (var pop3Client = new Pop3Client(args[0], args[1], args[2])) {
            Console.writeLine(pop3Client.login());
            pop3Client.listEmail().forEach(Console::writeLine);
            Console.writeLine("---------------------------------");
            pop3Client.retreiveEmail(6).forEach(Console::writeLine);
        }
        catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}