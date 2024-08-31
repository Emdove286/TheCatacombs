
package adventuretry2;

import java.util.Scanner;


/**
 * 
 *@author Emma Ross
 *   
 *  This game is by no means gramtically correct.
 *  the following is the core of the code which controls
 *  the player on a 100 by 100 grid. it handles the introduction 
 *  and story beginning in the constructor and then runs moves to
 *  the play function which controls the actions that take pace each turn
 * 
 *  first action is the room description
 *  second is the the activation of combat class which runs the in-game combat
 *  third is the movement phase which starts the movement handler that controls 
 *  the players position on the 100 x 100 grid. this is controlled by a room id
 *  that starts at room one in the upper most left corner as room 0, down to
 *  the bottom most right which is 9999.
 *  
 */
public class TheGame 
{
    String name, dog, brother, move;
    int pos;
    Scanner scan = new Scanner(System.in);
    boolean up, down, quit = true;
    int[] rightside = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000,
        2100, 2200, 2300, 2400, 2500, 2600, 2700, 2800, 2900, 3000, 3100, 3200, 3300, 3400, 3500, 3600, 3700, 3800, 3900, 4000, 4100, 4200,
        4300, 4400, 4500, 4600, 4700, 4800, 4900, 5000, 5100, 5200, 5300, 5400, 5500, 5600, 5700, 5800, 5900, 6000, 6100, 6200, 6300, 6400,
        6500, 6600, 6700, 6800, 6900, 7000, 7100, 7200, 7300, 7400, 7500, 7600, 7700, 7800, 7900, 8000, 8100, 8200, 8300, 8400, 8500, 8600,
        8700, 8800, 8900, 9000, 9100, 9200, 9300, 9400, 9500, 9600, 9700, 9800, 9900, 10000};
    int[] leftside = {1, 101, 201, 301, 401, 501, 601, 701, 801, 901, 1001, 1101, 1201, 1301, 1401, 1501, 1601, 1701, 1801, 1901, 2001,
        2101, 2201, 2301, 2401, 2501, 2601, 2701, 2801, 2901, 3001, 3101, 3201, 3301, 3401, 3501, 3601, 3701, 3801, 3901, 4001, 4101, 4201,
        4301, 4401, 4501, 4601, 4701, 4801, 4901, 5001, 5101, 5201, 5301, 5401, 5501, 5601, 5701, 5801, 5901, 6001, 6101, 6201, 6301, 6401,
        6501, 6601, 6701, 6801, 6901, 7001, 7101, 7201, 7301, 7401, 7501, 7601, 7701, 7801, 7901, 8001, 8101, 8201, 8301, 8401, 8501, 8601,
        8701, 8801, 8901, 9001, 9101, 9201, 9301, 9401, 9501, 9601, 9701, 9801, 9901};
