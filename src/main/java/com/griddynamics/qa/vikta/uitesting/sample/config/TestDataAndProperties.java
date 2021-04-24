package com.griddynamics.qa.vikta.uitesting.sample.config;

import org.aeonbits.owner.Config;

// If you are curious - http://owner.aeonbits.org/docs/singleton/
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:env",
        "system:properties",
        "classpath:app.properties"})
public interface TestDataAndProperties extends Config {
    int implicitlyWait();
    int pageLoadTimeout();

    int waitTimeout();

    String baseHost();
    String basePort();
    String baseUrl();

    String loginPageUrl();
    String registrationPageUrl();
    String adminAddCategoryPageUrl();
    String adminCreateUserPageUrl();
    String adminAddImagePageUrl();

    String adminName();
    String adminPassword();

    String userName();
    String userPassword();
}
