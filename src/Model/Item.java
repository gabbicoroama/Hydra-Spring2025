package Model;

/**
 * Items:
 * Define item properties: Items can be consumables, weapons, keys, or artifacts, each having unique traits such as value and effects.
 * Support gameplay interaction: Items can boost player stats, heal damage, or require completing specific objectives.
 * Exists in various contexts: Items can be found in rooms or stored in player’s inventory, must be portable and independent
 */
public class Item {
    private String itemID;
    private String itemName;
    private String itemDescription;
    //private int healPoints; //consumables attribute
    private String tag; //itemType
    // private int damagePoints; //weapons attribute
    // private boolean equipped = false; //player attribute
    private String roomID; //itemRegion
    //private String name; //already have itemName
    private boolean equipped; //can delete

    //change
    public Item(String itemID, String itemName, String itemDescription, String tag, String roomID) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.tag = tag;
        this.roomID = roomID;
        this.equipped = false;
    }

    public String getItemID() {

        return itemID;
    }

    public String getItemName() {

        return itemName;
    }

    public String getItemDescription() {

        return itemDescription;
    }


    public String getTag() {
        return tag;
    }


    public String getRoomID() {
        return roomID;
    }

    public String getName() {
        return itemName;

    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public boolean isEquipped() {
        return equipped;
    }

}

