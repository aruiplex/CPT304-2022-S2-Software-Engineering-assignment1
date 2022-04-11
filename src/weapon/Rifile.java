package weapon;

import sprite.Enemy;

public class Rifile implements Weapon {
    @Override
    public int attack(Enemy enemy) {
        enemy.injuried(20);
        return 20;
    }
}
