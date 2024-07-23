package com.hackathon.api.Service.impl;

import java.util.List;

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.hackathon.api.Service.IMembers;
import com.hackathon.api.model.dao.MembersDao;
import com.hackathon.api.model.dto.MembersDto;
import com.hackathon.api.model.entity.Member;
import java.util.Optional;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MembersImp implements IMembers {
    @Autowired
    private MembersDao membersDao;

    @Override
    public List<Member> listAll() {
        return (List<Member>) membersDao.findAll();
    }

    @Transactional
    @Override
    public Member save(MembersDto membersDto) {
        Member member = Member.builder()
            .user(membersDto.getUser())
            .team(membersDto.getTeam())
            .build();
        return membersDao.save(member);

    }

    @Override
    public void delete(Member members) {
        membersDao.delete(members);
    }

    @Override
    public boolean existsById(Long id) {
        return membersDao.existsById(id);
    }

    @Override
    public Member findMembers(Long id) {
        return membersDao.findById(id).orElse(null);
    }

    @Override
    public void actualizarMembers(MembersDto membersDto, String id) {
        
        Optional<Member> optionalMember=  membersDao.findById(Long.parseLong(id));

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setUser(membersDto.getUser());
            member.setTeam(membersDto.getTeam());
            membersDao.save(member);
            
        }
        else{
            System.out.println("No existe el miembro");
        }
    }

    
}
