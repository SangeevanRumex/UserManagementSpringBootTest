package com.example.UserManagementSpringBoot.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @ApiModelProperty(notes = "Id of the user")
    private int id;

    @ApiModelProperty(notes = "Name of the user")
    private String userName;

    @ApiModelProperty(notes = "City of the user")
    private String city;
}
