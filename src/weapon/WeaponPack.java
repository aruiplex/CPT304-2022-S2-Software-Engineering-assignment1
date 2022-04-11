package weapon;

import java.util.Map;

public class WeaponPack {
    private static final Map<Weapon.WeaponName, Weapon> INSTANCE = Map.of(
            Weapon.WeaponName.LASER, new Laser(),
            Weapon.WeaponName.RIFLE, new Rifile(),
            Weapon.WeaponName.SPEAR, new Spear());

    // singleton pattern
    public static Map<Weapon.WeaponName, Weapon> getWeaponPack() {
        return INSTANCE;
    }

    private WeaponPack() {
        // singleton pattern, private constructor
    }
}
