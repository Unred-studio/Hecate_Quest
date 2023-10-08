//Documentation Comment
/*
 @name: Aaditya K
 @date: Oct 3, 2023
 @version: 0.1.0
 @detail: Creating a fantasy RPG game
 */
import java.util.Scanner;
import java.util.Random;

public class HecateQuest {
    //Declaring scanner object and random object at the class level so every method can use it
    private static Scanner scan = new Scanner(System.in);
    private static Random rand = new Random();

    //similarly declaring condition, playerHp and opponentHp
    private static boolean condition;
    private static int[] hp;
    //private static int playerHp;
    //private static int opponentHp;


    public static void main(String[] args) {
        //for main method, it just call the game methd and nothing else
        game();
    }
    public static void game() {

        //call the menu method and check what user want; story or playgame or exit
        do {
            condition = false;
            //userChoice contain the user typed letter in upper case
            char userChoice = menu().toUpperCase().charAt(0);
            if (userChoice == 'P') {
                playGame();
            } else if(userChoice == 'S') {
                story();
            } else if(userChoice == 'E') {
                break;
            } else {
                System.out.println("Plese Enter the vaild char");
                //defaultly the condition is false but in case user doesn't give neccessary input, it turn true again to loop the do while statement
                condition = true;
            }
        } while(condition);
    }


    //menu method, ask the user to choice between playgame or story or exit, after losing the player shall reach to this method
    public static String menu() {
        //this method is defined at the end of program and help to clear the terminal
        clearTerminal();
        System.out.println("");
        System.out.println("PlayGame[p]");
        System.out.println("Story[s]");
        System.out.println("Exit[e]");
        System.out.print("Your Choice: ");
        String menuChoice = scan.nextLine();
        //menu takes no input but return the user's choice to game method 
        return menuChoice;
    }

    //the method story is called if user select to view story from menu option
    public static void story() {
        //before story the terminal should be clear for apperance purposely
        clearTerminal();
        //the whole basic story will be shown on the terminal
        System.out.println("");
        System.out.println("You are the Goddess of Magic, Hecate.");
        System.out.println("One day, you made a mistake while brewing a potion from a poisonous plant.");
        System.out.println("Unfortunately, this potion spread throughout Olympus.");
        System.out.println("All the gods who smelled it became uncontrollable and started to wreak havoc on Earth.");
        System.out.println("It is now your responsibility to protect the Earth by stopping these rogue gods.");
        System.out.println("Your powers are:");
        System.out.println("- Healing (Heal your HP to 100, only if it's below 10)");
        System.out.println("- Elemental Manipulation (Fire, Water, Air, Earth)");
        System.out.println("- Necromancy (Summon the spirits from underworld)");
        System.out.println("- Illusion (prevents opponents from attacking by creating a illusion)");
        System.out.println("Your main mission is to take on the rogue gods, defeat them using your powers.");
        System.out.println("Good luck, Hecate! The fate of Earth lies in your hands.");
        System.out.println("");

        //at the end of story, as the user if they want to play the game
        do {
            condition = false;
            System.out.println("Are you ready to start the game[y/n]: ");
            String ready = scan.nextLine();

            //if they want to play the game, it will call playGame method
            if(ready.charAt(0) == 'y') {
                playGame();
            }
            //if not then return to menu
            else if(ready.charAt(0) == 'n') {
                menu();
            } else {
                System.out.println("Plese Enter the vaild char in smaller case");
                condition = true;
            }
        } while(condition);

    }


