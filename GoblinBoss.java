public class GoblinBoss extends Combatant{
    public Ability habilidad = new Ability("Escondida Cobarde", 60, 50, 0);
    public Attack ataqueEspecifico = new Attack("Ataque Rastrero", 60, 0, 0);
    public GoblinBoss(String nombre){
        super(nombre, 450, 200, 500);
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