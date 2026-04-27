package com.sistemaCurso;
import com.sistemaCurso.model.User;
import com.sistemaCurso.service.CourseService;
import com.sistemaCurso.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseService courseService = new CourseService();
        UserService userService = new UserService(courseService);

        boolean running = true;

        while(running){
            System.out.println("Bem vindo ao Sistema de Cursos");

            System.out.println("Digite 1 para cadastrar usuário");
            System.out.println("Digite 2 para listar usuários");
            System.out.println("Digite 3 para atualizar dados de um usuário");
            System.out.println("Digite 4 para remover usuário do sistema");

            System.out.println("-----------------------------------------");

            System.out.println("Digite 5 para cadastrar curso");
            System.out.println("Digite 6 para listar cursos");
            System.out.println("Digite 7 para pesquisar um curso específico");
            System.out.println("Digite 8 para atualizar dados de um curso");
            System.out.println("Digite 9 para remover curso do sistema");
            System.out.println("Digite 10 para adicionar um curso a um usuário");
            System.out.println("Digite 11 para listar todos usuários cadastrados em um curso");

            System.out.println("-----------------------------------------");
            System.out.println("Digite 12 para sair do sistema");

            var option = scanner.nextInt();


            switch (option){
                case 1: {
                    System.out.println("Digite o id do usuário");
                    var userId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Digite o nome do usuário");
                    var userName = scanner.nextLine();
                    userService.addUser(userId, userName);
                    break;
                }
                case 2:{
                    userService.listUsers();
                    break;
                }
                case 3:{
                    System.out.println("Digite o id do usuário que você quer atualizar o nome");
                    var userId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Passe o novo nome que deseja alterar");
                    var updateUserName = scanner.nextLine();
                    userService.updateUserName(userId, updateUserName);
                    break;
                }
                case 4:{
                    System.out.println("Digite o id do usuário que você quer deletar do sistema");
                    var userId = scanner.nextLong();
                    scanner.nextLine();
                    userService.deleteUser(userId);
                    break;
                }
                case 5:{
                    System.out.println("Digite o id do curso");
                    var courseId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Digite o nome do curso");
                    var courseName = scanner.nextLine();

                    LocalDate localDate = LocalDate.now();

                    courseService.addCourse(courseId,courseName, localDate);
                    break;
                }
                case 6:{
                    courseService.listCourse();
                    break;
                }
                case 7:{
                    System.out.println("Digite o id do curso que você está procurando");
                    var userId = scanner.nextLong();
                    scanner.nextLine();
                    courseService.searchCourse(userId);
                    break;
                }
                case 8:{
                    System.out.println("Digite o id do curso que você quer atualizar o nome");
                    var courseId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Passe o novo nome que deseja alterar");
                    var updateCourseName = scanner.nextLine();

                    courseService.updateCourse(courseId, updateCourseName);
                    break;
                }
                case 9:{
                    System.out.println("Digite o id do curso que você quer deletar do sistema");
                    var courseId = scanner.nextLong();
                    scanner.nextLine();
                    courseService.deleteCourse(courseId);
                    break;
                }
                case 10:{
                    System.out.println("Digite o id do curso que deseja vincular ao usuário");
                    var courseId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Digite o id do usuário que deseja vincular ao curso");
                    var userId = scanner.nextLong();
                    scanner.nextLine();

                    userService.addCourseToUser(userId,courseId );
                    break;
                }
                case 11:{
                    System.out.println("Digite o id do curso que deseja saber os usuários cadastrados");
                    var courseId = scanner.nextLong();
                    scanner.nextLine();
                    List<User> listUsers = userService.listUsersEnrolledInCourse(courseId);
                    for(User listAllUsers : listUsers){
                        System.out.println(listAllUsers);
                    }
                    break;
                }
                case 12:{
                    running = false;
                    break;
                }
                default:
                    System.out.println("Opção inválida");
            }

        }

    }
}
