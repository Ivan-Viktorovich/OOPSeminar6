package homework;

import homework.impl.Persister;
import homework.impl.User;

public class Main{
    public static void main(String[] args){
        User user = new User("Bob");
        Persister persister = new Persister(user);
        user.report();
        persister.save();
    }
}