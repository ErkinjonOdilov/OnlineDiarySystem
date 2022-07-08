package diary.position;

import diary.data.DataBase;
import diary.service.PositionService;
import java.util.List;
import java.util.Scanner;

public class Position implements PositionService {
    private  String name;
    private String desc;
    private Scanner scanner=new Scanner(System.in);


    public Position() {
    }



    public Position(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public void addPosition() {
        System.out.print("Name: ");
        String name=scanner.next();
        System.out.print("Desc: ");
        String desc=scanner.next();
        Position p1=new Position(name,desc);
      DataBase.positionsList.add(p1);
        System.out.println("Successfully Added!!!");
    }

    @Override
    public void deletePosition() {
        for (int i = 0; i < DataBase.positionsList.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.positionsList.get(i));
        }
        System.out.println("Entered remove position: ");
        int n=scanner.nextInt()-1;
        DataBase.positionsList.remove(n);
        System.out.println("Successfully deleted!!!");
    }

    @Override
    public void editPosition() {
        for (int i = 0; i < DataBase.positionsList.size(); i++) {
            System.out.println((i+1)+"->"+DataBase.positionsList.get(i));
        }
        System.out.print("Entered Edited Position number: ");
        int n2=scanner.nextInt()-1;
        System.out.print("New position name: ");
        String name=scanner.next();
        DataBase.positionsList.get(n2).setName(name);
        System.out.print("New Desc: ");
        String desc=scanner.next();
        DataBase.positionsList.get(n2).setDesc(desc);
        System.out.println("Successfully edited!!!");

    }

    @Override
    public void listPosition() {
        for (Position position : DataBase.positionsList) {
            System.out.println(position);
        }
    }
    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
