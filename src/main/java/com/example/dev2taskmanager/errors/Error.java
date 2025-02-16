package com.example.dev2taskmanager.errors;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Error implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("message")
    private String message;

    @JsonProperty("code")
    private Integer code;

    private String timestamp;

}
