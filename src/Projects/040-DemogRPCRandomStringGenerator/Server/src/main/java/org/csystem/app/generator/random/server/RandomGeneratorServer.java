package org.csystem.app.generator.random.server;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.csystem.generator.random.text.*;
import org.csystem.util.grpc.error.GrpcErrorUtil;
import org.csystem.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import java.util.random.RandomGenerator;

@GrpcService
@Scope("prototype")
@Slf4j
public class RandomGeneratorServer extends RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceImplBase {
    private final RandomGenerator m_randomGenerator;

    @Value("${grpc.server.minCount}")
    private int m_minCount;

    @Value("${grpc.server.maxCount}")
    private int m_maxCount;

    public RandomGeneratorServer(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    @Override
    public void generateTextEN(TextGeneratorRequest request, StreamObserver<TextGeneratorResponse> responseObserver)
    {
        var count = request.getCount();

        log.info("Count:{}", count);

        if (count <= 0) {
            GrpcErrorUtil.invalidArgumentError(responseObserver, "Count must be positive");
            return;
        }

        if (count > m_maxCount) {
            GrpcErrorUtil.outOfRangeError(responseObserver, "Count can not be greater than %d".formatted(m_maxCount));
            return;
        }
        var text = StringUtil.generateRandomTextEN(m_randomGenerator, count);

        log.info("generateRandomTextEN:Count:{}, Text:{}", count, text);

        var response = TextGeneratorResponse.newBuilder()
                .setText(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void generateTextTR(TextGeneratorRequest request, StreamObserver<TextGeneratorResponse> responseObserver)
    {
        var count = request.getCount();

        log.info("Count:{}", count);

        if (count <= 0) {
            GrpcErrorUtil.asRuntimeException(responseObserver, Status.INVALID_ARGUMENT, "Count değeri pozitif olmalıdır");
            return;
        }

        if (count > m_maxCount) {
            GrpcErrorUtil.asRuntimeException(responseObserver,
                    Status.OUT_OF_RANGE, "Count %d değerinden büyük olmamalıdır".formatted(m_maxCount));
        }
        var text = StringUtil.generateRandomTextTR(m_randomGenerator, count);

        log.info("generateRandomTextTR:Count:{}, Text:{}", count, text);

        var response = TextGeneratorResponse.newBuilder()
                .setText(text).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getBound(NoParam request, StreamObserver<TextBound> responseObserver)
    {
        var bound = TextBound.newBuilder().setMaxCount(m_maxCount).setMinCount(m_minCount).build();

        responseObserver.onNext(bound);
        responseObserver.onCompleted();
    }
}
