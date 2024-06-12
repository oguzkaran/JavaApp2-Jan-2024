package org.csystem.app.payment.ticketcard.client;

import com.karandev.util.net.TcpUtil;
import lombok.extern.slf4j.Slf4j;
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

    @Value("${app.id}")
    private int m_id;

    @Value("${server.port}")
    private int m_servicePort;

    private void startService()
    {
        log.info("Rest service starts");
    }

    public InformationClient(ExecutorService threadPool, Socket socket)
    {
        m_threadPool = threadPool;
        m_socket = socket;
    }

    public void run()
    {
        log.info("Trying to connect PaymentManagerServer application");
        try  {
            var info = "R;http://%s:%s/payment/card/ticket/pay;http://%s:%s/payment/card/ticket/report/today"
                    .formatted("localhost", m_servicePort, "localhost", m_servicePort); //Dummy
            m_socket.setSoTimeout(3000);
            TcpUtil.sendInt(m_socket, m_id);
            TcpUtil.sendStringViaLength(m_socket, info);
            var status = TcpUtil.receiveByte(m_socket);

            log.info("Status:{}", status);

            if (status == 1)
                m_threadPool.execute(this::startService);
            else
                log.error("Cannot connect to manager server");
        }
        catch (IOException ex) {
            log.error("Send information problem:{}", ex.getMessage());
        }
    }
}
