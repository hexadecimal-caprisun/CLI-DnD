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

    public void tavernInside(Player p){
        System.out.println("You have entered " + name);
        Merc m = new Merc(mercenaries[r.nextInt(mercenaries.length)]);
        while(true){
            System.out.println("what would you like to do?\nHire a mercenary | Grab a drink | Rest | Exit");
            String userIn = scan.nextLine();
            if(userIn.toLowerCase().equals("hire a mercenary")){
                System.out.println(m.name);
            } else if(userIn.toLowerCase().equals("grab a drink")){
                if(p.silver == 0){
                    if(p.gold > 0){
                        p.gold -= 1;
                        p.silver += 10;
                        if(p.silver >= 2){
                            p.silver -= 2;
                            System.out.println("You grab a drink, healing for 25 health");
                            p.health += 25;
                            if(p.health > 100){
                                p.health = 100;
                            }
                            System.out.println("You now have " + p.getMoney() + " and " + p.health + " health");
                            continue;
                        }
                    } else{
                        System.out.println("You're too broke to buy a drink!");
                        continue;
                    }
                }
            } else if(userIn.toLowerCase().equals("rest")){
                if(p.silver == 0){
                    if(p.gold > 0){
                        p.gold -= 1;
                        p.silver += 10;
                        if(p.silver >= 5){
                            p.silver -= 5;
                            System.out.println("You rent a room and stay the night, healing for 50 health");
                            p.health += 50;
                            if(p.health > 100){
                                p.health = 100;
                            }
                            System.out.println("You now have " + p.getMoney() + " and " + p.health + " health");
                            continue;
                        }
                    } else{
                        System.out.println("You're too broke to rent a room!");
                        continue;
                    }
                } else{
                    if(p.silver >= 5){
                            p.silver -= 5;
                            System.out.println("You rent a room and stay the night, healing for 50 health");
                            p.health += 50;
                            if(p.health > 100){
                                p.health = 100;
                            }
                            System.out.println("You now have " + p.getMoney());
                            continue;
                    }
                }
            } else if(userIn.toLowerCase().equals("exit")){
                break;
            } else{
                System.out.println("That is not an option. Try again.");
                continue;
            }
        }
    }

    Tavern(String name){
        setName(name);
    }
}