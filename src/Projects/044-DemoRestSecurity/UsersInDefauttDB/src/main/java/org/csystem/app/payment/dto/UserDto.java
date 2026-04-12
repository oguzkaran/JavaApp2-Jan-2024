package org.csystem.app.payment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class UserDto {
    private String m_username;
    private String m_password;
    private String m_enabled;
    private String m_role;
    //...
}
