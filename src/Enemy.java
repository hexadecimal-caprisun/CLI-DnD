import java.util.*;

public class Enemy{
    public int health = 15;
    public String name = "";
    HashMap<String, Integer> damage = new HashMap<>();
    Random r = new Random();
    
    String[] possible = {"Bandit","Bear","Ape"};

    public void setEnemy(){
        name = possible[r.nextInt(possible.length)];
    }

    public void takeDamage(int d){
        health -= d;
    }
}
