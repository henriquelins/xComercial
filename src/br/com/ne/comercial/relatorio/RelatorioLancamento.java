package br.com.ne.comercial.relatorio;

import java.awt.Toolkit;
import java.io.InputStream;
import java.util.List;

import javax.swing.JDialog;

import br.com.ne.comercial.controller.LancamentoServico;
import br.com.ne.comercial.view.PrincipalComercialView;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioLancamento {

	public void gerarRelatorioLancamento(List<LancamentoServico> listaLancamentoServicoPorData ) throws JRException {
		
		JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
		viewer.setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalComercialView.class.getResource("/image/maos.png")));
		viewer.setSize(1200, 800);
		viewer.setLocationRelativeTo(null);
		
		InputStream fonte = RelatorioLancamento.class.getResourceAsStream("/report/relatorioLancamento.jrxml");
		
		JRDataSource jrds = new JRBeanCollectionDataSource(listaLancamentoServicoPorData);

		JasperReport report = JasperCompileManager.compileReport(fonte);
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, null , jrds);
		JasperViewer jrViewer = new JasperViewer(jasperPrint, false);	

		viewer.getContentPane().add(jrViewer.getContentPane());
		viewer.setVisible(true);
		
	}
	

}
