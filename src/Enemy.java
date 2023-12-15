import java.util.*;

public class Enemy{
    public int health;
    public String name = "";
    public int damage;
    HashMap<String, Integer> damageMap = new HashMap<>();
    HashMap<String, Integer> healthMap = new HashMap<>();
    Random r = new Random();
    Scanner in = new Scanner(System.in);
    
    String[] possible = {"Bandit","Bear","Ape"};

    public void setEnemy(){
        name = possible[r.nextInt(possible.length)];
    }

    public void setDamage(){
        damageMap.put("Bandit", 5);
        damageMap.put("Bear", 7);
        damageMap.put("Ape", 3);
        damage = damageMap.get(name);
    }

    public void setHealth(){
        healthMap.put("Bandit", 15);
        healthMap.put("Bear", 30);
        healthMap.put("Ape", 10);
        health = healthMap.get(name);
    }

    public void takeDamage(int d){
        health -= d;
    }

    public void fight(Player p1, WeaponDamage wpnDmg){
        while(health > 0){
            System.out.println("What would you like to do this turn? \nAttack | Heal | Flee (can only do on 17+ *be careful, there may be consequences*)");
            String turnChoice = in.nextLine();
            if(turnChoice.toLowerCase().equals("attack")){
                int playerAttackTimes = r.nextInt(5) + 1;
                for(int i = 0; i < playerAttackTimes; i++){
                    int playerDamage = r.nextInt(wpnDmg.weaponDamage.get(p1.weapon.toLowerCase())) + 1;
                    takeDamage(playerDamage);
                    System.out.println("You hit the " + name + " for " + playerDamage + " damage!");
                }
            } else if(turnChoice.toLowerCase().equals("heal")){
                if(p1.inventory.size() > 0){
                    System.out.println(p1.inventory);
                    System.out.println("You have " + p1.inventory.size() + " health potions left, are you sure?\nY | N");
                    String invChoice = in.nextLine();
                    if (invChoice.toLowerCase().equals("y")){
                        p1.heal();
                        p1.updateInv("Healing potion", 0);
                    } else if(invChoice.toLowerCase().equals("n")){
                        continue;
                    }
                } else{
                    System.out.println("You have no heal potions left!");
                    continue;
                }
            } else if(turnChoice.toLowerCase().equals("flee")){
                int fleeRoll = r.nextInt(19) + 1;
                System.out.println("Flee roll: " + fleeRoll);

                if(fleeRoll < 17){
                    System.out.println("Flee roll failed! You take 50 damage");
                    p1.damageTake(50);
                    System.out.println("Your health: " + p1.health);
                } else{
                    System.out.println("Flee roll succeeded! You run away");
                    break;
                }
            } else{
                System.out.println("That's not an option! Try again!");
                continue;
            }
            int hit = r.nextInt(5) + 1;
            System.out.println(name + " hit roll: " + hit);
            if(hit >= 3){
                for(int i = 0; i < 4; i++){
                    int enemyDamage = r.nextInt(5) + damage;
                    System.out.println(name + " hits for " + enemyDamage + " damage!");
                    p1.damageTake(enemyDamage);
                }
            } else{
                System.out.println("The " + name +  " missed!");
            }
            if(health < 0){
                health = 0;
            }
            System.out.println("Your health: " + p1.health);
            System.out.println("Enemy health: " + health);

            if(p1.health <= 0){
                System.out.println("You died. You lost. This shouldn't even be possible this game is as easy as possible.");
                System.exit(0);
            } else{
                continue;
            }
            
        }
        System.out.println("Congrats! You won!");
    }

    public void run(Player p, WeaponDamage w){
        int random = r.nextInt(20) + 1;
        int dam = r.nextInt(20) + 1;
        System.out.println("You rolled a " + random);
        if(random >= 10){
        }else{
            System.out.println("You failed! The " + name + " hits you for " + dam + " damage");
            p.damageTake(dam);
            fight(p, w);
        }
    }

    Enemy(){
        setEnemy();
        setDamage();
        setHealth();
    }
}
