package com.example.demo.bodyadvice

import org.springframework.http.converter.HttpMessageConverter
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice
import org.springframework.web.bind.annotation.ControllerAdvice


@ControllerAdvice
class CustomResponseBodyFilter : ResponseBodyAdvice<List<*>> {

    override fun supports(returnType: MethodParameter, converterType: Class<out HttpMessageConverter<*>>): Boolean {
        return true
    }

    override fun beforeBodyWrite(p0: List<*>?, p1: MethodParameter, p2: MediaType, p3: Class<out HttpMessageConverter<*>>, p4: ServerHttpRequest, p5: ServerHttpResponse): List<*>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}