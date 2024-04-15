package org.csystem.app.information;

import com.karandev.io.util.console.CommandPrompt;
import com.karandev.io.util.console.Console;
import com.karandev.util.net.IpUtil;
import org.csystem.app.information.server.CommunicationServerInfoServer;
import org.csystem.app.information.server.JoinMeetingInformationServer;
import org.csystem.app.information.server.manage.MeetingManagerServerCommands;

import java.io.IOException;
import java.util.concurrent.Executors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthLessOrEqual;

class Application {
    private static int findAvailablePorts() throws IOException
    {
        var opt = IpUtil.getFirstAvailablePort(1024, 65536);

        if (opt.isEmpty())
            throw new IOException("No available port!...");

        var basePort = opt.getAsInt();
        opt = IpUtil.getFirstAvailablePort(basePort + 1);

        if (opt.isEmpty())
            throw new IOException("No available port!...");

        return basePort;
    }

    public static void run(String[] args)
    {
        try {
            checkLengthLessOrEqual(args.length, 2, "wrong number of arguments!...");
            int basePort;
            int backlog = 512;

            if (args.length == 1) {
                backlog = Integer.parseInt(args[0]);
                basePort = findAvailablePorts();
            }
            else if (args.length == 2) {
                backlog = Integer.parseInt(args[0]);
                basePort = Integer.parseInt(args[1]);
            }
            else
                basePort = findAvailablePorts();

            var communicationServerInfoServer = new CommunicationServerInfoServer(basePort + 1, backlog);
            var joinMeetingInformationServer = new JoinMeetingInformationServer(basePort, backlog);

            CommandPrompt.createBuilder()
                    .setPrompt("meeting-manager")
                    .registerObject(new MeetingManagerServerCommands(joinMeetingInformationServer, communicationServerInfoServer, Executors.newCachedThreadPool()))
                    .create()
                    .run();
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid arguments");
        }
        catch (IOException ex) {
            Console.Error.writeLine("IO Exception occurred:%s", ex.getMessage());
        }
    }
}
