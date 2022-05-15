package com.example.purpledogprj.member.service.impl;

import com.example.purpledogprj.member.mapper.MemberMapper;
import com.example.purpledogprj.member.service.MemberService;
import com.example.purpledogprj.member.vo.MemberVO;
import com.example.purpledogprj.member.vo.MessageVO;
import com.example.purpledogprj.member.vo.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public List<MemberVO> selectMemberList(MemberVO memberVO) {
        return memberMapper.selectMemberList(memberVO);
    }

    @Override
    public MessageVO insertMemberInfo(MemberVO memberVO) {
        MessageVO messageVO = new MessageVO();
        messageVO.setMemberVO(memberVO);
        if (memberMapper.selectMemberInfo(memberVO) != null) {
            messageVO.setStatus(Result.FAIL);
            messageVO.setMessage("중복된 아이디입니다.");
        } else {
            memberMapper.insertMemberInfo(memberVO);
            messageVO.setStatus(Result.SUCCESS);
            messageVO.setMessage("등록되었습니다.");
        }
        return messageVO;
    }

    @Override
    public MessageVO selectMemberInfo(MemberVO paramVO) {
        MessageVO messageVO = new MessageVO();
        MemberVO memberVO = memberMapper.selectMemberInfo(paramVO);
        if (memberVO == null) {
            messageVO.setStatus(Result.FAIL);
            messageVO.setMemberVO(paramVO);
            messageVO.setMessage("등록되지 않은 아이디입니다.");
        } else {
            messageVO.setStatus(Result.SUCCESS);
            messageVO.setMemberVO(memberVO);
            messageVO.setMessage("조회되었습니다.");
        }
        return messageVO;
    }

    @Override
    public MessageVO updateMemberInfo(MemberVO memberVO) {
        MessageVO messageVO = new MessageVO();
        messageVO.setMemberVO(memberVO);
        if (memberMapper.selectMemberInfo(memberVO) == null) {
            messageVO.setStatus(Result.FAIL);
            messageVO.setMessage("등록되지 않은 아이디입니다.");
        } else {
            memberMapper.updateMemberInfo(memberVO);
            messageVO.setStatus(Result.SUCCESS);
            messageVO.setMessage("비밀번호가 수정되었습니다.");
        }
        return messageVO;
    }

    @Override
    public MessageVO deleteMemberInfo(MemberVO paramVO) {
        MessageVO messageVO = new MessageVO();
        MemberVO memberVO = memberMapper.selectMemberInfo(paramVO);
        if (memberVO == null) {
            messageVO.setStatus(Result.FAIL);
            messageVO.setMemberVO(paramVO);
            messageVO.setMessage("등록되지 않은 아이디입니다.");
        } else if (!paramVO.getPassword().equals(memberVO.getPassword())) {
            messageVO.setStatus(Result.FAIL);
            messageVO.setMemberVO(paramVO);
            messageVO.setMessage("비밀번호가 틀렸습니다.");
        } else {
            messageVO.setStatus(Result.SUCCESS);
            memberMapper.deleteMemberInfo(paramVO);
            messageVO.setMessage("삭제되었습니다.");
        }
        return messageVO;
    }
}
