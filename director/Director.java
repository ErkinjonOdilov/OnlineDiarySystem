package diary.director;

import diary.data.Class;
import diary.data.DataBase;
import diary.data.User;
import diary.position.Position;
import diary.service.DirectorService;
import diary.student.Student;
import diary.teacher.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class Director extends User implements DirectorService {
    private String login="Erkinjon";
    private String password="123";
    private Scanner scanner=new Scanner(System.in);




    public Director() {

    }

    public Director(String firstName, String lastname, String birthday, String patron, char gender, String login, String password) {
        super(firstName, lastname, birthday, patron, gender);
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void signIn() {
        System.out.print("Entered Login: ");
        String login=scanner.next();
        System.out.print("Entered Password:");
        String password=scanner.next();
        if(login.equals(getLogin())){
            if(password.equals(getPassword())){
                directorMenu();
            }else {
                System.out.println("Password Incorrect!!!");
            }
        }else {
            System.out.println("Login Incorrect!!!");
        }
    }

    @Override
    public void directorMenu() {
        boolean a=true;
        while (a) {
            System.out.println("-------------------------Choose Options!!!--------------------------");
            System.out.println("1->Add Classes\n2->Show Classes\n3->Deleted Classes\n4->Positions\n5->Add Teachers\n6->List Of Teachers\n" +
                    "7->Deleted Teachers\n8->List Of Attendance\n9->Students\n0->Exit");
            int n=scanner.nextInt();
            switch (n){
                case 0->{a=false;}
                case 1->{addClasses();}
                case 2->{listOfClasses();}
                case 3->{deleteClasses();}
                case 4->{
                    Position p1=new Position();
                    boolean b=true;
                    while (b){
                        System.out.println("1->Add positions\n2->Edit Positions\n3->Delete Position\n4->List Position\n0->Exit");
                        int n1=scanner.nextInt();
                        switch (n1){
                            case 0->{b=false;}
                            case 1->{p1.addPosition();}
                            case 2->{p1.editPosition();}
                            case 3->{p1.deletePosition();}
                            case 4->{p1.listPosition();}

                        }
                    }
                }
                case 5->{addTeachers();}
                case 6->{listOfTeachers();}
                case 7->{deleteTeachers();}
                case 8->{listOfAttendance();}
                case 9->{
                    boolean b=true;
                    while (b){
                        System.out.println("-------------------------Students-------------------------");
                        System.out.println("Choose options: ");
                        System.out.println("1->Add Students\n2->Show Students\n0->Exit");
                        int n2=scanner.nextInt();
                        switch (n2){
                            case 0->{b=false;}
                            case 1->{addStudents();}
                            case 2->{showStudents();}
                        }
                    }

                }
            }
        }
    }

    @Override
    public void addClasses() {
        System.out.print("Class name: ");
        scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.print("Entered Id: ");
        String classId=scanner.next();
        Class  c1=new Class(name,classId);
        DataBase.classes.add(c1);
        System.out.println("Successfully added!!!");
    }
    @Override
    public void deleteClasses() {
        for (int i = 0; i <DataBase.classes.size() ; i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.println("Enter the number: ");
        int n=scanner.nextInt()-1;
        DataBase.classes.remove(n);
        System.out.println("Successfully Deleted!!!");
    }
    @Override
    public void listOfClasses() {
        for (Class aClass : DataBase.classes) {
            System.out.println(aClass);
        }
    }


    @Override
    public void addTeachers() {
        System.out.print("First name: ");
        String firstName=scanner.next();
        System.out.print("Last name: ");
        String lastName=scanner.next();
        System.out.print("Birthday: ");
        String birthday=scanner.next();
        System.out.print("Patron: ");
        String patron=scanner.next();
        System.out.print("Gender: ");
        char gender=scanner.next().charAt(0);
        for (int i = 0; i < DataBase.positionsList.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.positionsList.get(i).getDesc());
        }
        System.out.print("Entered option: ");
        int n=scanner.nextInt()-1;
        String position=DataBase.positionsList.get(n).getDesc();
        for (int i = 0; i < DataBase.classes.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.print("Entered option: ");
        int s=scanner.nextInt()-1;
        String classTeacher=DataBase.classes.get(s).getClassName();
        System.out.print("Salary:");
        double salary=scanner.nextDouble();
        Teacher t1=new Teacher(firstName,lastName,birthday,patron,gender,position,classTeacher,salary);
        DataBase.teachers.add(t1);
        System.out.println("Successfully added!!!");


    }
    @Override
    public void listOfTeachers() {
        for (Teacher teacher : DataBase.teachers) {
            System.out.println(teacher);
        }
    }
    @Override
    public void deleteTeachers() {
        for (int i = 0; i < DataBase.teachers.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.teachers.get(i));
        }
        System.out.print("Choose numbers for deleted: ");
        int n=scanner.nextInt()-1;
        DataBase.teachers.remove(n);
        System.out.println("Successfully deleted!!!");
    }
    @Override
    public void listOfAttendance() {
        for (int i = 0; i < DataBase.classes.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.print("Entered Class number: ");
        int n=scanner.nextInt()-1;
        for (int i = 0,k=0; i < DataBase.students.size(); i++,k++) {
            if(DataBase.students.get(i).getClass().equals(DataBase.students.get(n).getClass())){
                System.out.println((k+1)+"->"+DataBase.students.get(i).getAttendance()+" "+DataBase.teachers.get(i).getPosition());
            }
        }
        System.out.print("Entered Option: ");
        int n1=scanner.nextInt()-1;
        System.out.println("ATTENDANCE\tDAY\tSCIENCE");
        for (int i = 0; i < DataBase.attendances.size(); i++) {
                System.out.println(DataBase.attendances.get(i).getAttendance()+"\t\t\t"+ DataBase.attendances.get(i).getDay()+"\t\t\t"+DataBase.positionsList.get(i).getDesc());

        }
    }

    @Override
    public void addStudents() {
        System.out.print("First name: ");
        String firstName=scanner.next();
        System.out.print("Last name: ");
        String lastName=scanner.next();
        System.out.print("Birthday: ");
        String birthday=scanner.next();
        System.out.print("Patron: ");
        String patron=scanner.next();
        System.out.print("Gender: ");
        char gender=scanner.next().charAt(0);
        for (int i = 0; i < DataBase.positionsList.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.positionsList.get(i).getDesc());
        }
        System.out.print("Entered option: ");
        int n=scanner.nextInt()-1;
        String position=DataBase.positionsList.get(n).getDesc();
        for (int i = 0; i < DataBase.classes.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.print("Entered option: ");
        int s=scanner.nextInt()-1;
        String classStudent=DataBase.classes.get(s).getClassName();
        Student s1=new Student(firstName,lastName,patron,birthday,gender,position,classStudent);
        DataBase.students.add(s1);
        System.out.println("Successfully added!!!");
    }

    @Override
    public void showStudents() {
        for (int i = 0; i < DataBase.classes.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.classes.get(i).getClassName());
        }
        System.out.print("Entered Class number: ");
        int n=scanner.nextInt()-1;
        for (int i = 0; i < DataBase.students.size(); i++) {
            if(DataBase.students.get(i).getClass().equals(DataBase.students.get(n).getClass())){
                System.out.println(DataBase.students.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Director{" +
                "firstName='" +getFirstName()+ '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", patron='" +getPatron() + '\'' +
                ", gender=" + getGender() +
                '}';
    }
}
