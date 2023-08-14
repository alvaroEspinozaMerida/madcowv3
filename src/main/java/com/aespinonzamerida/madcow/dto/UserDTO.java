package com.aespinonzamerida.madcow.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private double[] weights;
    private int[] reps ;

}
