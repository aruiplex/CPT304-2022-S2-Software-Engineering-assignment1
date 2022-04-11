package sprite;

import java.util.List;

import weapon.Weapon;

public class DistanceBasedCommandMaker extends CommandCenter {

    private static final DistanceBasedCommandMaker INSTANCE = new DistanceBasedCommandMaker();

    public static DistanceBasedCommandMaker getBrain() {
        return INSTANCE;
    }

    private DistanceBasedCommandMaker() {

    }

    // confirm the alive and closest enemy
    @Override
    public Enemy confirmTarget(List<Enemy> enemies, Sprite sprite) {
        float minDistance = Float.MAX_VALUE;
        Enemy target = null;
        for (Enemy enemy : enemies) {
            float distance = sprite.distance(enemy);
            if (enemy.isAlive() && distance < minDistance) {
                minDistance = distance;
                target = enemy;
            }
        }
        return target;
    }

    // get the suitable weapon
    @Override
    public Weapon.WeaponName decideWeapon(int armor, int speed) {
        if (armor > 50 || speed > 120) {
            return Weapon.WeaponName.LASER;
        } else if (armor < 50 && armor > 20 || speed < 120 && speed > 60) {
            return Weapon.WeaponName.RIFLE;
        }
        return Weapon.WeaponName.SPEAR;
    }
}
