package com.example.demo.bodyadvice

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.core.MethodParameter
import org.springframework.http.HttpInputMessage
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter
import java.lang.reflect.Type


@ControllerAdvice
class CustomRequestBodyAdviceAdapter : RequestBodyAdviceAdapter() {
    override fun supports(p0: MethodParameter, p1: Type, p2: Class<out HttpMessageConverter<*>>): Boolean {
       return true
    }

    override fun afterBodyRead(body: Any, inputMessage: HttpInputMessage, parameter: MethodParameter,
                      targetType: Type, converterType: Class<out HttpMessageConverter<*>>): Any {

        // write body -your input dto- to logs or database or whatever

        return body
    }
}