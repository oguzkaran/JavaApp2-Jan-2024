package org.csystem.app.payment.ticketcard.client;

import com.karandev.util.net.TcpUtil;
import lombok.extern.slf4j.Slf4j;
import org.csystem.app.payment.ticketcard.App;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class InformationClient {
    private final ConfigurableApplicationContext m_applicationContext;
    //private final ExecutorService m_threadPool;
    private final Socket m_socket;

    @Value("${app.id}")
    private int m_id;

    @Value("${server.port}")
    private int m_servicePort;

    private void startService()
    {
        log.info("Rest service starts");
    }

    public InformationClient(ConfigurableApplicationContext applicationContext, Socket socket)
    {
        m_applicationContext = applicationContext;
        m_socket = socket;
    }

    public void run()
    {
        log.info("Send information to the manager server");
        try (m_socket) {
            var info = "R;http://%s:%s/payment/card/ticket/pay;http://%s:%s/payment/card/ticket/report/today"
                    .formatted("localhost", m_servicePort, "localhost", m_servicePort); //Dummy

            m_socket.setSoTimeout(3000);
            TcpUtil.sendInt(m_socket, m_id);
            TcpUtil.sendStringViaLength(m_socket, info);
            var status = TcpUtil.receiveByte(m_socket);

            log.info("Status:{}", status);

            if (status == 1)
                new Thread(this::startService).start();
            else {
                log.info("Cannot connect to manager server");
                m_applicationContext.close();
            }
        }
        catch (IOException ex) {
            log.error("Send information problem:{}", ex.getMessage());
        }
    }
}
