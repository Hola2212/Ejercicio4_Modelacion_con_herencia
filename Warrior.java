public class Warrior extends Player{
    public Attack[] ataques = {new Attack("Espada sagrada", 80, 0, 0), new Attack("Escudo feroz", 20, 40, 0)};
    public Bag bolsa = new Bag();
    public Warrior(String nombre){
        super(nombre, 200, 200, 500);
        this.bolsa.setEspacio(20);
        this.bolsa.setDisponible(20);
    }
    @Override
    public String obtenerObjetos(){
        return bolsa.toString();
    }
    @Override
    public Item obtenerObjeto(int pos){
        return bolsa.getObjeto(pos);
    }
    @Override
    public Attack obtenerAtaque(int pos){
        return this.ataques[pos];
    }

}