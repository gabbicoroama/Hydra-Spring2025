public class Weapon extends Items{
    private int damagePoints;
    private int amount;
    public Weapon(int itemID, String itemName, String itemDescription, String tag, String location, int amount, int damagePoints) {
        super(itemID, itemName, itemDescription, tag, location);
        this.amount=amount;
        this.damagePoints=damagePoints;
    }
}
