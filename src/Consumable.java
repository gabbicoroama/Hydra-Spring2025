public class Consumable extends Item{
   // private int uses; //
    private int healingPoints;
    public Consumable(String itemID, String itemName, String itemDescription, String tag, String location, int healingPoints) {
        super(itemID, itemName, itemDescription, tag, location);
       // this.uses=uses;
        this.healingPoints=healingPoints;
    }

    public int getHealingPoints() {
        return healingPoints;
    }
}
