///////////////////////////////////////////////////////////////////////////////
// Title:            Harry Potter Duel
// Files:            HarryPotterDuel.java
// Semester:         CS302 Fall 2012
//
// Author:           Daniel Meyer drmeyer4@wisc.edu
// CS Login:         danielm
// Lecturer's Name:  Deb Depeler
// Lab Section:      316
//
//
// Credits:          Westley Bonack, Michael Berberet
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Random;
import java.util.Scanner;
/**
 * This class name HarryPotterDuel creates a magical duel between
 * the dark Lord Voldemort and the user.
 * 
 * @author Daniel
 */
public class HarryPotterDuel
{
	/**
	 * This is the main method. It takes input from the user and
	 * creates a duel between the player and the dark Lord Voldemort.
	 * 
	 */
	public static void main(String[] args)
	{

		//declare and initialize a Scanner
		Scanner in = new Scanner(System.in);

		//get seed value from user and use it to make the random number generator
		System.out.print("Please enter a seed value [integer]: "); 

		//you may assume the user enters an integer for the seed
		int seed = in.nextInt(); 
		Random rng = new Random(seed); //Random Number Generator 

		//declare and initialize any other needed variables
		// value of the spell Stupefy
		int stupify = 10;
		// value of the spell Impedimenta
		int impedimenta = 10;
		// value of the spell Furnunculus
		int furnunculus = 10;
		// value of the spell Expelliarmus
		int expelliarmus = 10;
		// Starting value of the player's health
		int playerHealth = 50;
		// Starting value of Voldemort's health
		int voldemortHealth = 50;
		//Variable used to count the number of duels
		int numberOfDuels = 0;
		//Variable used to count the number of heals
		int healing = 0;
		//Main menu explaining the rules of the game
		System.out.print("Welcome to Harry Potter Duel. " +
				"At the start of each round you will be prompted to " +
				"choose one of the following five choices:" +
				"\nThe goal is to duel Voldemort " +
				"until his health is depleted. " +
				"Let's begin!");
		System.out.print("\n1. View Spell Damages- " +
				"A report of the Player " +
				"and Voldemort's health, number of duels, " +
				"healing and spell damges." +
				"\n2. Duel- Choose a spell to cast against Voldemort." +
				"\n3. Train- Choose a spell to increase the damage " +
				"of while decreasing your health." +
				"\n4. Heal- Return your health to its initial value." +
				"\n5. Forfeit- Forfeit the duel." +
				"\nPlayer's Health= " + playerHealth + 
				"  Voldemort's Health = " + voldemortHealth);

		//begin game loop
		while (voldemortHealth > 0 && playerHealth > 0){
			System.out.print("\n1. View Spell Damages" +
					"\n2. Duel" +
					"\n3. Train" +
					"\n4. Heal" +
					"\n5. Forfeit" +
					"\nPlayer's Health= " + playerHealth + 
					"  Voldemort's Health = " + voldemortHealth);

			//prompt user for their decision (duel, train, heal, forfeit)
			System.out.print("\nPlease choose the number of the " +
					"option you would like to perform: ");



			if (in.hasNextInt()){
				//if user chooses to view spell damage report
				int choice = in.nextInt();
				if (choice == 1){
					//spell damage report
					System.out.print("\nSpell Damages: " + "\n1. Stupify defeats" +
							"       Impedimenta   P: " + stupify + " V: 10" +
							"\n2. Impedimenta defeats   Furnunculus, Expelliarmus" +
							"   P: " + impedimenta + " V: 10" +
							"\n3. Furnunculus defeats   Expelliarmus   P: " 
							+ furnunculus + " V: 10" +
							"\n4. Expelliarmus defeats  Stupify   " +
							"P: " + expelliarmus + " V: 10" +
							"\n5. Protego defeats all spells   P: 0 V:0" +
							"\nPlayer Health: " + playerHealth + 
							"\nVoldemort Health: " + voldemortHealth +
							"\nNumber of Duels: " + numberOfDuels + 
							"\nHealing: " + healing + "\n");
				}

				//if user chooses to duel
				if (choice == 2){
					numberOfDuels ++;
					//randomly choose spell for computer to cast
					int voldemortSpell = rng.nextInt(5) + 1;
					System.out.print(voldemortSpell);
					boolean spells = false;
					while (!spells){
						System.out.print("\n1. Stupify- P: " + stupify + 
								"\n2. Impedimenta- P: " + impedimenta + " V: 10" +
								"\n3. Furnunculus: P: " + furnunculus + " V: 10" +
								"\n4. Expelliarmus: P: " + expelliarmus + " V: 10" +
								"\n5. Protego" + 
								"\nPlease choose the number of the spell " +
								"you would like to cast: ");

						if (in.hasNextInt()){
							int spell = in.nextInt();
							//evaluate winner and update health value accordingly
							// DUELING LOGIC: PLAYERS CHOICE compared to each VOLDEMORT CHOICE
							//All possible outcomes of Stupefy
							if (spell == 1){
								//Outcome of Stupefy vs. Stupefy
								if (voldemortSpell == 1 && stupify == 10){
									voldemortHealth = voldemortHealth - 10;
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Stupefy. " +
											"Both players take damage.\n");
								}
								//Outcome of trained Stupefy vs. Stupefy
								if (voldemortSpell == 1 && stupify > 10){
									voldemortHealth = voldemortHealth - stupify;
									System.out.print("\nVoldemort uses Stupefy " +
											"and takes damage.\n");
								}
								//Outcome of Stupefy vs. Impedimenta
								if (voldemortSpell == 2){
									voldemortHealth = voldemortHealth - stupify;
									System.out.print("\nVoldemort uses Impedimenta " +
											"and takes damage.\n");
								}
								//Outcome of Stupefy vs. Furnunculus
								if (voldemortSpell == 3){
									System.out.print("\nVoldemort uses Furnunculus. " +
											"No damage to either player.\n");
								}
								//Outcome of Stupefy vs. Expelliarmus
								if (voldemortSpell == 4){
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Expelliarmus. " +
											"Player takes damage.\n");
								}
								//Outcome of Stupefy vs. Protego
								if (voldemortSpell == 5){
									System.out.print("\nVoldemort blocks spell with Protego.\n");
								}
								spells = true;
							}
							
							//All possible outcomes of Impedimenta
							if (spell == 2){
								//Outcome of Impedimenta vs. Stupefy
								if (voldemortSpell == 1){
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Stupefy. " +
											"Player takes damage.\n");
								}
								//Outcome of Impedimenta vs. Impedimenta
								if (voldemortSpell == 2 && impedimenta == 10){
									voldemortHealth = voldemortHealth - 10;
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Impedimenta. " +
											"Both players take damage.\n");
								}
								//Outcome of trained Impedimenta vs. Impedimenta
								if(voldemortSpell == 2 && impedimenta > 10){
									voldemortHealth = voldemortHealth - impedimenta;
									System.out.print("\nVoldemort uses Impedimenta " +
											"and takes damage.\n");
								}
								//Outcome of Impedimenta vs. Furnunculus
								if (voldemortSpell == 3){
									voldemortHealth = voldemortHealth - impedimenta;
									System.out.print("\nVoldemort uses Furnunculus " +
											"and takes damage.\n");
								}
								//Outcome of Impedimenta vs. Expelliarmus
								if (voldemortSpell == 4 && impedimenta == 10){
									voldemortHealth = voldemortHealth - 10;
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Expelliarmus. " +
											"Both players take damage.\n");
								}
								//Outcome of trained Impedimenta vs. Expelliarmus
								if (voldemortSpell == 4 && impedimenta > 10){
									voldemortHealth = voldemortHealth - impedimenta;
									System.out.print("\nVoldemort uses Expelliarmus " +
											"and takes damage.\n");
								}
								//Outcome of Impedimenta vs. Protego
								if (voldemortSpell == 5){
									System.out.print("\nVoldemort blocks spell with Protego.\n");
								}
								spells = true;
							}
							
							//All possible outcomes of Furnunculus
							if (spell == 3){
								//Outcome of Furnunculus vs. Stupefy
								if (voldemortSpell == 1){
									System.out.print("\nVoldemort uses Stupefy. " +
											"No damage to either player.\n");
								}
								//Outcome of Furnunculus vs. Impedimenta
								if (voldemortSpell == 2){
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Impedimenta. " +
											"Player takes damage.\n");
								}
								//Outcome of Furnunculus vs. Furnunculus
								if (voldemortSpell == 3 && furnunculus == 10){
									voldemortHealth = voldemortHealth - 10;
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Furnunculus. " +
											"Both players take damage.\n");

								}
								//Outcome of trained Furnunculus vs. Furnunculus
								if (voldemortSpell == 3 && furnunculus > 10){
									voldemortHealth = voldemortHealth - furnunculus;
									System.out.print("\nVoldemort uses Furnunculus " +
											"and takes damage.\n");
								}
								//Outcome of Furnunculus vs. Expelliarmus
								if (voldemortSpell == 4){
									voldemortHealth = voldemortHealth - furnunculus;
									System.out.print("\nVoldemort uses Expelliarmus " +
											"and takes damage.\n");
								}
								//Outcome of Furnunculus vs. Protego
								if (voldemortSpell == 5){
									System.out.print("\nVoldemort blocks " +
											"spell with Protego.\n");
								}
								spells = true;
							}
							
							//All possible outcomes of Expelliarmus
							if (spell == 4){
								//Outcome of Expelliarmus vs. Stupefy
								if (voldemortSpell == 1){
									voldemortHealth = voldemortHealth - expelliarmus;
									System.out.print("\nVoldemort uses Stupefy " +
											"and takes damage.\n");
								}
								//Outcome of Expelliarmus vs. Impedimenta
								if (voldemortSpell == 2 && expelliarmus == 10){
									voldemortHealth = voldemortHealth - 10;
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Impedimenta. " +
											"Both players take damage.\n");
								}
								//Outcome of trained Expelliarmus vs. Impedimenta
								if (voldemortSpell == 2 && expelliarmus > 10){
									voldemortHealth = voldemortHealth - expelliarmus;
									System.out.print("\nVoldemort uses Impedimenta " +
											"and takes damage.\n");
								}
								//Outcome of Expelliarmus vs. Furnunculus
								if (voldemortSpell == 3){
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses Furnunculus. " +
											"Player takes damage.\n");
								}
								//Outcome of Expelliarmus vs. Expelliarmus
								if (voldemortSpell == 4 && expelliarmus == 10){
									voldemortHealth = voldemortHealth - 10;
									playerHealth = playerHealth - 10;
									System.out.print("\nVoldemort uses expelliarmus. " +
											"Both players take damage.\n");
								}
								//Outcome of trained Expelliarmus vs. Expelliarmus
								if (voldemortSpell == 4 && expelliarmus > 10){
									voldemortHealth = voldemortHealth - expelliarmus;
									System.out.print("\nVoldeort uses expelliarmus " +
											"and takes damage.\n");
								}
								//Outcome of Expelliarmus vs. Protego
								if (voldemortSpell == 5){
									System.out.print("\nVoldemort blocks " +
											"spell with Protego.\n");
								}
								spells = true;
							}
							
							//Outcome of Protego
							if (spell == 5){
								System.out.print("\nYou blocked Voldemort's " +
										"spell with Protego. No damage.\n");
								spells = true;
							}

							// handle invalid input integers
							if (spell != 1 && spell != 2 && spell != 3 && spell != 4 && spell != 5){
								System.out.println("\nPlease choose the number of a spell.\n"); 
							}
						}
						// handle invalid input integers
						else{
							System.out.print("\nPlease use an integer.\n");
							in.next();
						}
					}
				}

				//if user chooses to train
				if (choice == 3){
					//check that player has sufficient health
					if (playerHealth <= 5){
						System.out.print("\nNot enough health to train. " +
								"Please make another choice.\n");
					}

					if (playerHealth > 5){
						playerHealth = playerHealth - 5;
						boolean spellCast = false;
						while (spellCast == false){
							
						//prompt for which spell to cast
						System.out.print("\n1.Stupefy" + "\n2.Impedimenta" + 
								"\n3. Furnunculus" +
								"\n4. Expelliarmus" + 
								"\nPlease choose a spell to train:");

							if (in.hasNextInt()){
								int spell = in.nextInt();
								//train Stupefy
								if (spell == 1){
									//update accordingly
									stupify = stupify + 5;
									System.out.print("\n5 damage added to Stupefy.");
									spellCast = true;
								}
								//train Impedimenta
								if (spell == 2){
									impedimenta = impedimenta + 5;
									System.out.print("\n5 damage added to Impedimenta.");
									spellCast = true;
								}
								//train Furnunculus
								if (spell == 3){

									furnunculus = furnunculus + 5;
									System.out.print("\n5 damage added to Furnunculus.");
									spellCast = true;
								}
								//train Expelliarmus
								if (spell == 4){
									expelliarmus = expelliarmus + 5;
									System.out.print("\n5 damage added to Expelliarmus.");
									spellCast = true;
								}
								//Error message for Protego
								if (spell == 5){
									System.out.print("\nCannot train Protego. " +
											"Please choose a different spell.\n");
								}

								// handle invalid input integers
								if (spell != 1 && spell != 2 && spell != 3 && 
										spell != 4 && spell != 5){
									System.out.print("\nPlease choose the number of a spell.");
								}
							}
							// handle invalid input integers
							else {
								System.out.print("\nPlease use an integer.\n");
								in.next();
							}
						}

						System.out.print("Five health points deducted for training.\n");
					}
				}
				
				//if user chooses to heal
				if (choice == 4){
					//check that player has not reached maximum number of heals
					if (healing > 2){
						System.out.print("\nNo more heals remaining" + 
								"\nPlease choose another option.\n");
					}
					//update accordingly
					if (healing <= 2){
						healing ++;
						playerHealth = 50;
						System.out.print("\nHealth fully restored.\n");
					}

				}
				
				//if user chooses to forfeit
				if (choice == 5){
					playerHealth = 0;
				}
				
				// handle invalid input integers
				if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5){
					System.out.println("\nPlease choose the number of an option.");
				}
			}
			// handle invalid input integers
			else {
				System.out.println("\nPlease use an integer.\n");
				in.next();
			}
			
		}//end of game loop
		//print an end game report
		if (voldemortHealth == 0){
			System.out.print("\nCongratulations you have defeated Voldemort with " + 
					playerHealth + " health!");
		}
		if (playerHealth == 0){
			System.out.print("\nSorry, you have been defeated by Voldemort with " + 
					voldemortHealth + " health.");
		}
		System.out.print("\nPlayer Health: " + playerHealth + " Voldemort Health: " + 
				voldemortHealth +
				"\nNumber of Duels: " + numberOfDuels + "\n");
		
	} 
	
} //end main

