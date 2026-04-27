package com.sistemaCurso.service;

import com.sistemaCurso.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseService {
    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Long id, String name, LocalDate createCourseDate){
        boolean verifyId = courseList.stream().anyMatch(c -> c.getId().equals(id));
        boolean verifyName = courseList.stream().anyMatch(c -> c.getName().equals(name));
        if(verifyName || verifyId){
            System.out.println("Já existe esse curso cadastrado ao sistema!");
        }else{
            courseList.add(new Course(id, name,  createCourseDate));
            System.out.println("Curso adicionado com sucesso!");
        }
    }

    public void listCourse(){
        courseList.forEach(System.out::println);
    }


    public Optional<Course> searchCourse(Long id){
         return courseList.stream().filter(c-> c.getId().equals(id)).findFirst();
    }

    public void deleteCourse(Long id){
        courseList.removeIf(c-> c.getId().equals(id));
    }

    public void updateCourse(Long id, String name){
        Optional<Course> verifyCourse = courseList.stream().filter(c-> c.getId().equals(id)).findFirst();

        if(verifyCourse.isEmpty()){
            System.out.println("Esse curso não existe!");
        }else{
             verifyCourse.get().setName(name);
            System.out.println("Nome do curso atualizado com sucesso!");

        }
    }

}
