public class ColaCircular {
    private String []cola;
    private int frente;
    private int finalcola;
    private int tamanio;
     public ColaCircular(int tamanio){
         this.tamanio = tamanio;
         cola = new String[tamanio];
         frente = -1;
         finalcola=-1;
     }
     public boolean estaVacia(){
         return (frente == -1);
     }
     public boolean estaLlena(){
         return ((finalcola + 1) % tamanio == frente);
     }
     public void encolar(String valor){
         if (estaLlena()){
             System.out.println("No se puede agendar mas citas");
             return;
         }
         if (estaVacia()){
             frente = 0;
         }
         finalcola = (finalcola + 1) % tamanio;
         cola[finalcola] = valor;
         System.out.println("Paciente Agendado: " + valor);
     }

     public String deseencolar(){
         if (estaVacia()){
             System.out.println("No hay citas que eliminar");
         }
         String valor = cola[frente];
         if (frente == finalcola){
             frente = -1;
             finalcola = -1;
         }else{
             frente = (frente + 1) % tamanio;
         }
         return valor;
     }
     public String frente() {
         if (estaVacia()){
             System.out.println("No hay Citas.");
         }
         return cola[frente];
     }
}

