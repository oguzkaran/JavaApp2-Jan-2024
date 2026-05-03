package org.csystem.app.payment.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private String m_username;
    private String m_email;
    private String m_password;
    private String m_confirmPassword;
    private String m_birthDate;
    @Builder.Default
    private ArrayList<String> m_roles = new ArrayList<>();
    //...
}
