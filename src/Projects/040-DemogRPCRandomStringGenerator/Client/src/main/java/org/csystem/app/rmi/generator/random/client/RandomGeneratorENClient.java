package org.csystem.app.rmi.generator.random.client;

import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.generator.random.RandomTextGeneratorServiceGrpc;
import org.csystem.generator.random.TextsGenerateInfo;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RandomGeneratorENClient {
    @GrpcClient("random-generator-server")
    private RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceBlockingStub m_stub;

    public void generateTexts(int count, int n)
    {
        var info = TextsGenerateInfo.newBuilder().setCount(count).setN(n).build();

        try {
            var texts = m_stub.generateTextsEN(info);

            texts.forEachRemaining(s -> log.info("Text:{}", s));
        }
        catch (StatusRuntimeException ex) {
            log.error("Error:{}, {}", ex.getStatus(), ex.getMessage());
        }
    }
}
