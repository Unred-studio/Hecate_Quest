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
    private static int playerHp;
    private static int opponentHp;

    
    public static void main(String[] args) {
        //for main method, it just call the game methd and nothing else
        game();
    }
    public static void game() {

        //call the menu method and check what user want; story or playgame or exit
        do {
            condition = false;
            char userChoice = menu().toUpperCase().charAt(0);
            if (userChoice == 'P') {
                playGame();
            } else if(userChoice == 'S') {
                story();
            } else if(userChoice == 'E') {
                break;
            } else {
                System.out.println("Plese Enter the vaild char");
                condition = true;
            }
        } while(condition);
    }


    //menu method, ask the user to choice between playgame or story or exit, after losing the player shall reach to this method
    public static String menu() {
        System.out.println("");
        System.out.println("PlayGame[p]");
        System.out.println("Story[s]");
        System.out.println("Exit[e]");
        System.out.print("Your Choice: ");
        String menuChoice = scan.nextLine();
        return menuChoice;
    }

    //the method story is called if user select to view story from menu option
    public static void story() {
        //the whole basic story will be shown on the terminal
        System.out.println("");
        System.out.println("You are the Goddess of Magic, Hecate.");
        System.out.println("One day, you made a mistake while brewing a potion from a poisonous plant.");
        System.out.println("Unfortunately, this potion spread throughout Olympus.");
        System.out.println("All the gods who smelled it became uncontrollable and started to wreak havoc on Earth.");
        System.out.println("It is now your responsibility to protect the Earth by stopping these rogue gods.");
        System.out.println("Your powers are:");
        System.out.println("- Healing (Heal your HP to 100, however your HP shall be below 10)");
        System.out.println("- Elemental Manipulation (Fire, Water, Air, Earth)");
        System.out.println("- Necromancy (Your Best attack but using it also decrease your HP)");
        System.out.println("- Illusion (prevents opponents from attacking)");
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


    //for the playGame method, it will call the main battle method[ares, artimes...] one by one
    public static void playGame() {
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
                            menu();
                        }
                    } else {
                        menu();
                    }
                } else {
                    menu();
                }
            } else {
                menu();
            }
        } else {
            menu();
        }
    }


    //Level 1: Heacte Vs Ares
    public static boolean ares() {
        //the string god is used to let the other repeatative methods know that it is called for ares so keep the story in accord
        String god = "Ares";

        //basic introduction for the god and the battle
        System.out.println("Welcome to the Battle Ground!");
        System.out.println("Here, you will face a fierce fight with Ares, the God of War.");
        System.out.println("Prepare for a battle of strength and strategy!");

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
         playerHp = 100;
         opponentHp = 100;
        boolean winner = false;
    
        while (playerHp > 0 && opponentHp > 0) {
            // Player's turn to attack
            System.out.println("Hacate's Hp: " + playerHp);
            System.out.println(god + "'s Hp: " + opponentHp);
            opponentHp = playerAttack(playerHp, opponentHp);
    
            // Check if the opponent's HP has reached 0 or less
            if (opponentHp <= 0) {
                winner = true;
                break;
            }
    
            // Opponent's turn to attack
            playerHp = opponentAttack(god, playerHp, opponentHp);
    
            // Check if the player's HP has reached 0 or less
            if (playerHp <= 0) {
                winner = false;
                break;
            }
        }
    
        return winner;
    }



