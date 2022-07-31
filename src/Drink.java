public class Drink {
    private String DrinkName;
    private int Drinknum;
    private int Price;
    private ModelType.DrinkType drinkType;

    public int getDrinknum() {
        return this.Drinknum;
    }

    public void setDrinknum(int Drinknum) {
        this.Drinknum = Drinknum;
    }

    public int getPrice() {
        return this.Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public ModelType.DrinkType getDrinkType() {
        return this.drinkType;
    }

    public void setDrinkType(ModelType.DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkName() {
        return this.DrinkName;
    }

    public void setDrinkName(String DrinkName) {
        this.DrinkName = DrinkName;
    }
}
