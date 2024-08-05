package org.csystem.app.rmi.generator.random.component;

import lombok.extern.slf4j.Slf4j;
import org.csystem.rmi.generator.random.text.IRandomTextGenerator;
import org.csystem.util.string.StringUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
import java.util.random.RandomGenerator;

@Component
@Slf4j
public class RandomTextGenerator implements IRandomTextGenerator {
    private final RandomGenerator m_randomGenerator;

    public RandomTextGenerator(RandomGenerator randomGenerator)
    {
        m_randomGenerator = randomGenerator;
    }

    @Override
    public synchronized String generateRandomTextEN(int count) throws RemoteException
    {
        try {
            var text = StringUtil.generateRandomTextEN(m_randomGenerator, count);

            log.info("TextEN:{}", text);

            return text;
        }
        catch (NegativeArraySizeException ex) {
            log.error("NegativeArraySizeException:{}", ex.getMessage());
            throw new RemoteException(ex.getMessage());
        }
    }

    @Override
    public synchronized String generateRandomTextTR(int count)
    {
        var text = StringUtil.generateRandomTextTR(m_randomGenerator, count);

        log.info("TextTR:{}", text);

        return text;
    }
}
