import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sprite.Color;
import sprite.DistanceBasedCommandMaker;
import sprite.Enemy;
import sprite.Robot;
import utils.Utils;
import sprite.CommandCenter;
import weapon.Weapon;
import weapon.Weapon.WeaponName;
import weapon.WeaponPack;

public class Factory {

    private Factory() {
    }

    // get random type and position robot.
    public static Robot getRandomRobot() {
        Map<WeaponName, Weapon> weaponPack = WeaponPack.getWeaponPack();
        Color color = Utils.randomEnum(Color.class);
        CommandCenter brain = DistanceBasedCommandMaker.getBrain();
        // bridge pattern
        return new Robot(color, weaponPack, brain);
    }

    public static Enemy getRandomEnemy() {
        int armor = (int) (Math.random() * 70);
        int speed = (int) (Math.random() * 150);
        return new Enemy(armor, speed);
    }

    public static List<Robot> getManyRobots(int number) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Robot robot = getRandomRobot();
            System.out.println("getRandomRobot: " + robot.color + ", name is " + robot.hashCode());
            robots.add(robot);
        }
        return robots;
    }

    public static List<Enemy> getManyEnemies(int number) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Enemy enemy = getRandomEnemy();
            System.out.println(
                    "getRandomEnemy armor " + enemy.armor + ", speed " + enemy.speed + ", name is " + enemy.hashCode());
            enemies.add(enemy);
        }
        return enemies;
    }
}
