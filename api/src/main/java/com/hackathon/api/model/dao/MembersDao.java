package com.hackathon.api.model.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


import com.hackathon.api.model.entity.Member;


public interface MembersDao extends CrudRepository<Member, Long>{
    
    Optional<Member> findByUser(String user);

    boolean findByuser(String user);
}
