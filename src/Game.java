import java.util.*;

public class Game {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Player p1 = new Player();
        WeaponDamage wpnDmg = new WeaponDamage();

        System.out.println("What would you like to be called?");
        p1.name = in.nextLine();
        System.out.println("Welcome to your journey " + p1.name + "!");

        while(true){
            System.out.println("Where would you like to go? \nShop | Woods | Tavern");
            String location = in.nextLine();
            if(location.toLowerCase().equals("shop")){
                Shop weaponShop = new Shop(0);
                System.out.println("You enter the shop...");
                weaponShop.shopInside(p1);
            } else if (location.toLowerCase().equals("woods")){
                Enemy e = new Enemy();
                System.out.println("You head into the woods and after some walking, you encounter a " + e.name);
                System.out.println("What would you like to do?\nFight | Run");
                String choice = in.nextLine();
                if (choice.toLowerCase().equals("fight")){
                    e.fight(p1, wpnDmg);
                } else if(choice.toLowerCase().equals("run")){
                    e.run(p1, wpnDmg);
                }
            } else if (location.toLowerCase().equals("tavern")){
                Tavern tav = new Tavern("Rolling Boil");
                tav.tavernInside();
            } else{
                System.out.println("can you not listen to directions?");
                continue;
            }
        }
    }
}