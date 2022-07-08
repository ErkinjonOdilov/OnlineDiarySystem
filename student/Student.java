package diary.student;

import diary.data.DataBase;
import diary.data.User;
import diary.service.StudentService;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Student extends User implements StudentService {
    private String Position;
    private String sClass;
    private byte mark;
    private Student student;
    private char attendance;
    private String day;
    private String fNme;
    private String lName;
    private Scanner scanner=new Scanner(System.in);

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public Student(char attendance, String day, Student student){
        this.attendance=attendance;
        this.student=student;
        this.day=day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Student (String firsName, String lastName, String ClassStudent){
       super(firsName,lastName);
       this.sClass=ClassStudent;
    }
    public Student(byte mark,String day,Student student) {
        this.mark = mark;
        this.student=student;
        this.day=day;
    }

    public char getAttendance() {
        return attendance;
    }

    public void setAttendance(char attendance) {
        this.attendance = attendance;
    }

    public String getfNme() {
        return fNme;
    }

    public void setfNme(String fNme) {
        this.fNme = fNme;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String getsClass() {
        return sClass;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    public Student() {
    }



    public void setClass(String aClass) {
        sClass = aClass;
    }


    public Student(String firstName, String lastname, String birthday, String patron, char gender, String Position, String Class) {
        super(firstName, lastname, birthday, patron, gender);
        this.Position=Position;
        this.sClass=Class;
    }

    @Override
    public void signIn() {
        System.out.print("Enter the First Name: ");
        fNme=scanner.next();
        System.out.print("Enter the Last Name: ");
        lName=scanner.next();
        for (int i = 0; i < DataBase.students.size(); i++) {
            if(DataBase.students.get(i).getFirstName().equals(fNme) && DataBase.students.get(i).getLastname().equals(lName)){
                boolean s=true;
                while (s){
                    System.out.println("1->List Of Sciences\n2->List of Attendance\n0->Exit");
                    int n4=scanner.nextInt();
                    switch (n4){
                        case 0->{s=false;}
                        case 1->{listOfScience();}
                        case 2->{listOfAttendance();}
                    }
                }
            }
        }

    }

    @Override
    public void listOfScience() {
        for (int i = 0; i < DataBase.positionsList.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.positionsList.get(i).getDesc());
        }
        System.out.print("Entered Science number:");
        int n=scanner.nextInt()-1;
        for (int i = 0; i < DataBase.students.size(); i++) {
            if(DataBase.students.get(i).getPosition().equals(DataBase.students.get(n).getPosition())){
                System.out.println("MARK\tSCIENCE\tDAY");
                for (int j = 0; j <DataBase.marks.size() ; j++) {
                    System.out.println(DataBase.marks.get(j).getMark()+"\t\t"+DataBase.positionsList.get(j).getDesc()+"\t\t"+DataBase.marks.get(j).getDay());
                    break;
                }
            }
        }
    }

    @Override
    public void listOfAttendance() {
        System.out.println("ATTENDANCE\tDAY\tSCIENCE");
        for (int i = 0; i < DataBase.attendances.size(); i++) {
            if(DataBase.students.get(i).getFirstName().equals(getfNme()) &&DataBase.students.get(i).getLastname().equals(getlName())){
                System.out.println(DataBase.attendances.get(i).getAttendance()+"\t\t\t"+ DataBase.attendances.get(i).getDay()+"\t\t\t"+DataBase.positionsList.get(i).getDesc());
            }
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" +getFirstName()+ '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", birthday='" + getBirthday() + '\'' +
                ", patron='" +getPatron() + '\'' +
                ", gender=" + getGender() +
                ", Class='" +getsClass()+ '\'' +
                '}';
    }
}
