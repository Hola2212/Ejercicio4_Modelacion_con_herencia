import java.util.ArrayList;
public class Bag{
    public ArrayList<Item> objetos = new ArrayList<>();
    public int espacio;
    public int disponible;
    public void setEspacio(int espacio){
        this.espacio = espacio;
    }
    public void setDisponible(int disponible){
        this.disponible = disponible;
    }
    public void modDisponible(int mod){
        disponible = disponible + mod;
    }
    public Item getObjeto(int pos){
        Item objeto = objetos.get(pos);
        objetos.remove(pos);
        return objeto;
    }
    public void anadirObjeto(Item objeto){
        objetos.add(objeto);
    }
    public int obtenerCantObjetos(){
        return objetos.size();
    }
    public int getEspacio(){
        return espacio;
    }
    public int getDisponible(){
        return disponible;
    }
    @Override
    public String toString(){
        String mensaje = "";
        for (int i = 0; i < objetos.size(); i++) {
            mensaje = mensaje + i + ") " + objetos.get(i).toString() + "\n";
        }
        return mensaje;
    }
}