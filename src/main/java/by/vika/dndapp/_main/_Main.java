package by.vika.dndapp._main;

import by.vika.dndapp.goblin.Goblin;
import by.vika.dndapp.util.Actions;

public class _Main {
    public static void main(String[] args) {
        Goblin goblin = new Goblin(); // Create a new Goblin instance
        Actions actions = new Actions(); // Create a new Actions instance
        actions.activateActions(goblin); // Activate actions on the Goblin instance
    }
}
