package br.com.ne.comercial.controller;

import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class LancamentoTableModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//aqui transformei em coluna cada propriedade de Funcionario
    //que eu quero que seja exibida na tabela  
    private String colunas[] = {"Quantidade", "Data do Lançamento", "Saldo Anterior", "Saldo Atual", "Observações"};
    private ArrayList<LancamentoServico> listalancamentoServico;
    private final int COLUNA_QUANTIDADE = 0;
    private final int COLUNA_DATA_DO_LANCAMENTO = 1;
    private final int COLUNA_SALDO_ANTERIOR = 2;
    private final int COLUNA_SALDO_ATUAL = 3;
    private final int COLUNA_OBSERVACOES = 4;

    public LancamentoTableModel(ArrayList <LancamentoServico> listaLancamentoServico) {
        this.listalancamentoServico = listaLancamentoServico;
    }

    //retorna se a célula é editável ou não
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    //retorna o total de itens(que virarão linhas) da nossa lista
    @Override
    public int getRowCount() {
        return listalancamentoServico.size();
    }
    //retorna o total de colunas da tabela
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    //retorna o nome da coluna de acordo com seu indice
    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    //determina o tipo de dado da coluna conforme seu indice
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            
            case COLUNA_QUANTIDADE:
                return Integer.class;
            case COLUNA_DATA_DO_LANCAMENTO:
                return Date.class;
            case COLUNA_SALDO_ANTERIOR:
                return Integer.class;
            case COLUNA_SALDO_ATUAL:
                return Integer.class;
            case COLUNA_OBSERVACOES:
                return Integer.class;
            default:
                return String.class;
        }
    }

    //preenche cada célula da tabela
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LancamentoServico lancamentoServico = this.listalancamentoServico.get(rowIndex);

        switch (columnIndex) {
           
            case COLUNA_QUANTIDADE:
                return lancamentoServico.getQuantidadeDoPedido();
            case COLUNA_DATA_DO_LANCAMENTO:
                return lancamentoServico.getDataDoLancamento();
            case COLUNA_SALDO_ANTERIOR:
                return lancamentoServico.getSaldoAnterior();
            case COLUNA_SALDO_ATUAL:
                return lancamentoServico.getSaldoAtual();
            case COLUNA_OBSERVACOES:
                return lancamentoServico.getObservacoesLancamento();
        }
        return null;
    }
    //altera o valor do objeto de acordo com a célula editada
    //e notifica a alteração da tabela, para que ela seja atualizada na tela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //o argumento recebido pelo método é do tipo Object
        //mas como nossa tabela é de funcionários, é seguro(e até recomendável) fazer o cast de suas propriedades
    	LancamentoServico lancamentoServico = this.listalancamentoServico.get(rowIndex);
        //de acordo com a coluna, ele preenche a célula com o valor
        //respectivo do objeto de mesmo indice na lista
        switch (columnIndex) {
        	
        	case COLUNA_QUANTIDADE:
        		lancamentoServico.setQuantidadeDoPedido((int) aValue);
                break;
            case COLUNA_DATA_DO_LANCAMENTO:
            	lancamentoServico.setDataDoLancamento((Date) aValue);
                break;
            case COLUNA_SALDO_ANTERIOR:
            	lancamentoServico.setSaldoAnterior((int) aValue);
            case COLUNA_SALDO_ATUAL:
            	lancamentoServico.setSaldoAtual((int) aValue);
            case COLUNA_OBSERVACOES:
            	lancamentoServico.setObservacoesLancamento((String) aValue);
        }
        //este método é que notifica a tabela que houve alteração de dados
        fireTableDataChanged();
    }
    
    
    public void letras() {
    	
    	new DefaultTableCellRenderer() {

    		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void setValue(Object value) {
    			setBackground(new Color(238, 238, 238));
    			setForeground(Color.BLACK);
    			setHorizontalAlignment(JLabel.CENTER);
    			// outras alterações entram aqui…
    			super.setValue(value);
    		}
    	};		
    	
    }
    
    public void numeros(){
    	
    	new DefaultTableCellRenderer() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void setValue(Object value) {
				setHorizontalAlignment(JLabel.CENTER);
				super.setValue(value);
			}
		};

    }
	
    
}

