public class Weapon extends Item {
    private int damagePoints;
   // private int amount;
    public Weapon(int itemID, String itemName, String itemDescription, String tag, String location, int damagePoints) {
        super(itemID, itemName, itemDescription, tag, location);
        //this.amount=amount;
        this.damagePoints=damagePoints;
    }
}
