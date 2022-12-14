package com.whale.challenge.module.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Profile("master")
@Configuration
@EnableJpaAuditing
public class AuditConfig {
    
}
