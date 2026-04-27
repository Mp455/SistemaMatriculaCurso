package com.sistemaCurso.model;

import java.time.LocalDate;

public class Course {
    private Long id;
    private String name;
    private LocalDate createDate;

    public Course(Long id, String name, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
