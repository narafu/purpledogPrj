package com.example.purpledogprj.member.web;

import com.example.purpledogprj.member.service.MemberService;
import com.example.purpledogprj.member.vo.MemberVO;
import com.example.purpledogprj.member.vo.MessageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원 목록
    @GetMapping("/members")
    public List<MemberVO> selectMemberList(MemberVO memberVO) {
        return memberService.selectMemberList(memberVO);
    }

    // 회원 등록
    @PostMapping("/members")
    public MessageVO insertMemberInfo(@Validated MemberVO memberVO) {
        return memberService.insertMemberInfo(memberVO);
    }

    // 회원 조회
    @GetMapping("/members/{id}")
    public MessageVO selectMemberInfo(MemberVO memberVO) {
        return memberService.selectMemberInfo(memberVO);
    }

    // 회원 수정
    @PostMapping("/members/{id}")
    public MessageVO updateMemberInfo(@Validated MemberVO memberVO) {
        return memberService.updateMemberInfo(memberVO);
    }

    // 회원 삭제
    @DeleteMapping("members/{id}")
    public MessageVO deleteMemberInfo(@Validated MemberVO memberVO) {
        return memberService.deleteMemberInfo(memberVO);
    }

}
