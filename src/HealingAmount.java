import java.util.HashMap;

public class HealingAmount{
    HashMap<String, Integer> healingNum = new HashMap<String, Integer>();

    public void setHealing(){
        healingNum.put("healing potion", 35);
    }

    HealingAmount(){
        setHealing();
    }
}