//--------------------------------------------------------------------------------------------------------------------------------------------------------//
      /* 
      * enter rooms that are blocked off to the player
      * this can be used to create a map for the game
      * each line will be a different room
      */
    int[] blocked = {6,101, 102, 103, 105, 202, 203, 305, 401, 402, 403, 404, 405,106,306,406,
        15,108,109,110,111,112,113,114,115,215,308,309,310,311,312,313,315,410,415,506,508,509,510,511,512,513,514,515,606,608,706,708,806,808};
    
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    boolean[] locked = new boolean[10000];
    boolean[] isMod = new boolean[10000];
    String[] desc = new String[10000];
    int[] key = new int[10000];
    int movecount;

    public TheGame() //lots of exposition
    {

        for (int i = 0; i < 10000; i++)//every value begins as true as to appeared locked
        {
            locked[i] = true;
        }
        /*
        * to set up a lock and key one must first set the room to locked by
        * taking the boolean array locked[], using the room's id for the index,
        * and then changing the value to false. Next is setting up the key.
        * To set up the key you will use the Int array key[], using the room id
        * of the room you want the key to be placed in as the index value 
        * and the value to be placed in the array will be the room number the
        * key unlocks.
        */
                
        
        locked[206] = false;
        key[201] = 206;
        
        locked[707]=false;
        key[411] = 707;
        
        locked[607]= false;
        key[14]= 607;
        
        locked[807]=false;
        key[214]= 807;
        
  //---------------------------------------------------------------------------------------------------------------------------//      
        /*
         * to make a room available for a combat scenario
         * change the boolean to true in the isMod[] array.
         * use the rooms id as the index.
        */
        isMod[301]=true;
        isMod[5]=true;
//-----------------------------------------------------------------------------------------------------------------------------//

        /* 
        *  here is a list of all the room descriptions
        *  they are ordered by their room number which also
        *  serves as their index in which they are located on the 
        *  array.
        */
        
//--------------------------Room One-----------------------------------------------------------------------------------------------------------------------------------------------------
        desc[1] = "\nYou find yourself in a small smelly room \nit is pretty dank \nthe old man lies in the corner \n to south north and west there is a wall";
        desc[2] = "\nyou are in a hallway adorned on the walls are skulls and bones \nyou can only move east and west";
        desc[3] = "\nyou are nearing the end of this hallway\nyou can only move east and west";
        desc[4] = "\nyou appear at an intersection with one way leading east and west \nwhich looks like more catacombs \n and one south which looks like the start of some sewers";
        desc[5] = "\nyou are coming to a dead end..\n you can see a collapes of the catacombs to the east which is filled with ancient corpses\n the roof is supported by very rusty and aging  support beams  that manage to keep even more bodies from caving in.\n the only way you can move is west";
        desc[104] = "\nyou feet sop deep into the disgusting decay as you enter the sewer\nthe stench is almost unberable\nthere are more catacombs north and to the south more sewer";
        desc[204] = "\nyou feel something bump against the back of your foot,\nit's a corpse floating down the sewer water\nthe sewer continues to you north south and east";
        desc[205] = "\nthe sewer seems to dry up a bit as you approach a door\nupon finding the door you notice it is old, rusty and has a lock\nwith out a key there is no moving past it\nyou can only move west, or east with the key";
        desc[304] = "\nyou see a grouping of bodies laying in the corner of this small corner hallway,\n the bodies seem to move a bit but only by the movement of the mice feeding off of them.\nyou can only go north and west";
        desc[303] = "\nyou see the hallway of the sewer as if its beginning to get taller\n but the water seem to also get deeper\n you can go west and east";
        desc[302] = "\nthe water is at your waist level now and you can see it staining your jacket\n you have fortunatley become numb to the smell\n you can move east and west";
        desc[301] = "\nyou are at another corner in this long dark sewer\n at your feet deep below the water you feel a   drain .\n seems to be clogged by bodies and debri\nyou see a ladder to your north and the hallway to your east";
        desc[201] = "\nyou climb the ladder to see what looks like an old man\n lying on thie ground. you check to see if he is alright\nthe man is dead\n in his pockets you find an old key and take it \n you can only climb down the ladder to the south";
        desc[206] = "\nYou have won the game!!! for now?!???!?!?!?!";
//--------------------------Room Two-----------------------------------------------------------------------------------------------------------------------------------------------------
        desc[7]="\nThe hall comes to a corner. You can feel the soft ground beneath your feet ever so slghtly squish.\nThe hallway continues east and south";
        desc[8]="";
        desc[9]="";
        desc[10]="";
        desc[11]="";
        desc[12]="";
        desc[13]="";
        desc[14]="";
        desc[107]="\nThe hall way here has a slight incline towards the north.\nIt looks like over time the dirt and rat feces has begun to pile up in this corridor.\nThe hallway continues north and south. s";
        desc[207]="\nThe section smells as if death had been here for a very long time.\nOne glance around the room supports your suspicions.\nthe remains of the old are here, buried under paris and long forgotten.\nCuriously enough you see some new remains pushed into some of the old remains\nperpetuating a new smell of death along with the old\n you see a hallway to the north east and south and the sewers to the west.";
        desc[208]="";
        desc[209]="";
        desc[210]="";
        desc[211]="";
        desc[212]="";
        desc[213]="";
        desc[214]="";
        desc[307]="";
        desc[314]="";
        desc[407]="";
        desc[408]="";
        desc[409]="";
        desc[411]="";
        desc[412]="";
        desc[413]="";
        desc[414]="";
        desc[507]="";
        desc[607]="";
        desc[707]="";
        desc[807]="";        
//--------------------------------------------------------------------------------------------------------------------------------//


        movecount = 0; // to keep track of movement score
//-----------------------------------------------------------------------------------------------------------------------------------//
/*
* This is the games start 
* exposition, included
*/
        pos = 1; //
        System.out.println("You have found your self in a dangerous place my child");
        System.out.println("How have you come to such a place? Do you not remember?");
        System.out.println("Do you atleast remember you name?");
        name = scan.next();
        System.out.println("Ah " + name + " is it? well " + name + " is there anything else?");
        System.out.println("do you remember maybe an old pet? ah i saw that in your face");
        System.out.println("you do remember a little bit more, what was this pets name?");
        dog = scan.next();
        System.out.println(dog + " is a great name");
        System.out.println("What else can we find about your mysterious past strange one?");
        System.out.println("do you have family? maybe  brother perhaps?");
        System.out.println("ah there it is, that glint in our face that shows you may still have some memory left up there");
        System.out.println("What was ths brother's name?");
        brother = scan.next();
        System.out.println("I can see your memory is still in there somewhere");
        System.out.println("im afraid you might be in trouble though my friend");
        System.out.println("you are quite a ways away from the surface");
        System.out.println("and unfortunatly im afraid that i have no answers on how to escape");
        System.out.println("I was born here and have never left");
        pressAnyKeyToContinue();
        System.out.println("i see you are confused. Well you find youself in the undercity\n");
        System.out.println("Do they not tell you of us in the upper city?");
        System.out.println("i know you arent from here, that insignia on your jackets looks like one of the emblems");
        System.out.println("my grand father used to have on his old military uniform");
        System.out.println("you see a long time ago after the great war france went into a depression");
        pressAnyKeyToContinue();
        System.out.println("my grand father who served in that war was caught in the middle of it");
        System.out.println("having no where for shelter he started living where the other homeless began to live");
        System.out.println("deep in the catacombs and old abandoned sewers");
        System.out.println("the french governement saw it as an eyesore");
        System.out.println("one day those who lived in the catacombs found access to the surface blocked");
        System.out.println("And here we all still live, plagued by disease, raiders, and worst of all the lack of food");
        pressAnyKeyToContinue();
        
        play();

    }
