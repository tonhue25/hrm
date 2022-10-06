package com.hrm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private List<String> roles;
    private String name;

    public JwtResponse(String token, List<String> roles, String name) {
        this.token = token;
        this.roles = roles;
        this.name = name;
    }
}
