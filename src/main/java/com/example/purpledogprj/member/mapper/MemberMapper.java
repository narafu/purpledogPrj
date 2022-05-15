package com.example.purpledogprj.member.mapper;

import com.example.purpledogprj.member.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberVO> selectMemberList(MemberVO memberVO);

    void insertMemberInfo(MemberVO memberVO);

    MemberVO selectMemberInfo(MemberVO memberVO);

    void updateMemberInfo(MemberVO memberVO);

    void deleteMemberInfo(MemberVO memberVO);
}
