/**
 * @version date: 2018-09-04
 * @author Anas Farooq Gauba
 */
public enum TileNums {
    ONE("1", 1), TWO("2", 2), THREE("3", 3),
    FOUR("4", 4), FIVE("5", 5), SIX("6", 6),
    SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9),
    TEN("10", 10), ELEVEN("11", 11), TWELVE("12", 12),
    THIRTEEN("13", 13), JOKER("25", 25);

    private final String value;
    private final int num;

    TileNums(String value, int num) {
        this.value = value;
        this.num = num;
    }

    public String toString() {
        return this.value;
    }
    public int toInt() {
        return this.num;
    }
}