//------------------------------------------------------------------------------------------------------------//
    private void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");  // function for the line pauses
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
//-----------------------------------------------------------------------------------------------------------//
  
    
    public void area() // sets player movement constrictions
    { 
       System.out.println(desc[pos]); 

        if (pos <= 100) // determines whether player is blocked from moving upward or currently at top of map.
        {
            up = true;
        } else {
            if (locked[pos - 100]) {
                up = true;
            }
            up = false;
        }

        for (int q = 0; q < blocked.length; q++) {
            if (pos - 100 == blocked[q]) {
                up = true;
            }
        }

        if (pos >= 9901) // determines whether player is blocked from moving downward or currently at bottom of map.
        {
            down = true;
        }
        else if (locked[pos + 100]) 
        {
                down = false;
        }
       else
         down = true;
        
        for (int q = 0; q < blocked.length; q++) {
            if (pos + 100 == blocked[q]) {
                down = true;
            }
        }

    }
    
    
//-----------------------------------------------------------------------------------------------------------//
  
    
    public boolean left() {              // checks wether player can currently move left
        boolean no = false;
        if (locked[pos - 1]) {
            for (int i = 1; i <= 100; i++) {
                if (pos == leftside[i - 1]) {
                    no = true;
                }
                for (int q = 0; q < blocked.length; q++) {
                    if (pos - 1 == blocked[q]) {
                        no = true;
                    }
                }
            }
        } else {
            System.out.println("thats locked");
            no = true;
        }
        return no;
   }
    
    
//-----------------------------------------------------------------------------------------------------------//
  
    
    public boolean right() {             //checks wether player can currently move right
        boolean no = false;
        if (locked[pos + 1]) {
            for (int i = 1; i <= 100; i++) {
                if (pos == rightside[i - 1]) {
                    no = true;
                }
                for (int q = 0; q < blocked.length; q++) {
                    if (pos + 1 == blocked[q]) {
                        no = true;
                    }
                }
            }
        } else {
            System.out.println("thats locked");
            no = true;
        }
        return no;
    }

 //-----------------------------------------------------------------------------------------------------------//  
    
    public void move() // operates players movement on the grid
    {
       move = scan.nextLine();
        if (move.contains("north") || move.equals("n")) // .contains is found in string class and searches string for a specific word. w
        {                                                  // will can not use if words will be used which contain the key word
            if (up)                                        // example: key = find; words = "welcome pathfinder"; .contains will return true due to
            {                                               // pathfinder including the word "find";
                System.out.println("cant go that way");
            } else {
                pos = pos - 100;
            }
        }
        if (move.contains("south") || move.equals("s")) {
            if (down) {
                System.out.println("cant go that way");
            } else {
                pos = pos + 100;
            }
        }
        if (move.contains("west") || move.equals("w")) {
            if (left()) {
                System.out.println("cant go that way");
            } else {
                pos = pos - 1;
            }
        }
        if (move.contains("east") || move.equals("e")) {
            if (right()) {
                System.out.println("Cant go that way");
            } else {
                pos = pos + 1;
            }
        }
        System.out.println("position: " + pos);//current position marker for troubleshootingdv
        if (move.equals("quit"))
        {
            System.out.println(Integer.toString(movecount));
            pressAnyKeyToContinue();
            System.exit(0);
        }
    }
    
    
//-----------------------------------------------------------------------------------------------------------//
   
    
    public void unlock() {                 //this is the key handler
        if (key[pos] != 0) {               // controls the locked boolean array
            locked[key[pos]] = true;       // when player enters a room 
        }                                  // with a key.
    }
    

 //-----------------------------------------------------------------------------------------------------------//
    

    public void play() // the method that will start all game functions
    {
        while (quit) {
            
            unlock();
            if (movecount != 0){
                area();
                CombatClass comb = new CombatClass(pos,isMod);
            }
            move();
            movecount++;
       
        }
    }
}
