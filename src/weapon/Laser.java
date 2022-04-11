package weapon;

import sprite.Enemy;

public class Laser implements Weapon {
    @Override
    public int attack(Enemy enemy) {
        enemy.injuried(30);
        return 30;
    }
}
