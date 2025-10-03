public class Shop {
    public Item[] objetos = new Item[6];
    public Shop(){
        objetos[0] = new Item("Pocion", 0, 0, 80, 1, 3);
        objetos[1] = new Item("Cuchilla", 30, 0, 0, 1, 1);
        objetos[2] = new Item("Chaleco", 0, 30, 0, 1, 1);
        objetos[3] = new Item("Sopa misteriosa", 30, 30, -20, 1, 2);
        objetos[4] = new Item("Sacrificio debilitador", -10, -10, 50, 1, 2);
        objetos[5] = new Item("Revivir", 0, 0, 200, 1, 10);
    }

    public Item getObjeto(int index){
        return objetos[index];
    }
    @Override
    public String toString(){
        String res = "";
        for (int i = 0; i < 6; i++) {
            res = res + i + objetos[0].toString() + "\n";
        }
        return res;
    }
}