    //after the story(or directly from menu) the player comes to playGame method
    public static void playGame() {
        //clear the terminal containing the story or menu
        clearTerminal();
        //after the story(or directly from menu) the player comes to playGame method
        //the if statements is used such that the player can only go to next level if he has defeated the god of current level
        //game start with Ares
        if(ares()) {
            //after defeating Ares you will fight with the  Artemis
            if(artemis()) {
                //After defeating Artemis, you will fight with the Hades
                if(hades()) {
                    //After defeating Hades, you will fight with the Apollo
                    if(apollo()) {
                        //After defeating Apollo, you will fight with Zeus
                        if(zeus()) {
                            //basic you won message, called using the victory method
                            //victory();
                        } else {
                            //If lost then prompt to ask if want to leave to menu or play again
                            System.out.println("You lost the battle with zeus");
                            System.out.println("Would you like to exit[0] or play again[1]: ");
                            int choice = scan.nextInt();
                            if (choice == 1) {
                                playGame();
                            }
                            else  {
                                menu();
                            }
                        }
                    } else {
                        //If lost then prompt to ask if want to leave to menu or play again
                         System.out.println("You lost the battle with Apollo");
                            System.out.println("Would you like to exit[0] or play again[1]: ");
                            int choice = scan.nextInt();
                            if (choice == 1) {
                                playGame();
                            }
                            else  {
                                menu();
                            }
                    }
                } else {
                    //If lost then prompt to ask if want to leave to menu or play again
                    System.out.println("You lost the battle with Hades");
                            System.out.println("Would you like to exit[0] or play again[1]: ");
                            int choice = scan.nextInt();
                            if (choice == 1) {
                                playGame();
                            }
                            else  {
                                menu();
                            }
                }
            } else {
                //If lost then prompt to ask if want to leave to menu or play again
                System.out.println("You lost the battle with Artemis");
                            System.out.println("Would you like to exit[0] or play again[1]: ");
                            int choice = scan.nextInt();
                            if (choice == 1) {
                                playGame();
                            }
                            else  {
                                menu();
                            }
            }
        } else {
            //If lost then prompt to ask if want to leave to menu or play again
            System.out.println("You lost the battle with Ares");
                            System.out.println("Would you like to exit[0] or play again[1]: ");
                            int choice = scan.nextInt();
                            if (choice == 1) {
                                playGame();
                            }
                            else  {
                                menu();
                            }
        }
    }




    //Level 1: Heacte Vs Ares
    public static boolean ares() {
        //the string god is used to let the other repeatative methods know that it is called for ares so keep the story in accord
        String god = "Ares";

        //clearing the terminal to improve visual 
        clearTerminal();
        //basic introduction for the god and the battle
        System.out.println("Welcome to the Battle Ground!");
        System.out.println("Here, you will face a fierce fight with Ares, the God of War.");
        System.out.println("Prepare for a battle of strength and strategy!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.println("");
            System.out.println("Are you ready?[y/n]: ");
            String ready = scan.nextLine();

            //if they want to play, it does nothing, just let the player pass
            if(ready.charAt(0) == 'y') {
            }
            //if not then return to menu
            else if(ready.charAt(0) == 'n') {
                menu();
            } else {
                System.out.println("Plese Enter the vaild char in smaller case");
                condition = true;
            }
        } while(condition);

        //this calls the fight method which is same for all god, it changes by which god's varible is provide and returns a boolean if the player defeated the god
        if(fight(god)) {
            return true;
        }
        // if the player lose then return false which further call the menu method and
        else {
            return false;
        }
    }



    //all things are same as ares method, just the story and god has changed to artimes
    public static boolean artemis() {
        String god = "Artemis";

        //clearing the terminal to improve visual 
        clearTerminal();

        //introduction to god
        System.out.println("\nWelcome to the Jungles!");
        System.out.println("Here, you will confront Artemis, the Goddess of the Hunt.");
        System.out.println("Navigate through the dense wilderness and prove your mettle!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.println("Are you ready?[y/n]: ");
            String ready = scan.nextLine();

            //if they want to play, it doesnnothing, just let the player pass
            if(ready.charAt(0) == 'y') {
            }
            //if not then return to menu
            else if(ready.charAt(0) == 'n') {
                menu();
            } else {
                System.out.println("Plese Enter the vaild char in smaller case");
                condition = true;
            }
        } while(condition);

        if(fight(god)) {
            return true;
        } else {
            return false;
        }
    }

