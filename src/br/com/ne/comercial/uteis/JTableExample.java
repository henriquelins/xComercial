package br.com.ne.comercial.uteis;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableExample extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3350878104105189667L;
	private JTable tabela;
    private JScrollPane scrollPainel;

    public JTableExample() {
        renderizarTela();
    }

    private void renderizarTela() {

        //4 ojetos criados para popular a tabela
        Funcionario f1 = new Funcionario("Roberto", 33, 1220);
        Funcionario f2 = new Funcionario("Diego", 25, 1615);
        Funcionario f3 = new Funcionario("Afonso", 25, 1458);
        Funcionario f4 = new Funcionario("Sergio", 42, 1165);

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);

        //cria um objeto do nosso model
        FuncionarioTableModel model = new FuncionarioTableModel(funcionarios);

        //instancia a tabela já com o model como argumento
        this.tabela = new JTable(model);
        this.scrollPainel = new JScrollPane(tabela);

        this.add(scrollPainel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTableExample tb = new JTableExample();
                tb.setLocationRelativeTo(null);
                tb.setVisible(true);
            }
        });
    }
}