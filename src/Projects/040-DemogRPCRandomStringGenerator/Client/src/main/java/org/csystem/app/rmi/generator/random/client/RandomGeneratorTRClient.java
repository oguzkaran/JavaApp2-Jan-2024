package org.csystem.app.rmi.generator.random.client;

import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.generator.random.text.NoParam;
import org.csystem.generator.random.text.RandomTextGeneratorServiceGrpc;
import org.csystem.generator.random.text.TextGeneratorRequest;
import org.springframework.stereotype.Service;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

@Service
@Slf4j
public class RandomGeneratorTRClient {
    @GrpcClient("random-generator-server")
    private RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceBlockingStub m_stub;

    private final RandomGenerator m_randomGenerator;

    private void generateTextsCallback(TextGeneratorRequest request)
    {
        try {
            var response = m_stub.generateTextTR(request);

            log.info("Yazı:{}", response.getText());
            Thread.sleep(300);
        }
        catch (StatusRuntimeException ex) {
            log.error("Hata:{}, {}", ex.getStatus(), ex.getMessage());
        }
        catch (InterruptedException ignore) {

        }
    }

    public RandomGeneratorTRClient(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public void generateTexts(int n)
    {
        var boundRequest = NoParam.newBuilder().build();

        var bound = m_stub.getBound(boundRequest);
        var minCount = bound.getMinCount();
        var maxCount = bound.getMaxCount();
        var count = m_randomGenerator.nextInt(minCount, maxCount + 1);
        var request = TextGeneratorRequest.newBuilder().setCount(count).build();

        log.info("Min:{}, Max:{}, Generated Count:{}",minCount, maxCount, count);

        IntStream.range(0, n).forEach(i -> generateTextsCallback(request));
    }
}
