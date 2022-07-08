package diary;

import diary.director.Director;
import diary.service.StudentService;
import diary.service.TeacherService;
import diary.student.Student;
import diary.teacher.Teacher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Director director=new Director();
        Teacher teacher=new Teacher();
        Student student=new Student();
        Scanner scanner =new Scanner(System.in);
        boolean isTrue=true;
        while (isTrue){
            System.out.println("------------------Welcome Online Diary-----------------------");
            System.out.println("Choose options:");
            System.out.println("1->Entered by Director\n2->Entered by Teacher\n3->Entered by Student\n4->Guide to Use\n0->Exit");
            int n=scanner.nextInt();
            switch (n){
                case 0->{isTrue=false;
                    System.out.println("Thanks!!!");}
                case 1->{director.signIn();}
                case 2->{teacher.signIn();}
                case 3->{student.signIn();}
                case 4->{
                    System.out.println("From the Director section to run the program\n" +
                            "1-Add class \n" +
                            "2-Add position \n" +
                            "3-Add teacher\n" +
                            "4-Add a student from the student section\n" +
                            "5-Go to the main menu and enter as Teacher and evaluate the student\n" +
                            "6-Continue\n" +
                            "7-You can view student information by logging in as a student\n" +
                            "Director login=Erkinjon:\n" +
                            "password=123");
                }
                default -> {
                    System.out.println("Sorry!!!\n" +
                            "There is not this options.\n" +
                            "Please again choose option!!!");
                }
            }
        }
    }
}
