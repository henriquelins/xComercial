package br.com.ne.comercial.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class SobreComercialView extends JDialog {

	private static final long serialVersionUID = 1320955535683077595L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SobreComercialView dialog = new SobreComercialView();
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
	public SobreComercialView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SobreComercialView.class.getResource("/image/maos.png")));
		setTitle("COMERCIAL");
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 493, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane spProduto = new JScrollPane();
		spProduto.setBorder(null);
		spProduto.setBounds(34, 51, 417, 235);
		contentPanel.add(spProduto);
	}

	
	
}
