package org.csystem.app.rmi.generator.random.client;

import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.generator.random.text.RandomTextGeneratorServiceGrpc;
import org.csystem.generator.random.text.TextGeneratorRequest;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
@Slf4j
public class RandomGeneratorENClient {
    @GrpcClient("random-generator-server")
    private RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceBlockingStub m_stub;

    private void generateTextsCallback(TextGeneratorRequest request)
    {
        try {
            var response = m_stub.generateTextEN(request);

            log.info("Text:{}", response.getText());
            Thread.sleep(300);
        }
        catch (StatusRuntimeException ex) {
            log.error("Error:{}, {}", ex.getStatus(), ex.getMessage());
        }
        catch (InterruptedException ignore) {

        }
    }

    public void generateTexts(int count, int n)
    {
        var request = TextGeneratorRequest.newBuilder().setCount(count).build();

        IntStream.range(0, n).forEach(i -> generateTextsCallback(request));
    }
}
