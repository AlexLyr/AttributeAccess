package com.example.demo.conf

import com.ursip.dsproxy.entry.DatasourceProxyBeanPostProcessor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatasourceProxyConfig {
    @Bean
    fun getDatasurcePostProcessor(): DatasourceProxyBeanPostProcessor {
        return DatasourceProxyBeanPostProcessor()
    }

}