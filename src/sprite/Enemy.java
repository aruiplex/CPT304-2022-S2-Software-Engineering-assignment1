package sprite;

public class Enemy extends Sprite {
    public int armor;
    public int speed;
    private boolean alive = true;

    public Enemy(int armor, int speed) {
        this.armor = armor;
        this.speed = speed;
    }

    public boolean injuried(int damage) {
        this.armor -= damage;
        if (armor <= 0) {
            alive = false;
            System.out.println("Enemy " + this.hashCode() + " is dead");
            return false;
        } else {
            System.out.println("Enemy " + this.hashCode() + " is injuried, armor is " + armor);
            return true;
        }
    }

    public boolean isAlive() {
        return alive;
    }
}
