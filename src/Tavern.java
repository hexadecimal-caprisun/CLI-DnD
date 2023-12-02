import java.util.*;

public class Tavern {
    public String name = "";
    public String merc = "";
    String[] mercenaries = {"Random test assassin","Random Ninja", "Test guy 3"};
    Random r = new Random();

    public void setName(String a){
        name = a;
    }

    public void setMercenary(){
        merc = mercenaries[r.nextInt(mercenaries.length)];
    }
}
