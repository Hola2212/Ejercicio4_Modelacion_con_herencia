public class Player extends Combatant{
    public Player(String nombre, int ataque, int defensa, int vida){
        super(nombre, ataque, defensa, vida);
    }
    public String obtenerObjetos(){
        return "";
    }
    public Item obtenerObjeto(int pos){
        return new Item("", 0, 0, 0, 0, 0);
    }
    public Attack obtenerAtaque(int pos){
        return new Attack("", 0, 0, 0);
    }
}