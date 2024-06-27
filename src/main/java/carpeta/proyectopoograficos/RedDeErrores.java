package carpeta.proyectopoograficos;

public class RedDeErrores {

    /**
     * Aqui se atrapara el error de cuando el numero sobrepase el grosor del mazo jugable,
     * osea del jugador 1 o 2
     * @param numero El numero que se quiere emplear
     * @param tamano El grosor maximo del mazo que se este interactuando
     * @return Devuelve el numero si esta dentro del rango del mazo
     * @author Miguel Canache
     */
    public double errorMazo(int numero, int tamano)  {
        if(numero > tamano)
            throw new ArithmeticException("ERROR:Recuerda que son numeros entre 0 y "+tamano+", vuelve a escribir");
        else
            return (numero);
    }





}
