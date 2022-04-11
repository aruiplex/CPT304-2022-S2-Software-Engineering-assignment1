package sprite;
import utils.Utils;

public abstract class Sprite {
    public Position position = Position.random();

    // Adapter pattern
    public float distance(Sprite other) {
        return Utils.eularDistance(this.position.x, this.position.y, this.position.z, other.position.x,
                other.position.y, other.position.z);
    }
}
