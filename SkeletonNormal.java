public class SkeletonNormal extends Combatant{
    public Ability habilidad = new Ability("Berserk", 20, 30, 0);
    public Attack ataqueEspecifico = new Attack("Cuchillada infernal", 50, 0, 5);
    public SkeletonNormal(String nombre){
        super(nombre, 180, 150, 450);
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