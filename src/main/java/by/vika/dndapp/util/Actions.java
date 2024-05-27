package by.vika.dndapp.util;

import by.vika.dndapp.goblin.Goblin;

public class Actions {

    // Main method to activate actions on a Goblin instance
    public void activateActions(Goblin goblin) {
        Math.random();
        while (checkAlive(goblin)) { // Continue while goblin is alive
            int eventNumber = (int) (Math.random() * 100); // Generate random event number
            if (eventNumber >= 0 && eventNumber < 10) {
                haltEvent(goblin);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                travel(goblin);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                longHaltEvent(goblin);
            } else if (eventNumber >= 30 && eventNumber < 40) {
                stealPotion(goblin);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                drankAle(goblin);
            } else if (eventNumber >= 50 && eventNumber < 60) {
                foundBerries(goblin);
            } else if (eventNumber >= 60 && eventNumber < 70) {
                banditsAttack(goblin);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                curse(goblin);
            } else if (eventNumber >= 80 && eventNumber < 90) {
                dungeon(goblin);
            } else if (eventNumber >= 90 && eventNumber < 100) {
                eatSupplies(goblin);
            }
        }
    }

    // Ensure stat does not exceed 100
    private int moreHundred(int stat) {
        if (stat > 100) {
            stat = 100;
        }
        return stat;
    }

    // Ensure stat does not fall below 0
    private int lessZero(int stat) {
        if (stat < 0) {
            stat = 0;
        }
        return stat;
    }

    // Event: Goblin rests and gains energy
    private void haltEvent(Goblin goblin) {
        int energy = goblin.getEnergy();
        energy += 10;
        energy = moreHundred(energy);

        goblin.setEnergy(energy);
        checkEnergy(goblin);
        System.out.println("Гоблин сделал привал и восстановил ману. Текущий запас энергии: " + goblin.getEnergy());
    }

    // Event: Goblin takes a long rest and gains more energy
    private void longHaltEvent(Goblin goblin) {
        int energy = goblin.getEnergy();
        energy += 20;
        energy = moreHundred(energy);

        goblin.setEnergy(energy);
        checkEnergy(goblin);
        System.out.println("Гоблин совершил длительный отдых и восстановил ману. Текущий запас энергии: " + goblin.getEnergy());
    }

    // Event: Goblin travels and loses some energy
    private void travel(Goblin goblin) {
        int energy = goblin.getEnergy();
        energy -= 5;
        energy = lessZero(energy);
        goblin.setEnergy(energy);
        checkEnergy(goblin);
        System.out.println("Гоблин путешествовал зря, новых предметов не получено! Текущий запас сил:" + goblin.getEnergy());
    }

    // Event: Goblin steals a potion and gains health
    private void stealPotion(Goblin goblin) {
        int energy = goblin.getEnergy();
        int health = goblin.getHealth();
        energy -= 10;
        energy = lessZero(energy);
        health += goblin.getManaCoe() * 4;
        health = moreHundred(health);
        goblin.setEnergy(energy);
        goblin.setHealth(health);
        checkEnergy(goblin);

        System.out.println("Гоблину удалось украсть зелье и восстановить немного здоровья. Текущий запас сил: " + goblin.getEnergy() + " Текущий запас здоровья: " + goblin.getHealth());
    }

    // Event: Goblin drinks ale and gains health
    private void drankAle(Goblin goblin) {
        int energy = goblin.getEnergy();
        int health = goblin.getHealth();
        energy -= 8;
        energy = lessZero(energy);
        health += goblin.getManaCoe() * 3;
        health = moreHundred(health);
        goblin.setEnergy(energy);
        goblin.setHealth(health);
        checkEnergy(goblin);
        System.out.println("Гоблин добрел до таверны, добрый человек всегда угостит путешествиника элем. Текущий запас сил: " + goblin.getEnergy() + " Текущий запас здоровья: " + goblin.getHealth());
    }

    // Event: Goblin finds berries and gains health
    private void foundBerries(Goblin goblin) {
        int energy = goblin.getEnergy();
        int health = goblin.getHealth();
        energy -= 4;
        energy = lessZero(energy);
        health += goblin.getManaCoe() * 2;
        health = moreHundred(health);
        goblin.setEnergy(energy);
        goblin.setHealth(health);
        checkEnergy(goblin);
        System.out.println("Гоблин нашел немного ягод, надеюсь они не ядовитые. Текущий запас сил: " + goblin.getEnergy() + " Текущий запас здоровья: " + goblin.getHealth());
    }

    // Event: Goblin eats supplies and gains a small amount of health
    private void eatSupplies(Goblin goblin) {
        int energy = goblin.getEnergy();
        int health = goblin.getHealth();
        energy -= 1;
        energy = lessZero(energy);
        health += goblin.getManaCoe();
        health = moreHundred(health);
        goblin.setEnergy(energy);
        goblin.setHealth(health);
        checkEnergy(goblin);
        System.out.println("Гоблин поел припасы из сумки, не вкусно, но кому жизнь сахар. Текущий запас сил: " + goblin.getEnergy() + " Текущий запас здоровья: " + goblin.getHealth());
    }

    // Event: Goblin is attacked by bandits and loses health
    private void banditsAttack(Goblin goblin) {
        int health = goblin.getHealth();
        health -= 20;
        health = lessZero(health);
        goblin.setHealth(health);
        System.out.println("Не повезло, на гоблина напали степны бандиты. Текущий запас здоровья:" + goblin.getHealth());
    }

    // Event: Goblin is cursed and loses a significant amount of health
    private void curse(Goblin goblin) {
        int health = goblin.getHealth();
        health -= 30;
        health = lessZero(health);
        goblin.setHealth(health);
        System.out.println("Гоблин нашел волшебный предмет, теперь он проклят. Текущий запас здоровья:" + goblin.getHealth());
    }

    // Event: Goblin enters a dungeon and loses a large amount of health
    private void dungeon(Goblin goblin) {
        int health = goblin.getHealth();
        health -= 50;
        health = lessZero(health);
        goblin.setHealth(health);
        System.out.println("Гоблин забрел в подземелье, его вышвырнули на входе. Текущий запас здоровья:" + goblin.getHealth());
    }

    // Check if goblin is alive (health > 0)
    private boolean checkAlive(Goblin goblin) {
        return goblin.getHealth() > 0;
    }

    // Check goblin's energy and reduce health if energy is zero
    private void checkEnergy(Goblin goblin) {
        if (goblin.getEnergy() <= 0) {
            int health = goblin.getHealth();
            health -= 5;
            health = lessZero(health);
            goblin.setHealth(health);
        }
    }
}
