package sprite;

import java.util.List;

import weapon.Weapon;

// strategy pattern, another way to implement the robotBrain
public class UrgentCommandMaker extends CommandCenter {
    private static final UrgentCommandMaker INSTANCE = new UrgentCommandMaker();

    public static UrgentCommandMaker getBrain() {
        return INSTANCE;
    }

    private UrgentCommandMaker() {
    }

    // confirm the alive and closest enemy
    @Override
    public Enemy confirmTarget(List<Enemy> enemies, Sprite sprite) {
        float minDistance = Float.MAX_VALUE;
        Enemy target = null;
        Position base = new Position(0, 0, 0);

        for (Enemy enemy : enemies) {
            // attack the closest to the base
            float distance = base.distance(enemy.position);
            if (enemy.isAlive() && distance < minDistance) {
                minDistance = distance;
                target = enemy;
            }
        }
        return target;
    }

    // Use the best weapons
    @Override
    public Weapon.WeaponName decideWeapon(int armor, int speed) {
        return Weapon.WeaponName.LASER;
    }
}
