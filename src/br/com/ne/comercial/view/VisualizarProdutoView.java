package br.com.ne.comercial.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VisualizarProdutoView extends JDialog {

	private static final long serialVersionUID = 1320955535683077595L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextPane tpProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisualizarProdutoView dialog = new VisualizarProdutoView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisualizarProdutoView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VisualizarProdutoView.class.getResource("/image/maos.png")));
		setTitle("COMERCIAL");
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 493, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DESCRI\u00C7\u00C3O DO PRODUTO");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(21, 0, 444, 30);
		contentPanel.add(lblNewLabel);
		
		JScrollPane spProduto = new JScrollPane();
		spProduto.setBorder(null);
		spProduto.setBounds(21, 51, 444, 235);
		contentPanel.add(spProduto);
		
		tpProduto = new JTextPane();
		spProduto.setViewportView(tpProduto);
		tpProduto.setBorder(new LineBorder(new Color(0, 0, 205), 2));
		tpProduto.setForeground(new Color(0, 0, 205));
		tpProduto.setBackground(Color.WHITE);
		tpProduto.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
	}

	
	public JTextPane getTpProduto() {
		return tpProduto;
	}

	public void setTpProduto(JTextPane tpProduto) {
		this.tpProduto = tpProduto;
	}
}
