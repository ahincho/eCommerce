package com.brecom.ecommerce.users.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
