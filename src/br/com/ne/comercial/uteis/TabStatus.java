package br.com.ne.comercial.uteis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class TabStatus extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @Override public Component getTableCellRendererComponent(JTable table,
	 * Object value, boolean isSelected, boolean hasFocus, int row, int column)
	 * { JLabel label = (JLabel) super.getTableCellRendererComponent(table,
	 * value, isSelected, hasFocus, row, column); Color c = Color.WHITE; Object
	 * text = table.getValueAt(row, 3); if (text != null &&
	 * "VERMELHO".equals(text.toString())) c = Color.RED;
	 * label.setBackground(c); return label; }
	 */

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component renderer = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);

		// criando o cabeçalho cinza e linhas
		JTableHeader anHeader = table.getTableHeader();
		anHeader.setBackground(new Color(0,0,205));
		anHeader.setFont(new Font("Segoe UI Semibold", Font.PLAIN | Font.ITALIC, 10));
		anHeader.setForeground(new Color(0,0,205));
		
		//criando o alinhamento do cabeçalho da tabela
		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		// criando as cores da linhas e fontes
		Color fundo = null;
		Color fonte = null;

		//centralizando as fontes nas colunas
		setHorizontalAlignment(JLabel.CENTER);
		super.setValue(value);

		// criando linhas brancas e cinzas
		if (row % 2 == 0) {

			fundo = new Color(225, 225, 225);
			// fundo = new Color(238, 238, 238);

		} else {

			fundo = Color.white;

		}

		// fonte vermelha

		fonte = Color.RED;

		if (isSelected) {

			fundo = Color.YELLOW;
			fonte = new Color(0,0,205);
			
		}

		renderer.setBackground(fundo);
		renderer.setForeground(fonte);

		return renderer;
	}

}