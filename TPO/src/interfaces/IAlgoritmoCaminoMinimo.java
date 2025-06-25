package interfaces;

public interface IAlgoritmoCaminoMinimo<T> {
    int[] calcularCaminosMinimos(IGrafo<T> grafo, T origen);
}
