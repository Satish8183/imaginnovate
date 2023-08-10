package com.satish.imaginnovate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @ElementCollection
    private List<String> phoneNumbers = new ArrayList<>();

    @NotNull
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of joining must be in yyyy-MM-dd format")
    private String doj;

    @NotNull
    private Double salary;

}