    //all things are same as ares method, just the story and god has changed to hades
    public static boolean hades() {
        String god = "Hades";

        //clearing the terminal to improve visual 
        clearTerminal();
        //introduction to god
        System.out.println("\nWelcome to the Underworld!");
        System.out.println("In this dark realm, you will clash with Hades, the God of the Underworld.");
        System.out.println("Face the shadows and the undead in your quest!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.println("Are you ready?[y/n]: ");
            String ready = scan.nextLine();

            //if they want to play, it doesnnothing, just let the player pass
            if(ready.charAt(0) == 'y') {
            }
            //if not then return to menu
            else if(ready.charAt(0) == 'n') {
                menu();
            } else {
                System.out.println("Plese Enter the vaild char in smaller case");
                condition = true;
            }
        } while(condition);


        if(fight(god)) {
            return true;
        } else {
            return false;
        }
    }

    //all things are same as ares method, just the story and god has changed to apollo
    public static boolean apollo() {
        String god = "Apollo";

        //clearing the terminal to improve visual 
        clearTerminal();
        //intro to god
        System.out.println("\nWelcome to the Sunlit Realm!");
        System.out.println("Prepare to challenge Apollo, the God of the Sun and Music.");
        System.out.println("Bask in the sunlight and harness the power of music and light!");

//waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.println("Are you ready?[y/n]: ");
            String ready = scan.nextLine();

            //if they want to play, it doesnnothing, just let the player pass
            if(ready.charAt(0) == 'y') {
            }
            //if not then return to menu
            else if(ready.charAt(0) == 'n') {
                menu();
            } else {
                System.out.println("Plese Enter the vaild char in smaller case");
                condition = true;
            }
        } while(condition);

