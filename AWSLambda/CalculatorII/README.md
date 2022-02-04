## Calculator II 
### Overview

Calculator II is an application that performs simple mathematical operations on BigDecimal 
Scalar, Vectors, and Complex Scalars via AWS Lambda service and Amazon Cloudwatch. This is 
a fully functional reiteration of the previous scraped Calculator project that emphasized 
a simple use case for the AWS Lambda service. 

Calculator II emphasizes for a more proper design approach of an Object-Oriented calculator
that allows some scalability of the Vector class while improving on the accuracy of the Data 
Model of each class. 

### Objectives:

- Improve the Object-Oriented design approach in implementing a Value Calculator using SOLID Principles
  - Operand types are defined appropriately with Encapsulation with a Composition over Inheritance bias
  - Ensure Inheritance and Interfaces are implemented appropriately to define subtypes where appropriate
- Test with Junit Unit Testing Framework and Mocking with the Mockito Framework where appropriate
- Implement the Calculator for AWS Lambda service and ensure result logs with Amazon Cloudwatch

### Conclusion:

The operand Types were completed redesigned to incorporate distinct types and subtypes instead 
of a single Value type and a separate Operator Enum that would define the operational behavior of 
the Value as in the predecessor project satisfying the Single Responsibility Principle.

The Value types instead now inherits a Value interface with common behavior between all Value 
types while defining any new unique behaviors or members for each respective Value type when 
needed, satisfying the Open-Closed Principle, the Liskov Substitution Principle, and the
Interface Segregation Principle.



