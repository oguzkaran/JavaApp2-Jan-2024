package org.csystem.app.generator.random.server;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.csystem.generator.random.text.RandomTextGeneratorRequest;
import org.csystem.generator.random.text.RandomTextGeneratorResponse;
import org.csystem.generator.random.text.RandomTextGeneratorServiceGrpc;
import org.csystem.util.string.StringUtil;
import org.springframework.context.annotation.Scope;

import java.util.random.RandomGenerator;

@GrpcService
@Scope("prototype")
@Slf4j
public class RandomGeneratorServer extends RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceImplBase {
    private final RandomGenerator m_randomGenerator;

    public RandomGeneratorServer(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    @Override
    public void generateRandomTextEN(RandomTextGeneratorRequest request, StreamObserver<RandomTextGeneratorResponse> responseObserver)
    {
        var count = request.getCount();
        var text = StringUtil.generateRandomTextEN(m_randomGenerator, count);

        log.info("generateRandomTextEN:Count:{}, Text:{}", count, text);

        var response = RandomTextGeneratorResponse.newBuilder()
                .setText(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void generateRandomTextTR(RandomTextGeneratorRequest request, StreamObserver<RandomTextGeneratorResponse> responseObserver)
    {
        var count = request.getCount();
        var text = StringUtil.generateRandomTextTR(m_randomGenerator, count);

        log.info("generateRandomTextTR:Count:{}, Text:{}", count, text);

        var response = RandomTextGeneratorResponse.newBuilder()
                .setText(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
