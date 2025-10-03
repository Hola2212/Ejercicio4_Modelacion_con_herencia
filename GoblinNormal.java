public class GoblinNormal extends Combatant{
    public Ability habilidad = new Ability("Escondida Cobarde", 20, 30, 0);
    public Attack ataqueEspecifico = new Attack("Ataque Rastrero", 40, 0, 0);
    public GoblinNormal(String nombre){
        super(nombre, 300, 200, 250);
    }
    @Override
    public Attack obtenerAtaque(int pos){
        return this.ataqueEspecifico;
    }
    @Override
    public Ability obtenerHabilidad(){
        return this.habilidad;
    }
}