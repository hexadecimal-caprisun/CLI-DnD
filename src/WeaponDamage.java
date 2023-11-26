import java.util.HashMap;

public class WeaponDamage {
    HashMap<String, Integer> weaponDamage = new HashMap<String, Integer>();

    public void setDamage(){
        weaponDamage.put("fists", 1);
        weaponDamage.put("club", 3);
        weaponDamage.put("dagger", 3);
        weaponDamage.put("greatclub", 7);
        weaponDamage.put("handaxe", 5);
        weaponDamage.put("javelin", 5);
        weaponDamage.put("light hammer", 3);
        weaponDamage.put("handaxe", 5);
    }
}   

// Maybe I can set the spell damage here too, if I do spells (we'll see)
