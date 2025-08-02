package com.application.minipocket;

public class Vacancy {
    private int id;
    private String jobPost;
    private String companyName;
    private String location;
    private String salary;
    private String description;
    private String email;

    public Vacancy(int id, String jobPost, String companyName, String location, String salary, String description, String email) {
        this.id = id;
        this.jobPost = jobPost;
        this.companyName = companyName;
        this.location = location;
        this.salary = salary;
        this.description = description;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobPost() {
        return jobPost;
    }

    public void setJobPost(String jobPost) {
        this.jobPost = jobPost;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

