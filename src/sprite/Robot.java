package sprite;

import java.util.List;
import java.util.Map;

import utils.Utils;
import weapon.Weapon;

public class Robot extends Sprite {
    public Color color;
    public Weapon weapon;
    public Enemy target;
    public Map<Weapon.WeaponName, Weapon> weaponPack;
    public CommandCenter brain;

    public Robot(Color color, Map<Weapon.WeaponName, Weapon> weaponPack, CommandCenter brain) {
        this.color = color;
        this.weaponPack = weaponPack;
        this.brain = brain;
    }

    public void attack(List<Enemy> enemies) {
        target = brain.confirmTarget(enemies, this);
        if (target == null) {
            moveArround();
            return;
        }
        Weapon.WeaponName weaponName = brain.decideWeapon(target.armor, target.speed);
        System.out.println(
                "Robot " + this.hashCode() + " position " + this.position.toString() + ", is attacking enemy "
                        + target.hashCode() + " position "
                        + target.position.toString()
                        + ", which armor is " + target.armor
                        + ", speed is " + target.speed + ", with " + weaponName + " weapon");
        weapon = weaponPack.get(weaponName);
        while (true) {
            if (target.isAlive()) {
                weapon.attack(target);
            } else {
                break;
            }
        }
    }

    // move arround, which need to spend some time.
    public void moveArround() {
        this.position = Utils.randPosition();
    }
}
