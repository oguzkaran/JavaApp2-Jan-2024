package org.csystem.app.rmi.generator.random.client;

import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.csystem.generator.random.Chunk;
import org.csystem.generator.random.RandomTextGeneratorServiceGrpc;
import org.csystem.generator.random.TextsFileGenerateInfo;
import org.csystem.generator.random.TextsGenerateInfo;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class RandomGeneratorENClient {
    @GrpcClient("random-generator-server")
    private RandomTextGeneratorServiceGrpc.RandomTextGeneratorServiceBlockingStub m_stub;

    private void saveDataCallback(Chunk chunk, BufferedOutputStream bos)
    {
        try {
            log.info("Size:{}", chunk.getSize());
            bos.write(chunk.getData().toByteArray());
        }
        catch (IOException ex) {
            log.error("IO Error: {}", ex.getMessage());
        }
    }

    public void generateTexts(int count, int n, String fileName)
    {
        var info = TextsFileGenerateInfo.newBuilder()
                .setCount(count)
                .setN(n).setFileName(fileName)
                .build();

        try (var bos = new BufferedOutputStream(new FileOutputStream(fileName))){
            var chunks = m_stub.generateTextsFileEN(info);

            chunks.forEachRemaining(c -> saveDataCallback(c, bos));
        }
        catch (IOException ex) {
            log.error("IO Error: {}", ex.getMessage());
        }
        catch (StatusRuntimeException ex) {
            log.error("Error:{}, {}", ex.getStatus(), ex.getMessage());
        }
        catch (Exception ex) {
            log.error("Error: {}", ex.getMessage());
        }
    }
}
