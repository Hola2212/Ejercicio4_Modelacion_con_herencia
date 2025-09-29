public class Warrior extends Player{
    public Attack[] ataques = {new Attack("Espada sagrada", 80, 0, 0), new Attack("Escudo feroz", 20, 40, 0)};
    public Warrior(String nombre){
        super(nombre, 200, 200, 500);
    }
}