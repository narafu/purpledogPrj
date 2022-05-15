package com.example.purpledogprj.member.vo;

import lombok.Data;

@Data
public class MessageVO {

    private Result status;
    private String message;
    private MemberVO memberVO;

}
