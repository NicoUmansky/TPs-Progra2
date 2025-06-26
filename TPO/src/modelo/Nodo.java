package modelo;
import interfaces.INodo;

public class Nodo implements INodo {
    int id;
    int dist;

    public Nodo(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public int getDist() {
        return dist;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void setDist(int dist) {
        this.dist = dist;
    }
}