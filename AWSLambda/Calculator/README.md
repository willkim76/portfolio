## Calculator Overview
Calculator is an application that performs simple operations on BigDecimal Scalars, 2D Vectors, and Complex
Numbers via AWS Lambda service. The Object-Oriented approach segments objects into Values, Operators, Expressions,
and Equations. The number of arguments used in instantiating a Value object determines whether the Operand
is a Scalar, a 2D Vector, or a Complex Number. (Please refer to the concept.puml file for the visual diagram.)

A JSON object representing an Expression which contains String representations of the Value operands as well
as the Operator are passed into the AWS Lambda terminal. (Examples can be found in the expression.json file) 
The function then returns an Equation.

### Objectives:

    - Use Object Oriented design approach in implementing a Value Calculator
    - Implement the Application for a servicable AWS Lambda function

### Conclusion:
Both objectives were met. The design of the Calculator was somewhat trivial but there could be improvements
to the design such as explicitly delineating the different Value types using inheritance. The Design may also 
violate OOP principles in its current state. However, the main concern was to learn the AWS Lambda service 
as well as implementing Lambda functions from scratch. 
