package com.example.gallery.backend.repository;

import com.example.gallery.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member,Integer>{

    Member findByEmailAndPassword(String email, String password);

}
