package com.example.demo.DAO.interfaces

import com.example.demo.model.FizPerson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Transactional
interface JPADao : JpaRepository<FizPerson,UUID> {
}