package cursojava.thread;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.InsetsUIResource;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog {

    private JPanel jpanel = new JPanel(new GridBagLayout()); // Painel de componentes
    private JLabel descricaoHora = new JLabel("Nome"); // Label
    private JTextField mostraTempo = new JTextField();

    private JLabel descricaoHora2 = new JLabel("E-mail"); // Label
    private JTextField mostraTempo2 = new JTextField();

    private JButton startButton = new JButton("Add Lista");
    private JButton stopButton = new JButton("Stop");


    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

    private Runnable thread = new Runnable() {

        @Override
        public void run() {
            while (true) {
                mostraTempo
                        .setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };

    private Runnable thread2 = new Runnable() {

        @Override
        public void run() {
            while (true) {
                mostraTempo2
                        .setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").format(Calendar.getInstance().getTime()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };

    // private Thread thread1Time;
    // private Thread thread2Time;

    public TelaTimeThread() { // executa o que tive dentro no momento da abertura ou execução

        setTitle("Minha tela de time com Thread!");
        setSize(240, 240);
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints(); // Controlador de posicionamento de componentes

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        // gridBagConstraints.insets = new Insets(5, 10, 5, 5); original
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = gridBagConstraints.WEST;

        descricaoHora.setPreferredSize(new Dimension(200, 25));
        jpanel.add(descricaoHora, gridBagConstraints);

        mostraTempo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        mostraTempo.setEditable(true);
        jpanel.add(mostraTempo, gridBagConstraints);

        descricaoHora2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jpanel.add(descricaoHora2, gridBagConstraints);

        mostraTempo2.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        mostraTempo2.setEditable(true);
        jpanel.add(mostraTempo2, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        startButton.setPreferredSize(new Dimension(100, 25));
        gridBagConstraints.gridy++;
        jpanel.add(startButton, gridBagConstraints);

        stopButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jpanel.add(stopButton, gridBagConstraints);

        startButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (fila == null){
                    fila = new ImplementacaoFilaThread();
                    fila.start();
                    System.out.println("Fila reativada!");
                }

                for (int q = 0; q < 100; q++){
                    ObjetoFilaThread objetoFilaThread = new ObjetoFilaThread();
                    objetoFilaThread.setNome(mostraTempo.getText());
                    objetoFilaThread.setEmail(mostraTempo2.getText() + q);
                    fila.add(objetoFilaThread);
                }


            }
        });

        stopButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                fila.stop();
                fila = null; // "mata o objeto"
            }
        
        });

        add(jpanel, BorderLayout.WEST);
        //Sempre será o último comando
        fila.start();
        setVisible(true); //Torna a tela visível para o usuário

    }

}