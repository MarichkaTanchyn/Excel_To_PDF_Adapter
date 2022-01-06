package sklep;

public class Money {
    private final int integerPart;
    private final int doublePart;

    public Money(int integerPart, int doublePart) {
        this.integerPart = integerPart;
        this.doublePart = doublePart;
    }

    public Money add(Money money) {
        int newIntegerPart = this.integerPart + money.getIntegerPart();
        int newDoublePart = this.doublePart + money.getDoublePart();

        if (newDoublePart >= 100) {
            newIntegerPart++;
            newDoublePart-= 100;
        }

        return new Money(newIntegerPart, newDoublePart);
    }

    public Money subtract(Money money) {
        int newIntegerPart = this.integerPart - money.getIntegerPart();
        int newDoublePart = this.doublePart - money.getDoublePart();

        if (newDoublePart < 0) {
            newIntegerPart--;
            newDoublePart += 100;
        }

        return new Money(newIntegerPart, newDoublePart);
    }

    public int getIntegerPart() {
        return integerPart;
    }

    public int getDoublePart() {
        return doublePart;
    }

    public Money multiply(int factor) {
        int newIntegerPart = this.integerPart * factor;
        int newDoublePart = this.doublePart * factor;

        if (newDoublePart >= 100) {
            newIntegerPart++;
            newDoublePart -= 100;
        }

        return new Money(newIntegerPart, newDoublePart);
    }

    @Override
    public String toString() {
        return integerPart + "." + doublePart + " PLN";
    }
}