        if(fight(god)) {
            return true;
        } else {
            return false;
        }
    }


    //all things are same as ares method, just the story and god has changed to zeus
    public static boolean zeus() {
        String god = "Zeus";

        //clearing the terminal to improve visual 
        clearTerminal();
        //intro to god
        System.out.println("\nWelcome to Mount Olympus!");
        System.out.println("You have reached the home of the gods.");
        System.out.println("Now, confront Zeus, the King of the Gods, and bring order to Olympus!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.println("Are you ready?[y/n]: ");
            String ready = scan.nextLine();

            //if they want to play, it doesnnothing, just let the player pass
            if(ready.charAt(0) == 'y') {
            }
            //if not then return to menu
            else if(ready.charAt(0) == 'n') {
                menu();
            } else {
                System.out.println("Plese Enter the vaild char in smaller case");
                condition = true;
            }
        } while(condition);

        if(fight(god)) {
            return true;
        } else {
            return false;
        }
    }




    //the same fight will be called for each level, execpt the argument of god will change which will help to give unique attack name to each god
    public static boolean fight(String god) {

        //Before each battle, both player's hp shall be 100 (index 0 is for playerHp and index 1 is for opponent's Hp)
         hp[0] = 100;
         hp[1] = 100;
         //using the winner to store the result of match
        boolean winner = false;
    
        //the loop repeats until the hp or both of them is above 0
        //the condition never get false as if one of them get below 0, the other one win and loop break
        while (hp[0] > 0 && hp[1] > 0) {

            clearTerminal();

            // Player's turn to attack
            //announcing the hp of player and opponent 
            System.out.println("Hacate's Hp: " + hp[0]);
            System.out.println(god + "'s Hp: " + hp[1]);
            //calling the player attack method 
            hp = playerAttack(hp);
    
            // Check if the opponent's HP has reached 0 or less
            if (hp[1] <= 0) {
                winner = true;
                break;
            }
    
            // Opponent's turn to attack
            hp = opponentAttack(god, hp);
    
            // Check if the player's HP has reached 0 or less
            if (hp[0] <= 0) {
                winner = false;
                break;
            }
        }
    
        return winner;
    }




    //the method design for player to choice the attack of their choice
    public static int[] playerAttack(int[] hp) {

        //print all the attacks
        System.out.println("");
        System.out.println("Please choice your attack: ");
        System.out.println("Elemental Manupulation [Fire(f), Water(w), Earth(e), Air(a)]");
        System.out.println("Illution[i]");
        System.out.println("Necromancy[n]");
        System.out.println("Healing[h]");
        //ask for which attack to choice 
        do {
            condition = false;
            System.out.println("");
            System.out.println("Enter your choice: ");
            String attack = scan.nextLine();

            if(attack.charAt(0) == 'f') {
                int[1] = lowAttack(int[1]);
            } else if(attack.charAt(0) == 'w') {
                int[1] = lowAttack(int[1]);
            } else if(attack.charAt(0) == 'e') {
                int[1] = lowAttack(int[1]);
            } else if(attack.charAt(0) == 'a') {
                int[1] = lowAttack(int[1]);
            } else if(attack.charAt(0) == 'i') {
                stun();
            } else if(attack.charAt(0) == 'n') {
                int[1] = heavyAttack(int[1]);
            } else if(attack.charAt(0) == 'h') {
                System.out.println("Hecate restored its Hp to 100");
                int[0] = heal(int[0]);
            } else {
                System.out.println("Please enter the valid char");
                condition = true;
            }
        } while(condition);

        //return opponet's hp only 
        return hp;
    }


    //opponent attack check which god is fighting and call the particular method of that god
    public static int[] opponentAttack(String god, int[] hp) {
        if (god.equals("Ares")) {
            hp = aresAttack(hp);
        } else if (god.equals("Artemis")) {
            hp = artemisAttack(hp);
        } else if (god.equals("Hades")) {
            hp = hadesAttack(hp);
        } else if (god.equals("Apollo")) {
            hp = apolloAttack(hp);
        } else {
            hp = zeusAttack(hp);
        }
        //at last return player's hp
        return hp;
    }

    //below are all the basic attacks(unmodified, can be used by anyone)

    //healing restore hp to 100
    public static int heal(int initalHp) {
        initalHp = 100;
        return initalHp;
    }

    //heavy attack, decrease the provided hp by 45
    public static int heavyAttack(int opponentHp) {
        opponentHp-= 45;
        return opponentHp;
    }

    //low attack, decrease the provided hp by 10
    public static int lowAttack(int opponentHp) {
        opponentHp-= 10;
        return opponentHp;
    }

    //med attack, decrease the provided hp by 25
    public static int medAttack(int opponentHp) {
        opponentHp-= 25;
        return opponentHp;
    }

    //STUN
    public static void stun() {
        //NEED TO THINK SOMTHING FOR THIS
    }



    //attack of each god starts from here, everything thing is same for each god execpt for the attack type

 // Ares
