import java.util.*;

public class Shop {
    HashMap<String, String> goodsPrice = new HashMap<String, String>();
    
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
