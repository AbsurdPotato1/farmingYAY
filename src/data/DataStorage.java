package data;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable {
    //apparently we are not using these
//    int level;
//    int maxLife;
//    int life;
//    int maxMana;
//    int strength;
//    int dexterity;
//    int exp;
//    int nextLevelExp;
//    int coin;

    //player inventory
    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Integer> itemAmounts = new ArrayList<>();

    public DataStorage(){

    }
    String mapObjectNames[][];
    int mapObjectWorldX[][];
    int mapObjectWorldY[][];
    String mapObjectLootNames[][];
    boolean mapObjectOpened[][];

}
