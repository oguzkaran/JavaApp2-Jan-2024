package org.csystem.app.information;

import com.karandev.io.util.console.Console;
import org.csystem.app.information.client.InformationClient;
import org.csystem.app.information.server.SendInformationServer;

import java.io.IOException;
import java.util.concurrent.Executors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

class Application {
    public static void run(String[] args)
    {
        var threadPool = Executors.newCachedThreadPool();

        try {
            checkLengthEquals(args.length, 5, "usage: ... <name> <backlog> <base port> <manager host> <manager port>");
            var name = args[0];
            var backlog = Integer.parseInt(args[1]);
            var basePort = Integer.parseInt(args[2]);

            var sendInformationServer = new SendInformationServer(basePort, backlog, name);
            var informationClient = new InformationClient(basePort + 1);

            informationClient.run(name, args[3], Integer.parseInt(args[4]));
            threadPool.execute(sendInformationServer::run);
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred:%s", ex.getMessage());
        }
        catch (Throwable ex) {
            Console.Error.writeLine("Exception occurred:%s", ex.getMessage());
        }
        finally {
            threadPool.shutdown();
        }
    }
}
