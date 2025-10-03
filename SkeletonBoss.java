public class SkeletonBoss extends Combatant{
    public Ability habilidad = new Ability("Berserk", 40, 40, 0);
    public Attack ataqueEspecifico = new Attack("Cuchillada infernal", 50, 0, 5);
    public SkeletonBoss(String nombre){
        super(nombre, 180, 300, 700);
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