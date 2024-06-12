package org.csystem.app.payment.creditcard.client;

import com.karandev.util.net.TcpUtil;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.creditcard.server.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class InformationClient {
    private final ExecutorService m_threadPool;
    private final Socket m_socket;
    private final Server m_server;

    @Value("${app.id}")
    private int m_id;

    @Value("${app.port}")
    private int m_port;

    public InformationClient(ExecutorService threadPool, Socket socket, Server server)
    {
        m_threadPool = threadPool;
        m_socket = socket;
        m_server = server;
    }

    public void run()
    {
        log.info("Trying to connect PaymentManagerServer application");
        try  {
            m_socket.setSoTimeout(3000);
            TcpUtil.sendInt(m_socket, m_id);
            TcpUtil.sendStringViaLength(m_socket, "S;%d".formatted(m_port));
            var status = TcpUtil.receiveByte(m_socket);

            log.info("Status:{}", status);

            if (status == 1)
                m_threadPool.execute(m_server::run);
            else
                log.error("Cannot connect to manager server");
        }
        catch (IOException ex) {
            log.error("Send information problem:{}", ex.getMessage());
        }
    }
}
