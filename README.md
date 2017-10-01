# flyway-example
An example of using [Flyway](https://flywaydb.org/) to manage the versioning and migration of your relational database
schemas.

## Running the Example
1. Start the application by running the following Gradle command:

        $ ./gradlew run

2. Call the `v1/employees` endpoint using the following curl command:

        $ curl http://localhost:5050/v1/employees
        
    You will see that three employee records are returned:
    
        [
          {
            "id": 1,
            "firstName": "Bob",
            "lastName": "Smith"
          },
          {
            "id": 2,
            "firstName": "Jane",
            "lastName": "Doe"
          },
          {
            "id": 3,
            "firstName": "Sally",
            "lastName": "Ann"
          }
        ]

3. Call the `v2/employees` endpoint using the following curl command:

        $ curl http://localhost:5050/v2/employees
        
    You will see a database error indicating that the `PHONE_NUMBER` column does not exist:
    
        org.h2.jdbc.JdbcSQLException: Column "PHONE_NUMBER" not found [42122-186]
    
## Bugs and Feedback
For bugs, questions and discussions please use the [Github Issues](https://github.com/gregwhitaker/flyway-example/issues).

## License

MIT License

Copyright (c) 2017 Greg Whitaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.