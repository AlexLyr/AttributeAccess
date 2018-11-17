package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.io.Serializable
import java.time.LocalDate
import java.util.*
import javax.persistence.*
/**
 * Модель DTO Модель справочник организации Физ лица
 *
 * @author lomov
 * @since 22.10.2018
 */

@ApiModel("Модель DTO Модель справочник организации Физ лица")
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
@Table(name = "organization_fl")
class FizPerson (

        /**
         * Идентификатор
         */
        @Id
        @ApiModelProperty("Идентификатор")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: UUID? = null,

        /**
         * Фамилия
         */
        @ApiModelProperty("Фамилия")
        @Column(name = "first_name")
        var firstName: String? = null,

        /**
         * Имя
         */
        @ApiModelProperty("Имя")
        @Column(name = "last_name")
        var lastName: String? = null,

        /**
         * Отчество
         */
        @ApiModelProperty("Отчество")
        @Column(name = "second_name")
        var secondName: String? = null,

        /**
         * ИНН
         */
        @ApiModelProperty("ИНН")
        @Column(name = "fl_inn")
        var flInn: String? = null,

        /**
         * Организация, выдавшая ИНН
         */
        @ApiModelProperty("Организация, выдавшая ИНН")
        @Column(name = "fl_inn_place")
        var flInnPlace: String? = null,

        /**
         * Адрес органа, выдавшего ИНН
         */
        @ApiModelProperty("Адрес органа, выдавшего ИНН")
        @Column(name = "fl_inn_address")
        var flInnAddress: String? = null,

        /**
         * Дата выдачи ИНН
         */
        @ApiModelProperty("Дата выдачи ИНН")
        @Column(name = "fl_inn_date")
        var flInnDate: LocalDate? = null,

        /**
         * СНИЛС
         */
        @ApiModelProperty("СНИЛС")
        @Column(name = "fl_snils")
        var flSnils: String? = null,

        /**
         * Серия паспорта
         */
        @ApiModelProperty("Серия паспорта")
        @Column(name = "passport_ser")
        var passportSer: String? = null,

        /**
         * Номер паспорта
         */
        @ApiModelProperty("Номер паспорта")
        @Column(name = "passport_num")
        var passportNum: String? = null,

        /**
         * Дата выдачи
         */
        @ApiModelProperty("Дата выдачи")
        @Column(name = "date_given")
        var dateGiven: LocalDate? = null,

        /**
         * Место выдачи
         */
        @ApiModelProperty("Место выдачи")
        @Column(name = "place_given")
        var placeGiven: String? = null,

        /**
         * Пол
         */
        @ApiModelProperty("Пол")
        @Column(name = "fl_sex")
        var flSex: String? = null,

        /**
         * Дата рождения
         */
        @ApiModelProperty("Дата рождения")
        @Column(name = "fl_birth_date")
        var flBirthDate: LocalDate? = null,

        /**
         * Место рождения
         */
        @ApiModelProperty("Место рождения")
        @Column(name = "fl_birth_place")
        var flBirthPlace: String? = null,

        /**
         * Почтовый адрес
         */
        @ApiModelProperty("Почтовый адрес")
        @Column(name = "fl_address_post")
        var flAddressPost: String? = null,

        /**
         * Адрес проживания
         */
        @ApiModelProperty("Адрес проживания")
        @Column(name = "fl_address_fact")
        var flAddressFact: String? = null,

        /**
         * Электронна почта
         */
        @ApiModelProperty("Электронна почта")
        @Column(name = "fl_phone")
        var flPhone: String? = null,

        /**
         * Электронна почта
         */
        @ApiModelProperty("Электронна почта")
        @Column(name = "fl_email")
        var flEmail: String? = null

) : Serializable