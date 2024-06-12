package org.csystem.app.payment.server.manager.client.factory;

import org.csystem.app.payment.server.manager.client.PaymentServerInfo;
import org.csystem.app.payment.server.manager.client.RestPaymentServiceInfo;
import org.csystem.app.payment.server.manager.client.SocketPaymentServerInfo;

import java.util.Optional;

public class PaymentServerFactory {
    //...
    private Optional<PaymentServerInfo> socketServerCallback(int id, String host, String[] info)
    {
        try {
            return Optional.of(new SocketPaymentServerInfo(id, host, Integer.parseInt(info[1])));
        }
        catch (NumberFormatException | IndexOutOfBoundsException ex) {
            return Optional.empty();
        }
    }

    private Optional<PaymentServerInfo> restServiceCallback(int id, String [] info)
    {
        try {
            return Optional.of(new RestPaymentServiceInfo(id, info[1]));
        }
        catch (IndexOutOfBoundsException ex) {
            return Optional.empty();
        }
    }


    private Optional <PaymentServerInfo> protocolCallback(int id, String host, String [] info)
    {
        return switch (info[0]) {
            case "S" -> socketServerCallback(id, host, info);
            case "R" -> restServiceCallback(id, info);
            default -> Optional.empty();
        };
    }
    public Optional<PaymentServerInfo> create(int id, String host, String infoStr)
    {
        //S;2323
        //R:http://......
        //G:
        //info'ların ilgili bilgileri kontrol edilecektir
        var info = infoStr.split("[;]");

        return info.length >= 2 ? protocolCallback(id, host, info) : Optional.empty();
    }
}
