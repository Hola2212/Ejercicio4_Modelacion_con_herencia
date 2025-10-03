import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Consola{
    private final PrintStream cons;
    private final Scanner sc;
    public Consola(){
        cons = System.out;
        sc = new Scanner(System.in);
    }
    public void mensajeBienvenida(){
        cons.println("Bienvenido al juego de estrategia.");
        cons.println("Los jugadores escogeran entre guerrero y explorador. Mientras los enemigos serán duendes o esqueletos.");
        cons.println("Se comenzara la partida:\n");
    }
    public int mensajeCantidadJugadores(){
        int comprobacion = 0;
        while (comprobacion <= 0 || comprobacion >= 5){
            cons.println("Ingrese la cantidad de jugadores. (1-4)");
            comprobacion = sc.nextInt();
        }
        return comprobacion;
    }
    public int mensajeCantidadEnemigos(){
        int comprobacion = 0;
        while (comprobacion < 5 || comprobacion > 12){
            cons.println("Ingrese la cantidad de enemigos. (5-12)");
            comprobacion = sc.nextInt();
        }
        return comprobacion;
    }
    public String mensajeCrearCombatiente(String personaje){
        cons.printf("Ingrese el nombre del %s", personaje);
        String nombre = "";
        while (nombre.equals("")){
            nombre = sc.nextLine();
        }
        return nombre;
    }
    public Combatant mensajeEscogerRol(String nombre){
        cons.println("Ingrese el numero para el rol: \n\t1) Warrior.\n\t2) Explorer.");
        int rol = 0;
        while (rol != 1 || rol != 2){
            rol = sc.nextInt();
        }
        if (rol == 1){
            return new Warrior(nombre);
        }
        else{
            return new Explorer(nombre);
        }
    }
    public Combatant mensajeEscogerDificultadGoblin(String nombre){
        cons.println("Ingrese el numero para la dificultad del goblin: \n\t1) Normal.\n\t2) Boss.");
        int rol = 0;
        while (rol != 1 || rol != 2){
            rol = sc.nextInt();
        }
        if (rol == 1){
            return new GoblinNormal(nombre);
        }
        else{
            return new GoblinBoss(nombre);
        }
    }
    public Combatant mensajeEscogerDificultadSkeleton(String nombre){
        cons.println("Ingrese el numero para la dificultad del skeleton: \n\t1) Normal.\n\t2) Boss.");
        int rol = 0;
        while (rol != 1 || rol != 2){
            rol = sc.nextInt();
        }
        if (rol == 1){
            return new SkeletonNormal(nombre);
        }
        else{
            return new SkeletonBoss(nombre);
        }
    }
    public int mensajeAccion(Combatant jugador){
        cons.printf("Ingrese el numero de accion a realizar: \n\t1) Ataque %s.\n\t2) Ataque %s.\n\t3) 3) Usar objeto.", jugador.obtenerAtaque(0).getNombre(), jugador.obtenerAtaque(1).getNombre());
        int rol = 0;
        while (rol != 1 || rol != 2 || rol != 3){
            rol = sc.nextInt();
        }
        return rol;
    }
    public int mensajeCantidadGoblins(int enemigos){
        int comprobacion = 0;
        while (comprobacion < 0 || comprobacion > enemigos){
            cons.printf("Ingrese la cantidad de enemigos de tipo goblin. El resto serán esqueletos. (0-%d)\n", enemigos);
            comprobacion = sc.nextInt();
        }
        return comprobacion;
    }
    public int EscogerObjetivo(ArrayList<Combatant> opciones){
        int cantOpciones = opciones.size();
        int comprobacion = -1;
        String textoOpciones = "";
        for (int i = 0; i < cantOpciones; i++) {
            textoOpciones = textoOpciones + i + ") " + opciones.get(i).getNombre();
        }
        while (comprobacion < 0 || comprobacion >= cantOpciones){
            cons.printf("Escoja el enemigo a objetivo. (0-%d)\n", cantOpciones-1);
            comprobacion = sc.nextInt();
        }
        return comprobacion;
    }
    public void mensajeGanador(String ganadores){
        if (ganadores.equals("Jugadores")){
            cons.println("Felicidades a los jugadores. Han salido vencedores");
        }
        else{
            cons.println("Han ganado los enemigos. Mejor suerte la próxima.");
        }
    }
    public void mensajeRonda(int turno){
        cons.printf("Se comenzará la ronda #%d.\n", turno);
    }
    public int mensajeEscogerObjeto(Bag bolsa){
        int eleccion = -1;
        while (eleccion < 0 || eleccion >= bolsa.obtenerCantObjetos()){
            cons.println("Escoja una de las opciones de su bolsa.");
            cons.print(bolsa.toString());
        }
        return eleccion;
    }
}