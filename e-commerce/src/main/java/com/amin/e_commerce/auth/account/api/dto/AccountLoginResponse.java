    package com.amin.e_commerce.auth.account.api.dto;

    import com.amin.e_commerce.security.jwt.JwtResponse;
    import com.fasterxml.jackson.annotation.JsonProperty;
    import lombok.*;
    import lombok.experimental.SuperBuilder;

    import java.util.List;

    @Getter
    @SuperBuilder
    public class AccountLoginResponse {


        @JsonProperty("account_info")
        private AccountInfo account;

        @JsonProperty("token_info")
        private JwtResponse token;




        @Getter
        @SuperBuilder
        public static class AccountInfo {

            private String username;

            @JsonProperty("account_code")
            private String accountCode;

            private List<String> roles;

            private List<String> permissions;
        }
    }