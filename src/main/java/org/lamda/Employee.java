package org.lamda;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Data;

@Data
@AllArgsConstructor
@ToString
public class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
}