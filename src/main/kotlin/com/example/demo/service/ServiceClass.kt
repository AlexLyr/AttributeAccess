package com.example.demo.service

import com.example.demo.model.FizPerson

interface ServiceClass {
    fun saveWithJDBC(person:FizPerson):FizPerson

    fun saveWithJPA(person:FizPerson):FizPerson

    fun saveWithEM(person:FizPerson):FizPerson
}