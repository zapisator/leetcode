import lombok.RequiredArgsConstructor;

public class ParkingSystem {

    private final int[] parkingSpace;
    private static final int BIG = 1;
    private static final int MEDIUM = 2;
    private static final int SMALL = 3;

    public ParkingSystem(int big, int medium, int small) {
        parkingSpace = new int[4];
        parkingSpace[BIG] = big;
        parkingSpace[MEDIUM] = medium;
        parkingSpace[SMALL] = small;
    }

    public boolean addCar(int carType) {
        if (parkingSpace[carType] > 0) {
            parkingSpace[carType]--;
            return true;
        }
        return false;
    }
}
