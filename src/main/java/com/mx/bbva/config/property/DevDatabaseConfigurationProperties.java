package com.mx.bbva.config.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-dev.properties")
@Profile("devserversql")
public class DevDatabaseConfigurationProperties extends DatabaseConfigurationProperties {

    @Autowired
    private Environment environment;

    @Override
    protected Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) { this.environment = environment; }

}
