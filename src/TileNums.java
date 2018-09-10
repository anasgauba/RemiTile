/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public enum TileNums {
    ONE(1), TWO(2), THREE(3),
    FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9),
    TEN(10), ELEVEN(11), TWELVE(12),
    THIRTEEN(13), JOKER(25);

    private final int value;

    private TileNums(int value) {
        this.value = value;
    }
}
