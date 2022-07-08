package diary.teacher;

import diary.data.DataBase;
import diary.data.User;
import diary.service.TeacherService;
import diary.student.Student;

import java.util.Scanner;


public class Teacher extends User implements TeacherService {
    private String position;
    private String ClassTeacher;
    private double salary;
    private Scanner scanner = new Scanner(System.in);

    public Teacher() {

    }

    public Teacher(String firstName, String lastname, String birthday, String patron, char gender, String position,String Class,double salary) {
        super(firstName, lastname, birthday, patron, gender);
        this.position = position;
        this.ClassTeacher=Class;
        this.salary = salary;
    }


    public String  getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getClassTeacher() {
        return ClassTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        ClassTeacher = classTeacher;
    }

    @Override
    public void signIn() {
        System.out.print("Entered First Name: ");
        String name=scanner.next();
        System.out.print("Entered Position Desc: ");
        String desc=scanner.next();
        for (int i = 0; i < DataBase.teachers.size(); i++) {
            if(DataBase.teachers.get(i).getFirstName().equals(name)){
                if(DataBase.teachers.get(i).position.equals(desc)){
                    menu();
                }
            }
        }
    }

    @Override
    public void menu() {
        boolean isHave=true;
        while (isHave){
            System.out.println("---------------------Welcome to online Diary---------------------");
            System.out.println("1->Marked\n2->Attendance Marked\n3->List of Teachers\n0->Exit");
            int n=scanner.nextInt();
            switch (n){
                case 0->{isHave=false;}
                case 1->{markedStudents();}
                case 2->{markedAttendance();}
                case 3->{listOfTeachers();}

            }
        }
    }

    @Override
    public void markedStudents() {
        for (int i = 0; i < DataBase.classes.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.print("Entered Class number: ");
        int n=scanner.nextInt()-1;
        for (int i = 0,k=0; i < DataBase.students.size(); i++,k++) {
            if(DataBase.students.get(i).getClass().equals(DataBase.students.get(n).getClass())){
                System.out.println((k+1)+"->"+DataBase.students.get(i));
            }
        }
        System.out.println("Entered Student Number: ");
        int n3=scanner.nextInt()-1;
        for (int i = 0; i < DataBase.students.size(); i++) {
            if (DataBase.students.get(i).equals(DataBase.students.get(n3))){
                System.out.println("Marked the Student by Science: ");
                byte mark=scanner.nextByte();
                System.out.print("Entered Day: ");
                String day=scanner.next();
                Student s1=new Student(DataBase.students.get(i).getFirstName(),DataBase.students.get(i).getLastname(),
                        DataBase.students.get(i).getsClass());
                Student student=new Student(mark,day,s1);
                DataBase.marks.add(student);
                System.out.println("Successfully marked");
            }
        }

    }
    @Override
    public void markedAttendance() {
        for (int i = 0; i < DataBase.classes.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.print("Entered Class number: ");
        int n=scanner.nextInt()-1;
        for (int i = 0,k=0; i < DataBase.students.size(); i++,k++) {
            if(DataBase.students.get(i).getClass().equals(DataBase.students.get(n).getClass())){
                System.out.println((k+1)+"->"+DataBase.students.get(i));
            }
        }
        System.out.println("Entered Student Number: ");
        int n3=scanner.nextInt()-1;
        for (int i = 0; i < DataBase.students.size(); i++) {
            if (DataBase.students.get(i).equals(DataBase.students.get(n3))){
                System.out.println("Please Check!!!\nStudent in the Lesson:(+ or -)");
                char attend=scanner.next().charAt(0);
                System.out.print("Entered day: ");
                String day=scanner.next();
                Student s2=new Student(DataBase.students.get(i).getFirstName(),DataBase.students.get(i).getLastname(),
                        DataBase.students.get(i).getsClass());
                Student student=new Student(attend,day,s2);
                DataBase.attendances.add(student);
                System.out.println("Successfully marked");
            }
        }

    }

    @Override
    public void listOfTeachers() {
        for (Teacher teacher : DataBase.teachers) {
            System.out.println(teacher.position);
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastname='" +getLastname() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", patron='" + getPatron() + '\'' +
                ", gender=" + getGender() +
                ", position=" + position +
                ", Class=" + getClassTeacher() +
                ", salary=" + salary +
                '}';
    }
}
