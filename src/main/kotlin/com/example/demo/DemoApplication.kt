package com.example.demo

import com.ursip.dsproxy.entry.DatasourceProxyBeanPostProcessor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication(scanBasePackages = ["com.example.demo"])
@EnableAspectJAutoProxy
class DemoApplication


fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}



