package com.boram.life.login;

import com.boram.life.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = false)
public class LoginRepository {

    @PersistenceContext
    private EntityManager em;

    public Member findMember(Long memberId){
        return em.find(Member.class, memberId);
    }

    @Transactional
    public void save(Member member){
        em.persist(member);
    }
}
