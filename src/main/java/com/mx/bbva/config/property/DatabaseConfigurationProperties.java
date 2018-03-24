package com.mx.bbva.config.property;

import org.springframework.core.env.Environment;

public abstract class DatabaseConfigurationProperties {

    public String getDriverClassName() {
        return getEnvironment().getProperty("spring.datasource.driver-class-name");
    }

    public String getUrl() {
        return getEnvironment().getProperty("spring.datasource.url");
    }

    public String getUsername() {
        return getEnvironment().getProperty("spring.datasource.username");
    }

    public String getPassword() {
        return getEnvironment().getProperty("spring.datasource.password");
    }

    protected abstract Environment getEnvironment();

}
