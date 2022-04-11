package sprite;

import java.util.List;
import weapon.Weapon;

public abstract class CommandCenter {

    public Enemy confirmTarget(List<Enemy> enemies, Sprite sprite) {
        return null;
    }

    public Weapon.WeaponName decideWeapon(int armor, int speed) {
        return null;
    }

    public static boolean allEnemyDead(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                return false;
            }
        }
        return true;
    }
}
