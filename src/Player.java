import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Iterator;


//Instance variables and attributes
public class Player extends Character {
    private Room currentRoom;
    private List<Items> inventory;
    private int maxHP;
    private Items equippedItem;

    //constructor to initialize player with a name and starting room
    public Player(String name, int health, int attackPower, Room startingRoom) {
        super(name, health, attackPower);
        this.currentRoom = startingRoom;
        this.maxHP = health;
        this.inventory = new ArrayList<>();
    }

    //Getters


    public Room getCurrentRoom() {

        return currentRoom;
    }

    public List<Items> getInventory() {

        return inventory;
    }

    public Items getEquippedItem() {

        return equippedItem;
    }

    public int getCurrentHP() {

        return health;
    }

    @Override
    public int getAttackPower() {
        int boost = (equippedItem != null) ? equippedItem.getAttackPower() : 0;
        return attackPower + boost;
    }

    public int getEffectiveAttackPower() {
        Random rand = new Random();
        int roll = rand.nextInt(100); // 0–99
        if (roll < 25) { // 25% chance to crit.
            System.out.println("Critical hit!");
            return getAttackPower() * 2;
        }
        return getAttackPower(); // normal hit
    }

    //Setter to change players current room
    public void setCurrentRoom(Room newRoom) {

        this.currentRoom = newRoom;
    }

    //Method to move player in direction
    public void move(String direction, Map<Integer, Room> rooms) {
        //Validate direction and room exits
        if (currentRoom.getExits().containsKey(direction)) {
            int nextRoomNumber = currentRoom.getExits().get(direction);
            //Check if the next room exists in the map
            if (rooms.containsKey(nextRoomNumber)) {
                //move player to new room
                currentRoom = rooms.get(nextRoomNumber);
                System.out.println("You moved " + direction + " to" + currentRoom.getName());
            } else {
                System.out.println("You can't go that way!");
            }
        }
    }

    //method to pickup item form current room
    public void pickUpItem(String itemName) {
        if (currentRoom.hasItem(itemName)) { // Prevent adding null/empty items
            Items item = currentRoom.getItem(itemName);
            inventory.add(item);
            currentRoom.removeItem(itemName);
            System.out.println(itemName + " was added to Inventory");
        } else {
            System.out.println("Item not found in room");
        }
    }

    // Method to remove an item from the player's inventory
    public void inspectItem(String itemName) {
        for (Items item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                System.out.println("Item:" + item.getName());
                System.out.println("Description:" + item.getItemDescription());
                System.out.println("Attack Boost:" + item.getAttackPower());

                return;
            }
        }

        System.out.println("Item not in inventory");

    }
    //Method to drop item

    public void dropItem(String itemName) {
        Iterator<Items> iterator = inventory.iterator();
        while (iterator.hasNext()) {
            Items item = iterator.next();
            if (item.getName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                currentRoom.addItem(item);
                System.out.println(itemName + " has been dropped from inventory");
                return;
            }
        }
        System.out.println("You don't have that item");

    }

    // Method to display the player's inventory
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: ");
            for (Items item : inventory) {
                System.out.println(item.getName() + ":" + item.getItemDescription());
            }
        }
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
        System.out.println("You were hit and lost " + amount + " HP! Current HP: " + health);
    }


    //method to equip or unequip items
    public void equipItem(String itemName) {
        for (Items item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName) && item.getAttackPower() > 0) {
                if (equippedItem != null) {
                    equippedItem.setEquipped(false);
                }
                equippedItem = item;
                item.setEquipped(true);
                System.out.println(item.getName() + " equipped. Attack boosted by " + item.getAttackPower());
                return;
            }
        }
        System.out.println("No such weapon item found in inventory.");
    }

    public void unEquipItem() {
        if (equippedItem != null) {
            System.out.println(equippedItem.getName() + " has been unequipped");
            equippedItem.setEquipped(false);
            equippedItem = null;
        } else {
            System.out.println("No item is currently equipped");
        }
    }


    public void heal(String itemName) {
        for (Items item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName) && item.getHealPoints() > 0) {
                health = Math.min(maxHP, health + item.getHealPoints());
                System.out.println("You healed " + item.getHealPoints() + " HP. Current HP: " + health);
                inventory.remove(item);
                return;
            }
        }
        System.out.println("No healing item found in inventory");
    }
}