package by.vika.dndapp.goblin;

public class Goblin {
    // Initialize goblin attributes
    private int health = 100;
    private int energy = 100;
    private int mana_coe = 3;

    // Setter for health
    public void setHealth(int health) {
        this.health = health;
    }

    // Getter for health
    public int getHealth() {
        return this.health;
    }

    // Setter for energy
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    // Getter for energy
    public int getEnergy() {
        return this.energy;
    }

    // Getter for mana coefficient
    public int getManaCoe() {
        return this.mana_coe;
    }
}
