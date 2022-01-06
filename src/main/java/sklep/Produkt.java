package sklep;

public class Produkt {

    private final int id;
    private final String nazwa;
    private final Money cena;
    private final int quantity;

    public Produkt(int id, String nazwa, Money cena, int quantity) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Money getCena() {
        return cena;
    }

    public int getQuantity() {
        return quantity;
    }
}
