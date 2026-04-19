package org.csystem.app.payment.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class RegisterDto {
    private String m_username;
    private String m_password;
    private String m_confirmPassword;
    private String m_email; //not checked fpr validation in demo
    private String m_birthDate; //yyyy-MM-dd
    //...
}
