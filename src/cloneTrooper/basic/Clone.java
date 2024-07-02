package cloneTrooper.basic;

import java.util.ArrayList;
import java.util.Random;

public class Clone {

    public String cloneClass;
    public String cloneRank;
    public String cloneAlias;
    public String cloneNumber;
    public String cloneNickname;
    public int diceRoll;
    public boolean chanceToBeHighRanking;

    public ArrayList<Clone> cloneCollection = new ArrayList<>();
    
    public Clone(String cloneNumber, String cloneClass, String cloneRank, String cloneAlias, String cloneNickname) {
        this.cloneNumber = cloneNumber;
        this.cloneClass = cloneClass;
        this.cloneRank = cloneRank;
        this.cloneAlias = cloneAlias;
        this.cloneNickname=cloneNickname;
    }

    public String generateCloneNumber() {
        this.cloneNumber = String.valueOf((int) Math.floor(Math.random() * 5001));
        return cloneNumber;
    }

    public int rollDice() {
        diceRoll = (int) Math.floor(Math.random() * 10);
        return diceRoll;
    }

    public boolean decideHighRankingOrNot() {
        this.rollDice();
        if (diceRoll > 8) {
            this.chanceToBeHighRanking = true;
        } else {
            this.chanceToBeHighRanking = false;
        }
        return chanceToBeHighRanking;
    }

    public void generateCloneClass() {
        this.decideHighRankingOrNot();
        String[] elitecloneClassCollection = {"ARC", "Null ARC", "Alpha ARC", "CC"};
        String[] cloneClassCollection = {"Assault", "Clone", "Pilot", "Heavy", "Medic", "Galactic Marine"};
        String[] elitecloneRanks = {"Captain", "Commander", "General"};
        String[] cloneRanks = {"Sergeant", "Private", "Lieutenant", "NCO", "Corporal"};
        String[] eliteCloneAlias = {"CC", "ARC", "Null ARC", "Alpha ARC"};
        String[] cloneAlias = {"CT"};

        if (this.chanceToBeHighRanking) {
            this.cloneClass = elitecloneClassCollection[(int) Math.floor(Math.random() * elitecloneClassCollection.length)];
            this.cloneRank = elitecloneRanks[(int) Math.floor(Math.random() * elitecloneRanks.length)];
            this.cloneAlias = eliteCloneAlias[(int) Math.floor(Math.random() * eliteCloneAlias.length)];
        } else {
            this.cloneClass = cloneClassCollection[(int) Math.floor(Math.random() * cloneClassCollection.length)];
            this.cloneRank = cloneRanks[(int) Math.floor(Math.random() * cloneRanks.length)];
            this.cloneAlias = cloneAlias[(int) Math.floor(Math.random() * cloneAlias.length)];
        }
    }
    
    public String generateCloneNickname() {
        String[] cloneNamesCollection = {
            "Pro", "Juss", "Dryddon", "Ertag", "Vongyrk", "Blattynks", "Drive", "Lom", "Crof", "Orgec",
            "Jeek", "Brivinks", "Turrass", "Fire", "Gree", "Kree", "Uppez", "Echo", "Fives", "Rex", "Cody",
            "Jesse", "Hardcase", "Kix", "Tup", "Dogma", "Wolffe"
        };
        this.cloneNickname = cloneNamesCollection[new Random().nextInt(cloneNamesCollection.length)];
        return cloneNickname;
    }


    
    public void createCloneTrooper() {
        for (int i = 0; i < 11; i++) {
            this.generateCloneClass();
            this.generateCloneNumber();
            this.generateCloneNickname();
            
            Clone trooper = new Clone(cloneNumber, cloneClass, cloneRank, cloneAlias, cloneNickname);
            this.cloneCollection.add(trooper);
        }
        
        for (Clone clone : cloneCollection) {
            System.out.println(clone.toString());
        }
    }
    
    @Override
    public String toString() {
        return "[" + cloneAlias + "-" +  cloneNumber + " " + cloneNickname + ", Class= " + cloneClass  + ", Rank= " + cloneRank  +
                "]";
    }
}
