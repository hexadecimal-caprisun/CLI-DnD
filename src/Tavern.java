import java.util.*;

public class Tavern {
    public String name = "";
    public String merc = "";
    String[] mercenaries = {"Random test assassin","Random Ninja", "Test guy 3"};
    Random r = new Random();
    Scanner scan = new Scanner(System.in);

    public void setName(String a){
        name = a;
    }

    public void setMercenary(){
        merc = mercenaries[r.nextInt(mercenaries.length)];
    }

    public void tavernInside(){
        System.out.println("You have entered " + name);
        while(true){
            System.out.println("what would you like to do?\nHire a mercenary | Grab a drink | Rest");
            String userIn = scan.nextLine();
            if(userIn.toLowerCase() == "hire a mercenary"){

            } else if(userIn.toLowerCase() == "grab a drink"){

            } else if(userIn.toLowerCase() == "rest"){

            } else{
                System.out.println("That is not an option. Try again.");
                continue;
            }
        }
    }

    Tavern(String name){
        setMercenary();
        setName(name);
    }
}
