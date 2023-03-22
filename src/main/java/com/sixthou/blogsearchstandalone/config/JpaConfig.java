package com.sixthou.blogsearchstandalone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.sixthou.blogsearchstandalone.domain")
@Configuration
public class JpaConfig {

}
