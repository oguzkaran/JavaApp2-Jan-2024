/*----------------------------------------------------------------------
	FILE        : CommandPrompt.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 25.02.2024

	General CommandPrompt class of REPL Framework

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.util.console;

import com.karandev.io.util.console.annotation.Command;
import com.karandev.io.util.console.annotation.ErrorCommand;
import lombok.Builder;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

@Builder
public final class CommandPrompt {
    @Accessors(prefix = "m_")
    private Object m_registerObject;

    private final ArrayList<CommandInfo> m_commandInfo = new ArrayList<>();

    @FieldNameConstants.Exclude
    private Method m_errorCommandMethod;

    @Setter
    @Accessors(prefix = "m_")
    @Builder.Default
    private String m_prompt = "krn";

    @Accessors(prefix = "m_")
    @Builder.Default
    private String m_suffix = "$";

    @Accessors(prefix = "m_")
    @Builder.Default
    private String m_paramStringErrorMessage = "Message parameters must be String!...";

    @Accessors(prefix = "m_")
    @Builder.Default
    private String m_wrongNumberOfArgumentsMessage = "Wrong number of arguments!...";

    @Accessors(prefix = "m_")
    @Builder.Default
    private String m_invalidCommand = "Invalid command!...";

    private static class CommandInfo {
        String commandText;
        Method method;
        int argCount;

        CommandInfo(String commandText, Method method, int argCount)
        {
            this.commandText = commandText;
            this.method = method;
            this.argCount = argCount;
        }
    }

    private boolean areAllString(Parameter [] parameters)
    {
        for (var param : parameters)
            if (param.getParameterizedType() != String.class)
                return false;

        return true;
    }

    private void runCommands(String [] cmdInfo) throws InvocationTargetException, IllegalAccessException
    {
        var params = Arrays.copyOfRange(cmdInfo, 1, cmdInfo.length);
        var flag = false;
        var argsFlag = false;

        for (var commandInfo : m_commandInfo)
            if (commandInfo.commandText.equals(cmdInfo[0])) {
                flag = true;
                argsFlag = true;

                if (commandInfo.argCount != params.length) {
                    argsFlag = false;
                    continue;
                }

                commandInfo.method.setAccessible(true);
                commandInfo.method.invoke(m_registerObject, (Object[]) params);
                commandInfo.method.setAccessible(false);
                break;
            }

        if (!flag) {
            if (m_errorCommandMethod != null) {
                m_errorCommandMethod.setAccessible(true);
                m_errorCommandMethod.invoke(m_registerObject);
                m_errorCommandMethod.setAccessible(false);
            }
            else
                Console.Error.writeLine(m_invalidCommand);
        }
        else if (!argsFlag)
            Console.Error.writeLine(m_wrongNumberOfArgumentsMessage);
    }

    private void registerCommands(Command [] commands, Method method)
    {
        for (var command : commands) {
            var value = command.value();
            var commandText = value.isBlank() ? method.getName() : value;
            var parameters = method.getParameters();

            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_paramStringErrorMessage);

            m_commandInfo.add(new CommandInfo(commandText, method, parameters.length));
        }
    }

    public CommandPrompt registerObject(Object regObject)
    {
        m_registerObject = regObject;
        var clsRegObject = m_registerObject.getClass();

        var methods = clsRegObject.getDeclaredMethods();

        for (var method : methods) {
            var commands = method.getDeclaredAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (m_errorCommandMethod == null && method.getDeclaredAnnotation(ErrorCommand.class) != null
                        && method.getTypeParameters().length == 0)
                    m_errorCommandMethod = method;
                continue;
            }
            registerCommands(commands, method);
        }

        return this;
    }


    public void run()
    {
        try {
            while (true) {
                var cmd = Console.read(m_prompt + m_suffix);

                if (cmd.isBlank())
                    continue;

                runCommands(cmd.split("[ \t]+"));
            }
        }
        catch (Throwable ex) {
            throw new IllegalArgumentException(ex.getMessage(), ex);
        }
    }
}
