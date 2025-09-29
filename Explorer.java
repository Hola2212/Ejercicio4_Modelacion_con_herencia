public class Explorer extends Player{
    public Attack[] ataques = {new Attack("Magia escondida", 0, 40, 50), new Attack("Mochila desenfrenada", 0, 0, 0)};
    public Explorer(String nombre){
        super(nombre, 200, 200, 500); // En el segundo ataque, se hará comprobación especifica para utilizar 2 objetos.
    }
}