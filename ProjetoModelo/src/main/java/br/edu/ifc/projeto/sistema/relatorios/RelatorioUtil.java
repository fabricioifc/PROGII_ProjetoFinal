/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.projeto.sistema.relatorios;

import br.edu.ifc.conexao.db.DatabaseConnection;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.Queue;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 *
 * @author fabricio
 */
public class RelatorioUtil implements Runnable {

    private Queue<RelatorioModel> relatorios;
    private Thread fila;

    private Connection conexao;

    private volatile boolean podeExecutar = true;

    public RelatorioUtil() throws Exception {
        relatorios = new LinkedList<>();
        //Cria a Thread
        iniciarFilaRelatorios();
    }

    public void criarRelatorio(RelatorioModel relatorio) throws Exception {
        this.relatorios.add(relatorio);
    }

    private void gerarRelatorio(RelatorioModel rel) throws Exception {
        //Compila o relatório
        JasperReport jasperReport = JasperCompileManager.compileReport(rel.getCaminhoParaRelatorio());
        //Pega a Conexão
        this.conexao = DatabaseConnection.getInstance().getConnection();
        // Cria o relatório
        JasperPrint print = JasperFillManager.fillReport(jasperReport, rel.getParametros(), conexao);
        // Arquivo temporário gerado
        File pdf = File.createTempFile(rel.getNomeRelatorio(), ".pdf");

        // Exportando o PDF.
        JRPdfExporter exporter = new JRPdfExporter();

        ExporterInput exporterInput = new SimpleExporterInput(print);
        exporter.setExporterInput(exporterInput);
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(pdf);
        exporter.setExporterOutput(exporterOutput);
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();

        Desktop.getDesktop().open(pdf);

        System.out.print("Terminou!");
        DatabaseConnection.fecharConexao();
    }

    public void iniciarFilaRelatorios() {
        podeExecutar = true;
        if (fila == null || !fila.isAlive()) {
            fila = new Thread(this);
            fila.start();
        }
//        run();
    }

    public void pararFileRelatorios() {
        this.podeExecutar = false;
        if (fila.isAlive()) {
            fila.interrupt();
        }
    }

    public boolean estaExecutando() {
        return podeExecutar;
    }

    public Integer getTamanhoFila() {
        return relatorios != null ? relatorios.size() : 0;
    }

    @Override
    public void run() {
        try {
            while (podeExecutar && fila.isAlive()) {
                System.out.println("Fila com " + getTamanhoFila() + " relatórios");
                if (!relatorios.isEmpty()) {
                    System.out.println("Executando Relatório");

                    gerarRelatorio(relatorios.peek());
                    relatorios.remove();
                }
                System.out.println(fila.getState().name());
                Thread.sleep(3000);
            }
        } catch (InterruptedException ex) {
            System.out.println(fila.getState().name());
            System.out.println("Fila Parada!");
        } catch (Exception ex) {
            System.out.println(fila.getState().name());
            ex.printStackTrace();
        }
    }
}
