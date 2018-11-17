package com.example.demo.DAO

import com.example.demo.DAO.interfaces.JDBCRepository
import com.example.demo.model.FizPerson
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
class JDBCRepositoryImpl(val jdbcTemplate: JdbcTemplate) : JDBCRepository {

    @Transactional
    override fun save(person: FizPerson): FizPerson {
        val uuid = UUID.randomUUID()
        person.id = uuid
        val sql = "INSERT INTO public.organization_fl(\n" +
                "\tid, date_given, first_name, fl_address_fact, fl_address_post, fl_birth_date, fl_birth_place, fl_email," +
                " fl_inn, fl_inn_address, fl_inn_date, fl_inn_place, fl_phone, fl_sex, " +
                "fl_snils, last_name, passport_num, passport_ser, place_given, second_name)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"
        jdbcTemplate.update(sql,
                person.id,
                person.dateGiven,
                person.firstName,
                person.flAddressFact,
                person.flAddressPost,
                person.flBirthDate,
                person.flBirthPlace,
                person.flEmail,
                person.flInn,
                person.flInnAddress,
                person.flInnDate,
                person.flInnPlace,
                person.flPhone,
                person.flSex,
                person.flSnils,
                person.lastName,
                person.passportNum,
                person.passportSer,
                person.placeGiven,
                person.secondName)
        return person
    }
}