import java.util.*;

public class Player {
    public String name = "";
    public Integer health = 100;
    public String weapon = "Fists";
    public Integer gold = 10;
    public Integer silver = 0;
    public ArrayList<String> inventory = new ArrayList<>();
    public int[] pStats = new int[6];


    Random r = new Random();

    public void setInv(){
        inventory.add("Heal");
    }

    public void setStats(){
        for(int i = 0; i < pStats.length; i++){
            pStats[i] = r.nextInt(19) + 1;
        }
    }

    Player(){
        setInv();
        setStats();
    }

    public void damageTake(int n){
        health = health - n;

        if(health < 0){
            health = 0;
        }
    }

    public String getMoney(){
        String out = "";
        if (silver == 0 && gold == 0){
            out = "You are dirt broke my friend";
            return out;
        } else if (silver == 0 && gold > 0){
            out = gold.toString() + "gp";
            return out;
        } else if (gold == 0 && silver > 0){
            out = silver.toString() + "sp";
            return out;
        } else if (gold > 0 && silver > 0){
            out = gold.toString() + "gp, " + silver.toString() + "sp";
            return out;
        }
        return "this is impossible...";
    }

    public void updateWeapon(String n){
        weapon = n;
    }

    public void updateInv(String n, int a){ //0 for remove, 1 for add
        if(a == 0){
            inventory.remove(n);
        } else{
            inventory.add(n);
        }
        
    }

    public void heal(){
        int temp1 = r.nextInt(3) + 1;
        int temp2 = r.nextInt(3) + 1;
        int heal = temp1 + temp2 + 2;
        health += heal;
        System.out.println("You healed for " + heal + " hit points, bringing you to " + health);
    }
}
