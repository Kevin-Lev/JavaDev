package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

    public static void main(String[] args) throws InterruptedException {

        Thread threadEmail = new Thread(thread1);
        Thread threadNotaFiscal = new Thread(thread2);

        threadEmail.start();
        threadNotaFiscal.start();

        System.out.println("Fim do código de teste de thread");
        JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");

    }

    private static Runnable thread1 = new Runnable(){
    
        @Override
        public void run() {
            // execução envio de e-mail;
            new Thread() {

                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } // 1000 milissegundos = 1 segundo
                        System.out.println("Executando alguma rotina, por exemplo envio de e-mail");
                    }
                };

            }.start(); // Liga a thread e fica processando paralelamente por trás.
        }
    };

    private static Runnable thread2 = new Runnable(){
    
        @Override
        public void run() {
            // execução nota fiscal
            new Thread() {

                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } // 1000 milissegundos = 1 segundo
                        System.out.println("Executando emissão de nota fiscal");
                    }
                };

            }.start(); // Liga a thread e fica processando paralelamente por trás.
        }
    };

}