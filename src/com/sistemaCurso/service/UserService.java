package com.sistemaCurso.service;

import com.sistemaCurso.model.Course;
import com.sistemaCurso.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private List<User> userList = new ArrayList<>();
    private CourseService courseService;

    public UserService(CourseService courseService) {
        this.courseService = courseService;
    }


    public void addUser(Long id, String name){
        boolean verifyUserById = userList.stream().anyMatch(u -> u.getId().equals(id));
        if(verifyUserById){
            System.out.println("Usuário já existe no sistema");
        }else{
            userList.add(new User(id, name));
            System.out.println("Usuário adicionado com sucesso!");
        }
    }
    public void listUsers(){
        userList.forEach(System.out::println);
    }

    public Optional<User> searchUser(Long id){
        return userList.stream().filter(u-> u.getId().equals(id)).findFirst();
    }

    public void addCourseToUser(Long userId, Long courseId){
        Optional<User> user = searchUser(userId);
        Optional<Course> course = courseService.searchCourse(courseId);

        if(user.isEmpty()){
            System.out.println("Usuário não encontrado");
            return;

        }
        if (course.isEmpty()) {
            System.out.println("Curso não encontrado");
            return;
        }
        boolean alreadyEnrolled = user.get().getCourses()
                .stream()
                .anyMatch(c -> c.getId().equals(courseId));


        if (alreadyEnrolled) {
            System.out.println("Usuário já está matriculado nesse curso");
            return;
        }

        user.get().getCourses().add(course.get());
        System.out.println("Usuário matriculado com sucesso!");
    }

    public List<User> listUsersEnrolledInCourse(Long courseId){
        return userList.stream().filter(u -> u.getCourses().stream().anyMatch(c -> c.getId().equals(courseId))).toList();

    }

    public void deleteUser(Long id){
        userList.removeIf(u-> u.getId().equals(id));
    }

    public void updateUserName(Long id, String name){
        Optional<User> verifyUserName = userList.stream().filter(u -> u.getId().equals(id)).findFirst();

        if(verifyUserName.isEmpty()){
            System.out.println("Usuário não encontrado");
        }else{
            verifyUserName.get().setName(name);
            System.out.println("Nome do usuário atualizado com sucesso!");
        }
    }


}
