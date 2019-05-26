package br.com.ne.comercial.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjudaView extends JDialog {

	private static final long serialVersionUID = 1320955535683077595L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AjudaView dialog = new AjudaView();
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
	public AjudaView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AjudaView.class.getResource("/image/maos.png")));
		setTitle("COMERCIAL");
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 493, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panel.setBounds(-17, 247, 514, 86);
		contentPanel.add(panel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnCancelar.setRolloverIcon(new ImageIcon(AjudaView.class.getResource("/image/botao2.jpg")));
		btnCancelar.setIcon(new ImageIcon(AjudaView.class.getResource("/image/botao.jpg")));
		btnCancelar.setBorder(null);
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Segoe UI Semibold", Font.BOLD | Font.ITALIC, 12));
		btnCancelar.setBounds(212, 27, 89, 23);
		panel.add(btnCancelar);
	}
}
