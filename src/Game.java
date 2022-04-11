import java.util.List;

import sprite.Enemy;
import sprite.Robot;
import sprite.CommandCenter;

public class Game {
    public static void main(String[] args) {
        // create many robots
        System.out.println("Create robots phase");
        List<Robot> robots = Factory.getManyRobots(10);
        // create many enemies
        System.out.println("Create enemies phase");
        List<Enemy> enemies = Factory.getManyEnemies(50);

        // if enemies more than robots, then robots will attack them multiple phases.
        int attackPhase = 1;
        while (true) {
            System.out.printf("\n--------------\nAttack phase %d.\n--------------\n", attackPhase);
            attackPhase += 1;
            for (Robot robot : robots) {
                robot.attack(enemies);
            }
            if (CommandCenter.allEnemyDead(enemies)) {
                break;
            }
        }
    }
}
