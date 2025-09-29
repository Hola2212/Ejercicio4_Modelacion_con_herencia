public class Attack{
    public String nombre;
    public int efectoAtaque;
    public int efectoDefensa;
    public int efectoVida;
    public Attack(String nombre, int efectoAtaque, int efectoDefensa, int efectoVida){
        this.nombre = nombre;
        this.efectoAtaque = efectoAtaque;
        this.efectoDefensa = efectoDefensa;
        this.efectoVida = efectoVida;
    }
    public int getEfectoAtaque() {
        return efectoAtaque;
    }
    public int getEfectoDefensa() {
        return efectoDefensa;
    }
    public int getEfectoVida() {
        return efectoVida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEfectoAtaque(int efectoAtaque){
        this.efectoAtaque = efectoAtaque;
    }
    public void setEfectoDefensa(int efectoDefensa){
        this.efectoDefensa = efectoDefensa;
    }
    public void setEfectoVida(int efectoVida){
        this.efectoVida = efectoVida;
    }
}