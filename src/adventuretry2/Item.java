
package adventuretry2;

public class Item {
    String name, type;
    int weight, damage;
    public Item(String name, String type, int weight, int damage)
    {
        setName(name);
        setType(type);
        setWeight(weight);
        setDamage(damage);
    }
    public void setName(String name)
    {
        this.name = name ;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public void setWeight(int weight)
    {
       this.weight = weight; 
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    
    public String getName()
    {
        return name;
    }
    public String getType()
    {
        return type;
    }
    public int getWeight()
    {
       return weight;
    }
    public int getDamage()
    {
        return damage;
    }
}
