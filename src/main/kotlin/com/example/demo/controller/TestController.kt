package com.example.demo.controller

import com.example.demo.model.FizPerson
import com.example.demo.service.ServiceClass
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@RequestMapping(path = ["test/"])
@Controller
@CrossOrigin
@Api(tags = ["Тестовый контроллер"])
class TestController(val service: ServiceClass) {

    @GetMapping()
    fun testGet(): ResponseEntity<Any> {
        return ResponseEntity("Hello", HttpStatus.OK)
    }

    @ApiOperation("Сохранить через спринг JDBC")
    @PostMapping(path = ["jdbc/"])
    fun saveWithJDBC(@RequestBody person: FizPerson):ResponseEntity<FizPerson> {
        return ResponseEntity(service.saveWithJDBC(person),HttpStatus.OK)
    }

    @ApiOperation("Сохранить через Спринг JPA")
    @PostMapping(path = ["jpa/"])
    fun saveWithSpringDataJPA(@RequestBody person: FizPerson): ResponseEntity<FizPerson> {
        return ResponseEntity(service.saveWithJPA(person),HttpStatus.OK)
    }

    @ApiOperation("Сохранить через EntityManager")
    @PostMapping(path = ["em/"])
    fun saveWithEntityManager(@RequestBody person: FizPerson):ResponseEntity<FizPerson> {
        return ResponseEntity(service.saveWithEM(person),HttpStatus.OK)
    }
}