package com.github.gregwhitaker.flyway.endpoints;

import com.github.gregwhitaker.flyway.services.EmployeeService;
import ratpack.func.Action;
import ratpack.handling.Chain;

import javax.inject.Inject;

import static ratpack.jackson.Jackson.json;

/**
 * Rest endpoints for the application.
 */
public class EmployeeEndpoint implements Action<Chain> {

    @Inject
    private EmployeeService service;

    @Override
    public void execute(Chain chain) throws Exception {
        // Pre-Migration
        chain.get("employees1", ctx -> {
            service.getEmployees1().then(employees -> ctx.render(json(employees)));
        });

        // Post-Migration
        chain.get("employees2", ctx -> {
            service.getEmployees2().then(employees -> ctx.render(json(employees)));
        });
    }
}
