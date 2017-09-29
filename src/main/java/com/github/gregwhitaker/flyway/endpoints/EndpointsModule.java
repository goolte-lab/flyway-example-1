package com.github.gregwhitaker.flyway.endpoints;

import com.google.inject.AbstractModule;

public class EndpointsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EmployeeEndpoint.class);
    }
}
