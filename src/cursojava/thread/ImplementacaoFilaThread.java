package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public static void add(ObjetoFilaThread objetoFilaThread) {
        pilha_fila.add(objetoFilaThread);
    }

    @Override
    public void run() {

        // System.out.println("Fila rodando!!!");

        
        while(true){
            
            synchronized (pilha_fila) { // Bloquear o acesso a esta lista por outros processos
                
                Iterator iteracao = pilha_fila.iterator();

                while (iteracao.hasNext()) { // Enquanto conter dados na lista irá processar
                    ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next(); // pega o objeto atual
        
                    // Processar 10 mil notas fiscais
                    // Gerar uma lista enorme de PDF
                    // Gerar um envio em massa de email
    
                    System.out.println("----------------------------");
    
                    System.out.println(processar.getNome());
                    System.out.println(processar.getEmail());
        
                    iteracao.remove();
        
                    try {
                        Thread.sleep(1000); // Dar um tempo pra descarga de memória
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        
                try {
                    Thread.sleep(1000); // Processou toda a lista, dar um tempo para limpeza de memória
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    
            }

        }


    }

    // @Override
    // public synchronized void start() {
    //     this.start(); //referência para ImplementacaoFilaThread
    // }

}