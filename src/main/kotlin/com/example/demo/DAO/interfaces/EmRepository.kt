package com.example.demo.DAO.interfaces

import com.example.demo.model.FizPerson

interface EmRepository {

    fun save(person:FizPerson):FizPerson
}
