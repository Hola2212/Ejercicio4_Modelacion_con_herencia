public class Item{
    public Ability general;
    public int cantidad;
    public int espacio;
    public Item(String nombre, int efectoAtaque, int efectoDefensa, int efectoVida, int cantidad, int espacio){
        this.cantidad = cantidad;
        this.espacio = espacio;
        this.general = new Ability(nombre, efectoAtaque, efectoDefensa, efectoVida);
    }
    public int getCantidad() {
        return cantidad;
    }
    public int getEspacio() {
        return espacio;
    }
    public void modCantidad(int mod){
        cantidad = cantidad + mod;
    }
    public void modEspacio(int mod){
        espacio = espacio + mod;
    }
    public Ability getGeneral() {
        return general;
    }
    public String getNombre() {
        return general.getNombre();
    }
    public int getEfectoAtaque() {
        return general.getEfectoAtaque();
    }
    public int getEfectoDefensa() {
        return general.getEfectoDefensa();
    }
    public int getEfectoVida() {
        return general.getEfectoVida();
    }
    @Override
    public String toString(){
        return String.format("Nombre: %s, Efecto en ataque: %d, Efecto en defensa: %d, Efecto en vida: %d, Cantidad: %d, Espacio que ocupa: %d.", general.getNombre(), general.getEfectoAtaque(), general.getEfectoDefensa(), general.getEfectoVida(), cantidad, espacio);
    }
}