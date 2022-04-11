package utils;
import java.security.SecureRandom;

import sprite.Position;

public class Utils {
    private Utils() {
        // Utils class donot have any instance
    }

    // calculate the eular distance between two 3D points
    public static float eularDistance(float x1, float y1, float z1, float x2, float y2, float z2) {
        return (float) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }

    // random shuffle the enum
    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static Position randPosition() {
        Position position = new Position();
        position.x = (float) Math.random() * 100;
        position.y = (float) Math.random() * 100;
        position.z = (float) Math.random() * 100;
        return position;
    }
}
