package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by daylinhenry on 7/5/17.
 */
@Entity

public class Job {

    @Id
    private int id;
    private String title;
    private String employer;
    private String salary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
