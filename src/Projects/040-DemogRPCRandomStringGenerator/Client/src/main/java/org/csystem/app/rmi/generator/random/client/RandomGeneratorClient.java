package org.csystem.app.rmi.generator.random.client;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.generator.random.text.RandomTextGeneratorRequest;
import org.csystem.generator.random.text.RandomTextGeneratorServiceGrpc;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@Slf4j
public class RandomGeneratorClient {
    @GrpcClient("random-generator-server")
    private RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceBlockingStub m_stub;

    private void generateTextsCallback(RandomTextGeneratorRequest request)
    {
        try {
            var responseEN = m_stub.generateRandomTextEN(request);
            var responseTR = m_stub.generateRandomTextTR(request);

            log.info("Text:{}", responseEN.getText());
            log.info("Yazı:{}", responseTR.getText());
            Thread.sleep(300);
        }
        catch (InterruptedException ignore) {

        }
    }

    public void generateTexts(int count, int n)
    {
        var request = RandomTextGeneratorRequest.newBuilder().setCount(count).build();

        IntStream.range(0, n).forEach(i -> generateTextsCallback(request));
    }
}
