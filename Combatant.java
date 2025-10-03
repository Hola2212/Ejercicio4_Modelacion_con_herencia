public class Combatant{
    public String nombre;
    public int ataque;
    public int defensa;
    public int vida;
    public Combatant(String nombre, int ataque, int defensa, int vida){
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vida = vida;
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getVida() {
        return vida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    public void setVida(int vida){
        this.vida = vida;
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
    public Ability obtenerHabilidad(){
        return new Ability("", 0, 0, 0);
    }
}