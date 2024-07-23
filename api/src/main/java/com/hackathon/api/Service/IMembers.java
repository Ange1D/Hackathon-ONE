package com.hackathon.api.Service;

import com.hackathon.api.model.dto.MembersDto;
import com.hackathon.api.model.entity.Member;
import java.util.List;

public interface IMembers {
    
    List<Member> listAll();

    Member save(MembersDto membersDto);
    
    void delete(Member members);

    boolean existsById(Long id);

    Member findMembers(Long id);

    void actualizarMembers(MembersDto membersDto, String name );

}
