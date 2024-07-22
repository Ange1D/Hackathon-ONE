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
            .members_id(membersDto.getMembers_id())
            .user(membersDto.getUser())
            .team_number(membersDto.getTeam_number())
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
    public void actualizarMembers(MembersDto membersDto, String name) {
        
        Optional<Member> optionalMember=  membersDao.findByUsername(name);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setMembers_id(membersDto.getMembers_id());
            member.setUser(membersDto.getUser());
            member.setTeam_number(membersDto.getTeam_number());
            membersDao.save(member);
            
        }
        else{
            System.out.println("No existe el miembro");
        }
    }

    @Override
    public boolean existsByname(String name) {
        // TODO Auto-generated method stub
        return membersDao.findByusername(name);

    }

    
}
