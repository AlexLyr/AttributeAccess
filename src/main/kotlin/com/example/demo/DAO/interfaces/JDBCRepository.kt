package com.example.demo.DAO.interfaces

import com.example.demo.model.FizPerson

interface JDBCRepository {

    fun save(person: FizPerson):FizPerson
}