package com.example.demo.DAO

import com.example.demo.DAO.interfaces.EmRepository
import com.example.demo.model.FizPerson
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
@Transactional(readOnly = true)
class EmRepositoryImpl : EmRepository {

    @PersistenceContext
    private lateinit var em: EntityManager

    @Transactional
    override fun save(person: FizPerson): FizPerson {
        em.persist(person)
        return person
    }
}