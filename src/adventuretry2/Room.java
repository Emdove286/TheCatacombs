/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuretry2;

/**
 *
 * @author curse
 */
public class Room {
  String desc;
  int id;
  boolean paths[];
  Item items[];
  
  public Room(int id, String desc, boolean paths[], Item items[])
  {
      
  }
  public void setDesc(String desc)
  {
      this.desc = desc;
  }
  public void setId(int id)
  {
      this.id = id;
  }

}
