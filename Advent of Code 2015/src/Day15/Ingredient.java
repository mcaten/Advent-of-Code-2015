package Day15;
public class Ingredient {
  private String name;
  private int capacity;
  private int durability;
  private int flavor;
  private int texture;
  private int calories;
  
  public Ingredient(String name, int capacity, int durability, int flavor, int texture, int calories) {
    this.name = name;
    this.capacity = capacity;
    this.durability = durability;
    this.flavor = flavor;
    this.texture = texture;
    this.calories = calories;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getCapacity() {
    return this.capacity;
  }
  
  public int getDurability() {
    return this.durability;
  }
  
  public int getFlavor() {
    return this.flavor;
  }
  
  public int getTexture() {
    return this.texture;
  }
  
  public int getCalories() {
    return this.calories;
  }
}