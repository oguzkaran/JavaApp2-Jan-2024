package org.csystem.app.payment.server.manager.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RestPaymentServiceInfo extends PaymentServerInfo {
    @Accessors(prefix = "m_")
    private String m_endPoint;

    public RestPaymentServiceInfo(String id, String endPoint)
    {
        super(id);
        m_endPoint = endPoint;
    }

    @Override
    public String serverInfo()
    {
        return m_endPoint;
    }

    public String getId()
    {
        return id;
    }
}
