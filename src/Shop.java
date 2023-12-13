import java.util.*;

public class Shop {
    HashMap<String, String> goodsPrice = new HashMap<String, String>();
    Scanner in = new Scanner(System.in);

    public void setWeapons(){
        goodsPrice.put("club", "1 sp");
        goodsPrice.put("dagger", "2 gp");
        goodsPrice.put("greatclub", "2 sp");
        goodsPrice.put("handaxe", "5 gp");
        goodsPrice.put("javelin", "5 sp");
        goodsPrice.put("light hammer", "2 gp");
        goodsPrice.put("handaxe", "5 gp");
    }

    public void setItems(){ //Add the items for a shop with *NO WEAPONS* just items (i.e. health pots, mana pots, etc.)
        goodsPrice.put("placeholder", "placeholder");
    }

    public String getItem(String s){
        String out = s.substring(0, 1).toUpperCase() + s.substring(1);
        return out;
    }

    public void shopInside(Player p1){
        System.out.println("Shopkeep: \"Welcome! please, take a look at my wares!\"");
        while(true){
            String money = p1.getMoney();
            if(money.equals("You are dirt broke my friend")){
                System.out.println(money);
                break;
            } else{
                System.out.println("You have " + p1.getMoney());
            }
            System.out.println("--------------------");
            for (String i : goodsPrice.keySet()){
                System.out.println(Converter.firstCap(i) + " | Price: " + goodsPrice.get(i));
            }
            System.out.println("--------------------");
            System.out.println("exit");
            String purchase = in.nextLine().toLowerCase();
            if (purchase.equals("exit")){
                break;
            } else{
                if(!goodsPrice.containsKey(purchase)){
                    System.out.println("Shopkeep: Hmmm... I don't have that.");
                    continue;
                } else{
                    String[] cost = goodsPrice.get(purchase).split(" ");
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
                                    goodsPrice.remove(purchase);
                                    continue;
                                }
                            }
                        }
                    } else if (cost[1].equals("gp")){
                        if(p1.gold >= Integer.parseInt(cost[0])){
                            p1.gold -= Integer.parseInt(cost[0]);
                            System.out.println("You have bought and equipped a " + purchase + "!");
                            System.out.println("You now have " + p1.getMoney());
                            p1.updateWeapon(purchase);
                            goodsPrice.remove(purchase);
                            continue;
                        }
                    }
                }    
            }
        }
    }

    Shop(int i){
        if(i == 0){
            setWeapons();
        } else if(i == 1){
            setItems();
        } else if(i == 2){
            setWeapons();
            setItems();
        }
    }
}
