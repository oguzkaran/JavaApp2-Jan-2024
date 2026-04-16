package org.csystem.app.payment.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class UserRoleDto {
    private String m_username;
    private String m_role;
    //...
}
