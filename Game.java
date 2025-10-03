import java.util.ArrayList;
public class Game{
    public ArrayList<Combatant> jugadoresDerrotados = new ArrayList<>();
    public ArrayList<Combatant> enemigosDerrotados = new ArrayList<>();
    public ArrayList<Combatant> jugadores = new ArrayList<>();
    public ArrayList<Combatant> enemigos = new ArrayList<>();
    public Shop objetos = new Shop();
    public final Consola consolita = new Consola();
    public int turno;
    public Game(){
        iniciarPartida();
    }
    public void iniciarPartida(){
        jugadores.clear();
        jugadoresDerrotados.clear();
        enemigos.clear();
        enemigosDerrotados.clear();
        int cantJugadores = consolita.mensajeCantidadJugadores();
        for (int i = 0; i < cantJugadores; i++) {
            jugadores.add(consolita.mensajeEscogerRol(consolita.mensajeCrearCombatiente("Jugador "+(i+1))));
        }
        int cantEnemigos = consolita.mensajeCantidadEnemigos();
        int cantGoblins = consolita.mensajeCantidadGoblins(cantEnemigos);
        int cantSkeletons = cantEnemigos - cantGoblins;
        for (int i = 0; i < cantGoblins; i++) {
            jugadores.add(consolita.mensajeEscogerDificultadGoblin(consolita.mensajeCrearCombatiente("Goblin "+(i+1))));
        }
        for (int i = 0; i < cantSkeletons; i++) {
            jugadores.add(consolita.mensajeEscogerDificultadSkeleton(consolita.mensajeCrearCombatiente("Skeleton "+(i+1))));
        }
        this.turno = 0;
    }
    public void ronda(){
        this.turno = this.turno + 1;
        consolita.mensajeRonda(this.turno);
        int cantJugadoresRestantes = jugadores.size();
        for (int i = 0; i < cantJugadoresRestantes; i++) {
            if (jugadores.get(cantJugadoresRestantes-1-i).getVida() <= 0){
                jugadores.get(cantJugadoresRestantes-1-i).setVida(0);
                jugadoresDerrotados.add(jugadores.get(cantJugadoresRestantes-1-i));
                jugadores.remove(cantJugadoresRestantes-1-i);
            }
        }
        if (jugadores.isEmpty() || enemigos.isEmpty()){}
        else{
            for (int i = 0; i < jugadores.size(); i++) {
                int accion = consolita.mensajeAccion(jugadores.get(i))-1;
                if (accion == 0 || accion == 1){
                    if (jugadores.get(i).obtenerAtaque(1).getNombre().equals("Mochila desenfrenada")){
                        //Falta aplicacion de bolsa. En este se utilizan dos objetos
                    }
                    else{
                        Attack ataqueActual = jugadores.get(i).obtenerAtaque(accion);
                        int indiceObjetivo = consolita.EscogerObjetivo(enemigos);
                        int efectAtack = ataqueActual.getEfectoAtaque();
                        int efectDefensa = ataqueActual.getEfectoDefensa();
                        int efectVida = ataqueActual.getEfectoVida();
                        jugadores.get(i).setDefensa(jugadores.get(i).getDefensa() + efectDefensa);
                        jugadores.get(i).setVida(jugadores.get(i).getVida() + efectVida);
                        enemigos.get(indiceObjetivo).setVida(enemigos.get(indiceObjetivo).getDefensa() / (efectAtack * jugadores.get(i).getAtaque()));
                        if (enemigos.get(indiceObjetivo).getVida() <= 0){
                            enemigos.get(indiceObjetivo).setVida(0);
                            enemigosDerrotados.add(enemigos.get(indiceObjetivo));
                            enemigos.remove(enemigos.get(indiceObjetivo));
                        }
                    }
                }
                else{
                    //No se termino la interaccion con bolsa y objetos. Hace falta implementacion de emtodos en clases padre con override en las hijas, luego crear la logica para utilizarlo.
                }
            }
            int cantEnemigosRestantes = enemigos.size();
            for (int i = 0; i < cantEnemigosRestantes; i++) {
                if (enemigos.get(cantEnemigosRestantes-1-i).getVida() <= 0){
                    enemigos.get(cantEnemigosRestantes-1-i).setVida(0);
                    enemigosDerrotados.add(enemigos.get(cantEnemigosRestantes-1-i));
                    enemigos.remove(cantEnemigosRestantes-1-i);
                }
            }
            if (enemigos.isEmpty() || jugadores.isEmpty()){}
            else{
                if (this.turno == 1){
                    for (int i = 0; i < enemigos.size(); i++) {
                        int jugadorAfectado = (int)((Math.random() * jugadores.size()));
                        int efectAtack = enemigos.get(i).obtenerHabilidad().getEfectoAtaque();
                        int efectDefensa = enemigos.get(i).obtenerHabilidad().getEfectoDefensa();
                        int efectVida = enemigos.get(i).obtenerHabilidad().getEfectoVida();
                        jugadores.get(jugadorAfectado).setVida(jugadores.get(jugadorAfectado).getDefensa() / (enemigos.get(i).getAtaque() * efectAtack));
                        enemigos.get(i).setDefensa(enemigos.get(i).getDefensa() + efectDefensa);
                        enemigos.get(i).setVida(enemigos.get(i).getVida() + efectVida);
                    }
                }
                else{
                    for (int i = 0; i < enemigos.size(); i++) {
                        int jugadorAfectado = (int)((Math.random() * jugadores.size()));
                        int efectAtack = enemigos.get(i).obtenerAtaque(0).getEfectoAtaque();
                        int efectDefensa = enemigos.get(i).obtenerAtaque(0).getEfectoDefensa();
                        int efectVida = enemigos.get(i).obtenerAtaque(0).getEfectoVida();
                        jugadores.get(jugadorAfectado).setVida(jugadores.get(jugadorAfectado).getDefensa() / (enemigos.get(i).getAtaque() * efectAtack));
                        enemigos.get(i).setDefensa(enemigos.get(i).getDefensa() + efectDefensa);
                        enemigos.get(i).setVida(enemigos.get(i).getVida() + efectVida);
                        if (jugadores.get(jugadorAfectado).getVida() <= 0){
                            jugadores.get(jugadorAfectado).setVida(0);
                            jugadoresDerrotados.add(enemigos.get(jugadorAfectado));
                            jugadores.remove(enemigos.get(jugadorAfectado));
                        }
                    }
                }
                if (enemigos.isEmpty() || jugadores.isEmpty()){}
                else{
                    ronda();
                }
            }
        }
    }
    public void ganador(){
        if (jugadores.isEmpty()){
            consolita.mensajeGanador("Enemigos");
        }
        else{
            consolita.mensajeGanador("Jugadores");
        }
    }
}