public static int[] aresAttack(int[] hp) {

    int probability = rand.nextInt(100);

    // Low Attack (0-50)
    if (probability < 50) {
        System.out.println("Ares charges with a fury, dealing 10 damage!");
        hp[0] = lowAttack(hp[0]);
    }
    // Heavy Attack (90-99)
    else if (probability < 99 && probability > 90) {
        System.out.println("Ares enters a berserk rage, smashing for 45 damage!");
        hp[0] = heavyAttack(hp[0]);
    }
    // Tactical Strike (50-70)
    else if (probability < 70 && probability > 50) {
        System.out.println("Ares strikes swiftly, hitting you three times for 25 damage!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Battle Cry (70-90)
    else {
        System.out.println("Ares lets out a deafening Battle Cry, leaving you stunned!");
        stun();
    }

    return hp;
}

// Artemis
public static int[] artemisAttack(int[] hp) {

    int probability = rand.nextInt(100);

    // Medium Attack (0-50)
    if (probability < 50) {
        System.out.println("Artemis summons rapid Wild Growth, causing 25 damage!");
        hp[0] = medAttack(hp[0]);
    }
    // Heavy Attack (90-99)
    else if (probability < 99 && probability > 90) {
        System.out.println("Artemis harnesses Moonlight energy, dealing 45 damage!");
        hp[0] = heavyAttack(hp[0]);
    }
    // Sylvan Arrows (50-70)
    else if (probability < 70 && probability > 50) {
        System.out.println("Artemis fires a barrage of Sylvan Arrows, each dealing 10 damage!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Evasion (70-90)
    else {
        System.out.println("Artemis gracefully evades your attack, leaving you stunned!");
        stun();
    }

    return hp;
}

// Hades
public static int[] hadesAttack(int[] hp) {

    int probability = rand.nextInt(100);

    // Medium Attack (0-50)
    if (probability < 50) {
        System.out.println("Hades summons the undead, causing 25 damage!");
        hp[0] = medAttack(hp[0]);
    }
    // Heavy Attack (90-99)
    else if (probability < 99 && probability > 90) {
        System.out.println("Hades releases a powerful Necrotic Blast, dealing 45 damage!");
        hp[0] = heavyAttack(hp[0]);
    }
    // Cursed Ground (50-70)
    else if (probability < 70 && probability > 50) {
        System.out.println("Hades makes the ground unbearable, causing 10 damage!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Spectral Chain (70-90)
    else {
        System.out.println("Hades throws a spectral chain, preventing your next attack!");
        stun();
    }

    return hp;
}

// Apollo
public static int[] apolloAttack(int[] hp) {

    int probability = rand.nextInt(100);

    // Medium Attack (0-50)
    if (probability < 50) {
        System.out.println("Apollo emits a dazzling Solar Flare, causing 25 damage!");
        hp[0] = medAttack(hp[0]);
    }
    // Heavy Attack (90-99)
    else if (probability < 99 && probability > 90) {
        System.out.println("Apollo performs a mesmerizing Musical Symphony, dealing 45 damage!");
        hp[0] = heavyAttack(hp[0]);
    }
    // Eclipse Cascade (50-70)
    else if (probability < 70 && probability > 50) {
        System.out.println("Apollo creates a captivating Eclipse Cascade, causing 10 damage!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Harmonic Resonance (70-90)
    else {
        System.out.println("Apollo's Harmonic Resonance leaves you stunned!");
        stun();
    }

    return hp;
}

// Zeus
public static int[] zeusAttack(int[] hp) {

    int probability = rand.nextInt(100);

    // Medium Attack (0-50)
    if (probability < 50) {
        System.out.println("Zeus channels his Super Strength, dealing 25 damage!");
        hp[0] = medAttack(hp[0]);
    }
    // Heavy Attack (90-99)
    else if (probability < 99 && probability > 90) {
        System.out.println("Zeus unleashes a devastating Lightning Strike, causing 45 damage!");
        hp[0] = heavyAttack(hp[0]);
    }
    // Zeus's Bestiary (50-70)
    else if (probability < 70 && probability > 50) {
        System.out.println("Zeus summons a mythical creature, dealing 10 damage!");
        // STILL REMAINING TO ADD PROBABILITY OF DIFFERENT ANIMAL AND THEIR ATTACK
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Divine Judgement (70-90)
    else {
        System.out.println("Zeus poses a divine dilemma with Divine Judgement!");
        // REMAINING TO ADD THE METHOD
        // divineJudgement();
    }   
    return hp
}

//method for clearing the terminal 
    public static void clearTerminal() {
        //check it the os is windows 
        if (System.getProperty("os.name").contains("Windows")) {
            // For Windows
            //clear the terminal by creating a new class, processbuilder which is use to run the command for terminal
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            // For Unix/Linux/Mac
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }
}