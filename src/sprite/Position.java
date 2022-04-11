package sprite;

import utils.Utils;

// object postion in the game
public class Position {
    // 3D position
    public float x;
    public float y;
    public float z;

    // put object to origin
    public Position() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public static Position random() {
        float x = (float) Math.random() * 100;
        float y = (float) Math.random() * 100;
        float z = (float) Math.random() * 100;
        return new Position(x, y, z);
    }

    public float distance(Position other) {
        return Utils.eularDistance(this.x, this.y, this.z, other.x, other.y, other.z);
    }

    // put object to specific position
    public Position(float x, float y, float z) {
        // game map in a [0, 100] space
        if (x < 0 && y < 0 && z < 0) {
            this.x = 0;
            this.y = 0;
            this.z = 0;
        } else if (x > 100 && y > 100 && z > 100) {
            this.x = 100;
            this.y = 100;
            this.z = 100;
        } else {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(" + x + "," + y + "," + z + ")";
    }
}
