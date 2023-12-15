import java.util.*;

public class Merc {
    public String name;
    public int health = 100;
    public int[] stats = new int[6];

    Random r = new Random();

    public void setStats(){
        for(int i = 0; i < stats.length; i++){
            stats[i] = r.nextInt(19) + 1;
        }
    }

    Merc(String n){
        name = n;
        setStats();
    }
}
