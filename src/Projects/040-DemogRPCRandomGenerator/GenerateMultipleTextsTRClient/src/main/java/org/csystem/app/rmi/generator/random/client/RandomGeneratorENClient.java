package org.csystem.app.rmi.generator.random.client;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.generator.random.RandomTextGeneratorServiceGrpc;
import org.csystem.generator.random.TextGenerateInfo;
import org.csystem.generator.random.TextInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

@Service
@Slf4j
public class RandomGeneratorENClient {
    @GrpcClient("random-generator-server")
    private RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceStub m_stub;

    private final RandomGenerator m_randomGenerator;

    @Value("${app.count}")
    private int m_count;

    private void requestCallback(StreamObserver<TextGenerateInfo> requestObserver)
    {
        var count = m_randomGenerator.nextInt(3, 10);

        log.info("Count:{}", count);

        requestObserver.onNext(TextGenerateInfo.newBuilder().setCount(count).build());
    }

    private StreamObserver<TextInfo> createResponseObserver()
    {
        return new StreamObserver<>() {
            @Override
            public void onNext(TextInfo textInfo)
            {
                log.info("Üretilen Yazı:{}", textInfo.getText());
            }

            @Override
            public void onError(Throwable throwable)
            {
                log.error("Hata oluştu:{}", throwable.getMessage());
            }

            @Override
            public void onCompleted()
            {
                log.info("Yazı üretimi tamamlandı");
            }
        };
    }

    public RandomGeneratorENClient(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    public void generateText()
    {
        var responseObserver = createResponseObserver();

        var requestObserver = m_stub.generateMultipleTextsTR(responseObserver);

        IntStream.range(0, m_count).forEach(i -> requestCallback(requestObserver));
        requestObserver.onCompleted();
    }
}
