package com.github.gregwhitaker.flyway;

import com.github.gregwhitaker.flyway.endpoints.EmployeeEndpoint;
import com.github.gregwhitaker.flyway.endpoints.EndpointsModule;
import com.github.gregwhitaker.flyway.services.ServicesModule;
import ratpack.guice.Guice;
import ratpack.hikari.HikariModule;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Starts the Flyway Example Application.
 */
public class Main {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c
                        .baseDir(BaseDir.find()).build())
                .registry(Guice.registry(b -> b
                        .module(HikariModule.class, config -> {
                            config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
                            config.setConnectionTestQuery("VALUES 1");
                            config.addDataSourceProperty("URL", "jdbc:h2:./build/database");
                            config.addDataSourceProperty("user", "sa");
                            config.addDataSourceProperty("password", "sa");
                        })
                        .module(EndpointsModule.class)
                        .module(ServicesModule.class))
                )
                .handlers(chain -> chain
                        .insert(EmployeeEndpoint.class)
                )
        );
    }
}
