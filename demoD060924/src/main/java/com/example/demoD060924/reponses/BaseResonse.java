package com.example.demoD060924.reponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseResonse {
    @JsonProperty("create_at")
    private LocalDateTime createdAt;
    @JsonProperty("update_at")
    private LocalDateTime updatedAt;
}
