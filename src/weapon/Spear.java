package weapon;

import sprite.Enemy;

public class Spear implements Weapon {
    @Override
    public int attack(Enemy enemy) {
        enemy.injuried(10);
        return 10;
    }
}
