package com.example.purpledogprj.member.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class MemberVO {

    @NotBlank
    @Length(min = 4, max = 10)
    private String id;

    @NotBlank
    @Length(min = 4, max = 10)
    private String password;

}
