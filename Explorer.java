public class Explorer extends Player{
    public Attack[] ataques = {new Attack("Magia escondida", 0, 40, 50), new Attack("Mochila desenfrenada", 0, 0, 0)};
    public Bag bolsa = new Bag();
    public Explorer(String nombre){
        super(nombre, 200, 200, 500); // En el segundo ataque, se hará comprobación especifica para utilizar 2 objetos.
        this.bolsa.setEspacio(30);
        this.bolsa.setDisponible(30);
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