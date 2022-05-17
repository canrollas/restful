package com.G01.onlineFishAuction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponseDTO {
    private String response;
    private String status;

}
