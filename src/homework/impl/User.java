package homework.impl;

public class User implements Reportable{
    private final String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void report(){
        System.out.println("Report for user: " + name);
    }
}
