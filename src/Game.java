import java.util.*;

public class Game {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Player p1 = new Player();
        Random r = new Random();
        WeaponDamage wpnDmg = new WeaponDamage();

        p1.setInv();
        wpnDmg.setDamage();

        System.out.println("What would you like to be called?");
        p1.name = in.nextLine();
        System.out.println("Welcome to your journey " + p1.name + "!");

        while(true){
            System.out.println("Where would you like to go? \nShop | Woods | Tavern");

            String location = in.nextLine();

            if(location.toLowerCase().equals("shop")){
                Shop weaponShop = new Shop();
                weaponShop.setWeapons();

                System.out.println("You enter the shop...");

                String money = p1.getMoney();
                if(money.equals("You are dirt broke my friend")){
                    System.out.println(money);
                    continue;
                } else{
                    System.out.println("You have " + p1.getMoney());
                }
                System.out.println("Shopkeep: \"Welcome! please, take a look at my wares!\"");
                for (String i : weaponShop.goodsPrice.keySet()){
                    System.out.println(Converter.firstCap(i) + " Price: " + weaponShop.goodsPrice.get(i));
                }
                System.out.println("exit");
                String purchase = in.nextLine().toLowerCase();

                if (purchase.equals("exit")){
                    
                } else{
                    String[] cost = weaponShop.goodsPrice.get(purchase).split(" ");
                    if(cost[1].equals("sp")){
                        if(p1.silver == 0){
                            if(p1.gold > 0){
                                p1.gold -= 1;
                                p1.silver += 10;
                                if(p1.silver >= Integer.parseInt(cost[0])){
                                    p1.silver -= Integer.parseInt(cost[0]);
                                    System.out.println("You have bought and equipped a " + purchase + "!");
                                    System.out.println("You now have " + p1.getMoney());
                                    p1.updateWeapon(purchase);
                                    weaponShop.goodsPrice.remove(purchase);
                                }
                            }
                        }
                    } else if (cost[1].equals("gp")){
                        if(p1.gold >= Integer.parseInt(cost[0])){
                            p1.gold -= Integer.parseInt(cost[0]);
                            System.out.println("You have bought and equipped a " + purchase + "!");
                            System.out.println("You now have " + p1.getMoney());
                            p1.updateWeapon(purchase);
                            weaponShop.goodsPrice.remove(purchase);
                        }
                    }
                }
            } else if (location.toLowerCase().equals("woods")){
                System.out.println("You head into the woods and after some walking, you encounter a bandit");
                Enemy bandit = new Enemy();
                System.out.println("What would you like to do?\nFight | Run");
                String choice = in.nextLine();
                if (choice.toLowerCase().equals("fight")){
                    while(bandit.health > 0){
                        System.out.println("What would you like to do this turn? \nAttack | Heal | Flee (can only do on 6 *be careful, there may be consequences*)");
                        String turnChoice = in.nextLine();

                        if(turnChoice.toLowerCase().equals("attack")){
                            int playerDamage = r.nextInt(wpnDmg.weaponDamage.get(p1.weapon.toLowerCase())) + 1;
                            bandit.takeDamage(playerDamage);
                            System.out.println("You hit the " + bandit.getClass().getName() + " for " + playerDamage + " damage!");
                        } else if(turnChoice.toLowerCase().equals("heal")){
                            if(p1.inventory.size() > 0){
                                System.out.println(p1.inventory);
                                System.out.println("You have " + p1.inventory.size() + " health potions left, are you sure?\nY | N");
                                String invChoice = in.nextLine();
                                if (invChoice.toLowerCase().equals("y")){
                                    p1.heal();
                                    p1.updateInv("Heal", 0);
                                } else if(invChoice.toLowerCase().equals("n")){
                                    continue;
                                }
                            } else{
                                System.out.println("You have no heal potions left!");
                                continue;
                            }
                        } else if(turnChoice.toLowerCase().equals("flee")){
                            int fleeRoll = r.nextInt(5) + 1;
                            System.out.println("Flee roll: " + fleeRoll);

                            if(fleeRoll < 6){
                                System.out.println("Flee roll failed! You take 50 damage");
                                p1.damageTake(50);
                                System.out.println("Your health: " + p1.health);
                            } else{
                                System.out.println("Flee roll succeeded! You run away");
                                break;
                            }
                        }


                        int hit = r.nextInt(5) + 1;
                        System.out.println("Bandit hit roll: " + hit);
                        if(hit >= 3){
                            for(int i = 0; i < 4; i++){
                                int enemyDamage = r.nextInt(5) + 2;
                                System.out.println("Bandit hits for " + enemyDamage + " damage!");
                                p1.damageTake(enemyDamage);
                            }
                        } else{
                            System.out.println("The bandit missed!");
                        }

                        System.out.println("Your health: " + p1.health);
                        System.out.println("Enemy health: " + bandit.health);

                        if(p1.health <= 0){
                            System.out.println("You died. You lost. This shouldn't even be possible this game is as easy as possible.");
                            System.exit(0);
                        } else{
                            continue;
                        }
                        
                }
            }
            } else if (location.toLowerCase().equals("tavern")){
                
            } else{
                System.out.println("can you not listen to directions?");
                break;
            }
        }

        in.close();
    }
}