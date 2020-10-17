package zone.webtraining.question;

import zone.webtraining.question.models.Question;

public class Lista {
    private Nodo cabeza=null;
    private int longitud=0;
    private class Nodo{
        public Question question;
        public Nodo siguiente=null;

        public Nodo(Question question) {
            this.question = question;
        }
    }
    public void insertar(Question question){
        if(longitud==0){
            Nodo nodo=new Nodo(question);
            nodo.siguiente=cabeza;
            cabeza=nodo;
            longitud++;
        }else {
            Nodo nodo = new Nodo(question);
            Nodo puntero = cabeza;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodo;
            longitud++;
        }
    }
        public Question obtener(int n){
        if (cabeza==null){
            return null;
        }
        else{
           Nodo puntero=cabeza;
           int contador=0;
           while(contador<n && puntero.siguiente !=null){
               puntero=puntero.siguiente;
               contador++;
           }
           if (contador!=n){
               return null;
           }else{
               return puntero.question;
           }
        }
        }
        public int contar(){
            return longitud;
        }
        public boolean  vacio(){
            return cabeza==null;
        }
        public void eliminar(int n){
        if(cabeza!= null) {
            if (n == 0) {
                Nodo primer=cabeza;
                cabeza=cabeza.siguiente;
                primer.siguiente=null;
                longitud--;
            } else {
                Nodo puntero = cabeza;
                int contador = 0;
                while (contador < n - 1) {
                    puntero = puntero.siguiente;
                    contador++;
                }
                Nodo aux = puntero.siguiente;
                puntero.siguiente = aux.siguiente;
                aux.siguiente = null;
                longitud--;
            }
        }
        }
}
