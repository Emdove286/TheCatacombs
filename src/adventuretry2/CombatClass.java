/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuretry2;
import java.util.*;
/**
 *
 * @author Sam
 */
public class CombatClass 
{
    String[] comMod = new String[10000];
    String[] keyword = new String[10000];
    String[] batwon = new String[10000];
   
    boolean[] encDisable = new boolean[10000];
   // Random rand = new Random(42);
    public CombatClass(int pos, boolean[] isMod)
    {
      Scanner scan = new Scanner(System.in);
      String action;
        /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
        * Starting here you can add room scenarios by following the proper set-up
        *  You start with comMod[encounter position] which is the scenario set up given to the player
        *  this gives the player a description of the current encounter.
        *  Next is the isMod[encounter postion] which is a boolean variable needed to 
        *  turn the encounter on this is controlled in TheGame.class where there is a place for isMod initialiazation. Then you have the keyword[encounter position] which is the winning
        *  word needed to complete the encounter. if the player uses this word in their sentence,
        *  it will activate the win condition. Finally, the last part is batwon[encounter position]
        *  which will inform the player of their win and a description of the event that was handled
        */      
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
      comMod[301]= " Something grabs at your feet!! \n you feel the slime of a slime monster pull you down to your knees \n your going to drown unless you do something!!!";
      keyword[301] = "drain";
      batwon[301]= "The monster is pulled down the now open drain and no longer a threat!!\n the drain swiftly becomes clogged yet again by some old remains";
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
      comMod[5]="you see one of the corpse start to shake\n this continues until the corpse is shaking violently!\n the ancient corpse begins to show to you its glowing red eyes as it starts to rise\n you can see the violent intent in its eyes!!";
      keyword[5] = "support beams";
      batwon[5] = "as you pull on the rusty support beams to break them, you can see the ceiling begin to crumble\n finally the beam snaps and you feel the collapse of the cieling above you\nyou slowly push the rubble off of you to find that the dead body is no longer moving or glowing\n the room still looks about the same minus the new added foot of the ceiling now laying on the floor";
      
 //------------------------------------------------------------------------------------------------------------------------------------------------------------------- --------------------------------------------------------------------------------//
      if(isMod[pos])  // this is where the event handling takes place at to work the encounter
      {
          int tries = 3;
          System.out.println(comMod[pos]);
          for(int i=1;i<=3;i++)
          {
            System.out.println("what will you do!?!?! \n"+tries+" Tries left");
            action = scan.nextLine();
            if(action.contains(keyword[pos]))
            {
                System.out.println(batwon[pos]);
                i = 4;
                isMod[pos]=false;
            }
            else
                System.out.println("That did not work!!!!");
            tries--;
          } 
          if(isMod[pos])
          {
           System.out.println("you have fallen");
           System.exit(0);
          }

      } 
     
    }
}
