package weapon;

import sprite.Enemy;

public interface Weapon {
    int attack(Enemy enemy);

    public enum WeaponName {
        LASER, RIFLE, SPEAR
    }
}
