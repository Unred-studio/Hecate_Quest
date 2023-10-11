//Documentation Comment
/*
 @name: Aaditya K
 @date: Oct 3, 2023
 @version: 18.6.8
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
    private static int[] hp = new int[2];
   
   //declaring stunner varible to keep track if someone used or got stun
   private static boolean stunner = false; //it shall be fasle, if true then skips the chance 


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
        seprateTerminal();
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
        seprateTerminal();
        //the whole basic story will be shown on the terminal
        System.out.println("");
        System.out.println("You are the Goddess of Magic, Hecate.");
        System.out.println("One day, you made a mistake while brewing a potion from a poisonous plant.");
        System.out.println("Unfortunately, this potion spread throughout Olympus.");
        System.out.println("All the gods who smelled it became uncontrollable and started to wreak havoc on Earth.");
        System.out.println("It is now your responsibility to protect the Earth by stopping these rogue gods.");
        System.out.println("Your powers are:");
        System.out.println("- Healing (Heal your HP to 100, only works if your hp is below 10)");
        System.out.println("- Elemental Manipulation (Fire, Water, Air, Earth)");
        System.out.println("- Necromancy (Summon the spirits from underworld)");
        System.out.println("- Illusion (prevents opponents from attacking by creating a illusion)");
        System.out.println("Your main mission is to take on the rogue gods, defeat them using your powers.");
        System.out.println("Good luck, Hecate! The fate of Earth lies in your hands.");
        System.out.println("");

        //at the end of story, as the user if they want to play the game
        do {
            condition = false;
            System.out.print("Are you ready to start the game[y/n]: ");
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
        seprateTerminal();
        //after the story(or directly from menu) the player comes to playGame method
        //the if statements is used such that the player can only go to next level if he has defeated the god of current level
        //game start with Ares
        if(ares()) {    //ares()
            seprateTerminal();
            System.out.println("You Won!");
            do{
                condition = false;
                System.out.print("Are you ready to take battle with Artemis[y] or leave to menu[n]: ");
                String input = scan.nextLine();
                char choice = input.toUpperCase().charAt(0);
                if (choice == 'Y') {
                    
                }
                else if (choice == 'N') {
                    menu();
                }
                else {
                    System.out.println("");
                    condition = true;
                }
            }while (condition);
            //after defeating Ares you will fight with the  Artemis
            if(artemis()) { //artemis()
                seprateTerminal();
                System.out.println("You Won!");
                do{
                    condition = false;
                    System.out.print("Are you ready to take battle with Hades[y] or leave to menu[n]: ");
                    String input = scan.nextLine();
                    char choice = input.toUpperCase().charAt(0);
                    if (choice == 'Y') {
                        
                    }
                    else if (choice == 'N') {
                        menu();
                    }
                    else {
                        System.out.println("");
                        condition = true;
                    }
                }while (condition);
                //After defeating Artemis, you will fight with the Hades
                if(hades()) { //hades()
                    seprateTerminal();
                    System.out.println("You Won!");
                    do{
                        condition = false;
                        System.out.print("Are you ready to take battle with Apollo[y] or leave to menu[n]: ");
                        String input = scan.nextLine();
                        char choice = input.toUpperCase().charAt(0);
                        if (choice == 'Y') {
                            
                        }
                        else if (choice == 'N') {
                            menu();
                        }
                        else {
                            System.out.println("");
                            condition = true;
                        }
                    }while (condition);
                    //After defeating Hades, you will fight with the Apollo
                    if(apollo()) { //apollo()
                        seprateTerminal();
                        System.out.println("You Won!");
                        do{
                            condition = false;
                            System.out.print("Are you ready to take battle with Zeus[y] or leave to menu[n]: ");
                            String input = scan.nextLine();
                            char choice = input.toUpperCase().charAt(0);
                            if (choice == 'Y') {
                                
                            }
                            else if (choice == 'N') {
                                menu();
                            }
                            else {
                                System.out.println("");
                                condition = true;
                            }
                        }while (condition);
                        //After defeating Apollo, you will fight with Zeus
                        if(zeus()) {
                            seprateTerminal();
                            victory();
                        } else {
                            seprateTerminal();
                            //If lost then prompt to ask if want to leave to menu or play again
                            System.out.println("You lost the battle with zeus");
                            do {
                            System.out.print("Would you like to exit[0] or play again[1]: ");
                            String choice = scan.nextLine();
                            if (choice.charAt(0) == '1') {
                                playGame();
                            }
                            else if (choice.charAt(0) == '0') {
                                menu();
                            }
                            else {
                                System.out.println("Please enter the correct choice.");
                            }
                        } while(condition);
                        }
                    } else {
                        seprateTerminal();
                        //If lost then prompt to ask if want to leave to menu or play again
                         System.out.println("You lost the battle with Apollo");
                            do {
                            System.out.print("Would you like to exit[0] or play again[1]: ");
                            String choice = scan.nextLine();
                            if (choice.charAt(0) == '1') {
                                playGame();
                            }
                            else if (choice.charAt(0) == '0') {
                                menu();
                            }
                            else {
                                System.out.println("Please enter the correct choice.");
                            }
                        } while(condition);
                    }
                } else {
                    seprateTerminal();
                    //If lost then prompt to ask if want to leave to menu or play again
                    System.out.println("You lost the battle with Hades");
                    do {
                    System.out.print("Would you like to exit[0] or play again[1]: ");
                    String choice = scan.nextLine();
                    if (choice.charAt(0) == '1') {
                        playGame();
                    }
                    else if (choice.charAt(0) == '0') {
                        menu();
                    }
                    else {
                        System.out.println("Please enter the correct choice.");
                    }
                } while(condition);
                }
            } else {
                seprateTerminal();
                //If lost then prompt to ask if want to leave to menu or play again
                System.out.println("You lost the battle with Artemis");
                do {
                System.out.print("Would you like to exit[0] or play again[1]: ");
                String choice = scan.nextLine();
                if (choice.charAt(0) == '1') {
                    playGame();
                }
                else if (choice.charAt(0) == '0') {
                    menu();
                }
                else {
                    System.out.println("Please enter the correct choice.");
                }
            } while(condition);
            }
        } else {
            seprateTerminal();
            //If lost then prompt to ask if want to leave to menu or play again
            System.out.println("You lost the battle with Ares");
            do {
            System.out.print("Would you like to exit[0] or play again[1]: ");
            String choice = scan.nextLine();
            if (choice.charAt(0) == '1') {
                playGame();
            }
            else if (choice.charAt(0) == '0') {
                menu();
            }
            else {
                System.out.println("Please enter the correct choice.");
            }
        } while(condition);
        }
    }




    //Level 1: Heacte Vs Ares
    public static boolean ares() {
        //the string god is used to let the other repeatative methods know that it is called for ares so keep the story in accord
        String god = "Ares";

        //clearing the terminal to improve visual 
        seprateTerminal();
        //basic introduction for the god and the battle
        System.out.println("Welcome to the Battle Ground!");
        System.out.println("Here, you will face a fierce fight with Ares, the God of War.");
        System.out.println("Prepare for a battle of strength and strategy!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.println("");
            System.out.print("Are you ready?[y/n]: ");
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
        seprateTerminal();

        //introduction to god
        System.out.println("\nWelcome to the Jungles!");
        System.out.println("Here, you will confront Artemis, the Goddess of the Hunt.");
        System.out.println("Navigate through the dense wilderness and prove your mettle!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.print("Are you ready?[y/n]: ");
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
        seprateTerminal();
        //introduction to god
        System.out.println("\nWelcome to the Underworld!");
        System.out.println("In this dark realm, you will clash with Hades, the God of the Underworld.");
        System.out.println("Face the shadows and the undead in your quest!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.print("Are you ready?[y/n]: ");
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
        seprateTerminal();
        //intro to god
        System.out.println("\nWelcome to the Sunlit Realm!");
        System.out.println("Prepare to challenge Apollo, the God of the Sun and Music.");
        System.out.println("Bask in the sunlight and harness the power of music and light!");

//waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.print("Are you ready?[y/n]: ");
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
        seprateTerminal();
        //intro to god
        System.out.println("\nWelcome to Mount Olympus!");
        System.out.println("You have reached the home of the gods.");
        System.out.println("Now, confront Zeus, the King of the Gods, and bring order to Olympus!");

        //waiting for the player to read the introduction and if they wish then they can continue or quit
        do {
            condition = false;
            System.out.print("Are you ready?[y/n]: ");
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
        boolean winner = true;
    
        //the loop repeats until the hp or both of them is above 0
        //the condition never get false as if one of them get below 0, the other one win and loop break
        while (hp[0] > 0 && hp[1] > 0) {

            seprateTerminal();

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


        if (!(stunner)) {
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
                System.out.println("You summon the power of fire and unleash a scorching fireball damaging 10 hp!");                
                hp[1] = lowAttack(hp[1]);
            } else if(attack.charAt(0) == 'w') {
                System.out.println("You harness the waters and create a powerful tidal wave damaging 10 hp!");                
                hp[1] = lowAttack(hp[1]);
            } else if(attack.charAt(0) == 'e') {
                System.out.println("You command the earth to hurl massive rocks at your opponent damaging 10 hp!");                
                hp[1] = lowAttack(hp[1]);
            } else if(attack.charAt(0) == 'a') {
                System.out.println("You control the air, creating a devastating whirlwind damaging 10 hp!");                
                hp[1] = lowAttack(hp[1]);
            } else if(attack.charAt(0) == 'i') {
                System.out.println("You create a mesmerizing illusion to confuse your opponent!");  
                System.out.println("Your opponent isn't able to attack!");              
                stunner = true;
            } else if(attack.charAt(0) == 'n') {
                System.out.println("You delve into the realm of necromancy, summoning powerful spirits damaging 30 hp !");                
                hp[1] = necroAttack(hp[1]);
            } else if(attack.charAt(0) == 'h') {
                if(hp[0] <= 10) {
                System.out.println("Hecate restored its Hp to 100");
                hp[0] = heal(hp[0]);
                }
                else {
                    System.out.println("You can't heal if you hp is above 10.");
                    condition = true;
                }
            } else {
                System.out.println("Please enter the valid char");
                condition = true;
            }
        } while(condition);

        }
        //if the stunner is true then wont allow to attack 
        else {
            System.out.println("You are stunned and cannot attack!");
            //making the value default as it has been used already 
            stunner = false; 
        }

        //return opponet's hp only 
        return hp;
    }


    //opponent attack check which god is fighting and call the particular method of that god
    public static int[] opponentAttack(String god, int[] hp) {
        if (!(stunner)) {
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
        }
        else {
            stunner = false;
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

    public static int necroAttack(int opponentHp) {
        opponentHp-= 30;
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

    public static int ultimateAttack(int opponentHp) {
        opponentHp-= 100;
        return opponentHp;
    }

    //divine judgement is the attack of zeus
    public static boolean divineJudgement() {
        //introduction to the divine judgement 
        System.out.println("Zeus is the wisest! He gives you a question.");
        System.out.println("Answer correctly and zeus retreat back!");
        System.out.println("or Zeus shall prevail!");

        boolean result;
        //all the questions
        String question1 = "Question 1: You have the power to save one of the following artifacts from destruction. Which one shall you save?\n" +
                  "A) A legendary sword that can defeat any enemy.\n" +
                  "B) A book containing the knowledge of all ancient magic spells.\n" +
                  "C) A sacred amulet that can heal any wound.";
        String question2 = "Question 2: A burning building houses a group of people. You can only save one. Who do you choose?\n" +
                  "A) A young child\n" +
                  "B) An elderly person\n" +
                  "C) A trained firefighter.";
        String question3 = "Question 3: You encounter a lost traveler in the wilderness. What do you offer to help them?\n" +
                  "A) Food and water to sustain them on their journey.\n" +
                  "B) A map and directions to their destination.\n" +
                  "C) Protection and guidance to ensure their safety.";
        String question4 = "Question 4: A powerful storm threatens to destroy a coastal village. What action do you take to protect the villagers?\n" +
                  "A) Use your magic to calm the storm.\n" +
                  "B) Create illution to Rally the villagers to evacuate to a safe location as soon as possible.\n" +
                  "C) Seek the help of a sea deity to ward off the storm.";
        String question5 = "Question 5: You discover an ancient artifact with the power to reshape reality. How do you handle this newfound power?\n" +
                  "A) Use it to bring peace and prosperity to the world.\n" +
                  "B) Safeguard it from those who would misuse it.\n" +
                  "C) Destroy it to prevent its potential harm.";

        //genrate a random number from 0 to 4 which will help to select a random question out of five
        int randomQues = rand.nextInt(5);

        if (randomQues == 0) {
            System.out.println(question1);
            System.out.print("Your answer (A/B/C): ");
            String input = scan.nextLine();
            char answer = input.toUpperCase().charAt(0);

            if (answer == 'B') {
                System.out.println("You were correct!");
                result = true;
            }
            else {
                System.out.println("You are wrong!");
                System.out.println("Zeus, the King of the Gods, calls upon the heavens and channels unimaginable power!");
                System.out.println("A blinding bolt of lightning erupts from the sky, striking you with divine fury.");
                System.out.println("Your strength fades as the overwhelming force of Zeus's Lightning Strike consumes you.");
                System.out.println("Hecate has fallen in battle. Olympus prevails, and the Earth is plunged into chaos.");
                result = false;
            }
        }
        else if (randomQues == 1) {
            System.out.println(question2);
            System.out.print("Your answer (A/B/C): ");
            String input = scan.nextLine();
            char answer = input.toUpperCase().charAt(0);

            if (answer == 'A') {
                System.out.println("You were correct!");
                result = true;
            }
            else {
                System.out.println("You are wrong!");
                System.out.println("Zeus, the King of the Gods, calls upon the heavens and channels unimaginable power!");
                System.out.println("A blinding bolt of lightning erupts from the sky, striking you with divine fury.");
                System.out.println("Your strength fades as the overwhelming force of Zeus's Lightning Strike consumes you.");
                System.out.println("Hecate has fallen in battle. Olympus prevails, and the Earth is plunged into chaos.");
                result = false;
            }
        }
        else if (randomQues == 2) {
            System.out.println(question3);
            System.out.print("Your answer (A/B/C): ");
            String input = scan.nextLine();
            char answer = input.toUpperCase().charAt(0);

            if (answer == 'B' || answer == 'C') {
                System.out.println("You were correct!");
                result = true;
            }
            else {
                System.out.println("You are wrong!");
                System.out.println("Zeus, the King of the Gods, calls upon the heavens and channels unimaginable power!");
                System.out.println("A blinding bolt of lightning erupts from the sky, striking you with divine fury.");
                System.out.println("Your strength fades as the overwhelming force of Zeus's Lightning Strike consumes you.");
                System.out.println("Hecate has fallen in battle. Olympus prevails, and the Earth is plunged into chaos.");
                result = false;
            }
        }
        else if (randomQues == 3) {
            System.out.println(question4);
            System.out.print("Your answer (A/B/C): ");
            String input = scan.nextLine();
            char answer = input.toUpperCase().charAt(0);

            if (answer == 'B') {
                System.out.println("You were correct!");
                result = true;
            }
            else {
                System.out.println("You are wrong!");
                System.out.println("Zeus, the King of the Gods, calls upon the heavens and channels unimaginable power!");
                System.out.println("A blinding bolt of lightning erupts from the sky, striking you with divine fury.");
                System.out.println("Your strength fades as the overwhelming force of Zeus's Lightning Strike consumes you.");
                System.out.println("Hecate has fallen in battle. Olympus prevails, and the Earth is plunged into chaos.");
                result = false;
            }
        }
        else {
            System.out.println(question5);
            System.out.print("Your answer (A/B/C): ");
            String input = scan.nextLine();
            char answer = input.toUpperCase().charAt(0);

            if (answer == 'B') {
                System.out.println("You were correct!");
                result = true;
            }
            else {
                System.out.println("You are wrong!");
                System.out.println("Zeus, the King of the Gods, calls upon the heavens and channels unimaginable power!");
                System.out.println("A blinding bolt of lightning erupts from the sky, striking you with divine fury.");
                System.out.println("Your strength fades as the overwhelming force of Zeus's Lightning Strike consumes you.");
                System.out.println("Hecate has fallen in battle. Olympus prevails, and the Earth is plunged into chaos.");
                result = false;

            }
        }

        return result;
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
        System.out.println("Ares strikes swiftly, hitting you three times with 10 damage each time!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Battle Cry (70-90)
    else {
        System.out.println("Ares lets out a deafening Battle Cry, leaving you stunned!");
        stunner = true;
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
        stunner = true;
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
        System.out.println("Hades makes the ground unbearable, causing 10 damage thrice!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Spectral Chain (70-90)
    else {
        System.out.println("Hades throws a spectral chain, preventing your next attack!");
        stunner = true;
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
        System.out.println("Apollo creates a captivating Eclipse Cascade, causing 10 damagen thrice!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Harmonic Resonance (70-90)
    else {
        System.out.println("Apollo's Harmonic Resonance leaves you stunned!");
        stunner = true;
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
        System.out.println("Zeus summons army mythical creature, dealing 10 damage thrice!");
        for (int x = 0; x < 3; x++) {
            hp[0] = lowAttack(hp[0]);
        }
    }
    // Divine Judgement (70-90)
    else {
        if(divineJudgement()) {
            hp[1] = ultimateAttack(hp[1]);
        }
        else {
            hp[0] = ultimateAttack(hp[0]);
        }
    }   
    return hp;
}

//method for clearing the terminal 
    public static void seprateTerminal() {
    System.out.println("--------------------------------------------------------------------------");
}

//victory method called when you defeat zeus
    public static void victory() {
        System.out.println("Congratulations, Hecate! You have defeated Zeus, the King of the Gods!");
        System.out.println("The Earth is safe once again.");
        System.out.println("You are a true hero and protector of humanity.");
        System.out.println("Thank you for playing, and may the magic of Hecate guide you on your next adventure!");
        menu();
    }

}