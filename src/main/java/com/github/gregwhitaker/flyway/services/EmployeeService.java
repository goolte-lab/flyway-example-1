package com.github.gregwhitaker.flyway.services;

import com.github.gregwhitaker.flyway.model.Employee;
import ratpack.exec.Blocking;
import ratpack.exec.Promise;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Example service that retrieves employee info from the database.
 */
public class EmployeeService {

    @Inject
    private DataSource dataSource;

    /**
     * Call this method pre-migration to get the list of employees.
     *
     * @return list of employees
     */
    public Promise<List<Employee>> getEmployees1() {
        return Blocking.get(() -> {
            try (Connection connection = dataSource.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE;");
                ResultSet resultSet =  statement.executeQuery();

                List<Employee> employees = new ArrayList<>();

                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getLong("ID"));
                    employee.setFirstName(resultSet.getString("FIRST_NAME"));
                    employee.setLastName(resultSet.getString("LAST_NAME"));

                    employees.add(employee);
                }

                return employees;
            }
        });
    }

    /**
     * Call this method post-migration to simulate that you have made a code change to get the phone number
     * of the employees.
     *
     * @return list of employees
     */
    public Promise<List<Employee>> getEmployees2() {
        return Blocking.get(() -> {
            try (Connection connection = dataSource.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE;");
                ResultSet resultSet =  statement.executeQuery();

                List<Employee> employees = new ArrayList<>();

                while (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setId(resultSet.getLong("ID"));
                    employee.setFirstName(resultSet.getString("FIRST_NAME"));
                    employee.setLastName(resultSet.getString("LAST_NAME"));
                    employee.setPhoneNumber(resultSet.getLong("PHONE_NUMBER"));

                    employees.add(employee);
                }

                return employees;
            }
        });
    }
}
