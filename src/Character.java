public abstract class Character {
    protected String name;
    protected int health;
    protected int baseAttack;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.baseAttack = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public abstract int getAttackPower();

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " took " + damage + " damage. Health now: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.getName() + " for " + this.attackPower + " damage!");
        target.takeDamage(this.baseAttack);
    }

    public void flee() {
        System.out.println(this.name + " attempts to flee from battle!");
    }
}


