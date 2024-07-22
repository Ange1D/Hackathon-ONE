package com.hackathon.api.model.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


import com.hackathon.api.model.entity.Member;


public interface MembersDao extends CrudRepository<Member, Long>{
    
    Optional<Member> findByUsername(String user);

    boolean findByusername(String username);
}
