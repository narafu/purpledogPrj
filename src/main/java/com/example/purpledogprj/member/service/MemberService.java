package com.example.purpledogprj.member.service;

import com.example.purpledogprj.member.vo.MemberVO;
import com.example.purpledogprj.member.vo.MessageVO;

import java.util.List;

public interface MemberService {
    List<MemberVO> selectMemberList(MemberVO memberVO);

    MessageVO insertMemberInfo(MemberVO memberVO);

    MessageVO selectMemberInfo(MemberVO memberVO);

    MessageVO updateMemberInfo(MemberVO memberVO);

    MessageVO deleteMemberInfo(MemberVO memberVO);
}
