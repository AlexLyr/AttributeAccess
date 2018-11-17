package com.example.demo.service

import com.example.demo.DAO.interfaces.EmRepository
import com.example.demo.DAO.interfaces.JDBCRepository
import com.example.demo.DAO.interfaces.JPADao
import com.example.demo.model.FizPerson
import org.springframework.stereotype.Service


@Service
class ServiceClassImpl(val jpaDao: JPADao, val emDao: EmRepository, val jdbcRepository: JDBCRepository) : ServiceClass {

    override fun saveWithJDBC(person: FizPerson):FizPerson {
       return jdbcRepository.save(person)
    }

    override fun saveWithJPA(person: FizPerson): FizPerson {
        return jpaDao.save(person)
    }


    override fun saveWithEM(person: FizPerson): FizPerson {
        return emDao.save(person)
    }
}