//BELOW THIS COMMENT IS REMAINING

    public static int playerAttack(int playerHp, int opponentHp) {

        System.out.println("");
        System.out.println("Please choice your attack: ");
        System.out.println("Elemental Manupulation [Fire(f), Water(w), Earth(e), Air(a)]");
        System.out.println("Illution[i]");
        System.out.println("Necromancy[n]");
        System.out.println("Healing[h]");
        do {
            condition = false;
            System.out.println("");
            System.out.println("Enter your choice: ");
            String attack = scan.nextLine();

            if(attack.charAt(0) == 'f') {
                opponentHp = lowAttack(opponentHp);
            } else if(attack.charAt(0) == 'w') {
                opponentHp = lowAttack(opponentHp);
            } else if(attack.charAt(0) == 'e') {
                opponentHp = lowAttack(opponentHp);
            } else if(attack.charAt(0) == 'a') {
                opponentHp = lowAttack(opponentHp);
            } else if(attack.charAt(0) == 'i') {
                stun();
            } else if(attack.charAt(0) == 'n') {
                opponentHp = heavyAttack(opponentHp);
            } else if(attack.charAt(0) == 'h') {
                System.out.println("Hecate restored its Hp to 100");
                playerHp = heal(playerHp);
            } else {
                System.out.println("Please enter the valid char");
                condition = true;
            }
        } while(condition);


        return opponentHp;
    }


    public static int opponentAttack(String god, int playerHp, int opponentHp) {
        if (god.equals("Ares")) {
            playerHp = aresAttack(playerHp, opponentHp);
        } else if (god.equals("Artemis")) {
            playerHp = artemisAttack(playerHp, opponentHp);
        } else if (god.equals("Hades")) {
            playerHp = hadesAttack(playerHp, opponentHp);
        } else if (god.equals("Apollo")) {
            playerHp = apolloAttack(playerHp, opponentHp);
        } else {
            playerHp = zeusAttack(playerHp, opponentHp);
        }
        return playerHp;
    }

    public static int heal(int initalHp) {
        initalHp = 100;
        return initalHp;
    }

    public static int heavyAttack(int opponentHp) {
        opponentHp-= 45;
        return opponentHp;
    }

    public static int lowAttack(int opponentHp) {
        opponentHp-= 10;
        return opponentHp;
    }

    public static int medAttack(int opponentHp) {
        opponentHp-= 25;
        return opponentHp;
    }

    public static void stun() {
        //NEED TO THINK SOMTHING FOR THIS
    }


    public static int aresAttack(int playerHp,int opponentHp) {

        int probability = rand.nextInt(100);
        
        //0-50
        if (probability < 50) {
            System.out.println("arrows of ares");
            playerHp = lowAttack(playerHp);
        }
        //90-99
        else if(probability < 99 && probability > 90) {
            System.out.println("warrrior rage");
            playerHp = heavyAttack(playerHp);
        }
        //50-70
        else if(probability < 70 && probability > 50) {
            System.out.println("tactical strike");
            for(int x = 0; x < 3; x++) {
                playerHp = lowAttack(playerHp);
            }
        }
        //70-90
        else {
            System.out.println("battle cry");
            stun();
        }

        return playerHp;
    }


    public static int artemisAttack(int playerHp,int opponentHp) {

        int probability = rand.nextInt(100);
        
        //0-50
        if (probability < 50) {
            System.out.println("wildgrowth");
            playerHp = medAttack(playerHp);
        }
        //90-99
        else if(probability < 99 && probability > 90) {
            System.out.println("moonlight brust");
            boolean brustprob = rand.nextBoolean();
            if(brustprob) {
            playerHp = heavyAttack(playerHp);
            }
        }
        //50-70
        else if(probability < 70 && probability > 50) {
            System.out.println("sylan Arrow");
            for(int x = 0; x < 3; x++) {
                playerHp = lowAttack(playerHp);
            }
        }
        //70-90
        else {
            System.out.println("evasion");
            stun();
        }

        return playerHp;
    }
    

    public static int hadesAttack(int playerHp,int opponentHp) {

        int probability = rand.nextInt(100);
        
        //0-50
        if (probability < 50) {
            System.out.println("summon the undead");
            playerHp = medAttack(playerHp);
        }
        //90-99
        else if(probability < 99 && probability > 90) {
            System.out.println("necrotic blast");
            playerHp = heavyAttack(playerHp);
        }
        //50-70
        else if(probability < 70 && probability > 50) {
            System.out.println("crued ground");
            for(int x = 0; x < 3; x++) {
                playerHp = lowAttack(playerHp);
            }
        }
        //70-90
        else {
            System.out.println("spectral chain");
            stun();
        }

        return playerHp;
    }


    public static int apolloAttack(int playerHp,int opponentHp) {

        int probability = rand.nextInt(100);
        
        //0-50
        if (probability < 50) {
            System.out.println("solar flare");
            playerHp = medAttack(playerHp);
        }
        //90-99
        else if(probability < 99 && probability > 90) {
            System.out.println("musical symphony");
            playerHp = heavyAttack(playerHp);
        }
        //50-70
        else if(probability < 70 && probability > 50) {
            System.out.println("Eclipse Cascade");
            for(int x = 0; x < 3; x++) {
                playerHp = lowAttack(playerHp);
            }
        }
        //70-90
        else {
            System.out.println("Harmonic Resonance");
            stun();
        }

        return playerHp;
    }


    public static int zeusAttack(int playerHp,int opponentHp) {

        int probability = rand.nextInt(100);
        
        //0-50
        if (probability < 50) {
            System.out.println("super strength");
            playerHp = medAttack(playerHp);
        }
        //90-99
        else if(probability < 99 && probability > 90) {
            System.out.println("lighting strike");
            playerHp = heavyAttack(playerHp);
        }
        //50-70
        else if(probability < 70 && probability > 50) {
            System.out.println("Zeus's Bestiary");
            //STILL REMAINING TO ADD PROBABILITY OF DIFFERENT ANIMAL AND THERE ATTACK
            for(int x = 0; x < 3; x++) {
                playerHp = lowAttack(playerHp);
            }
        }
        //70-90
        else {
            System.out.println("divine judgement");
            //REMAINING TO ADD THE METHOD
            //divineJudgement();
        }

        return playerHp;
    }
    

}