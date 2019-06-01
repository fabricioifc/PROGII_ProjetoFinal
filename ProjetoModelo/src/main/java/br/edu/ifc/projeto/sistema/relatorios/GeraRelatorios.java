/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.projeto.sistema.relatorios;

/**
 *
 * @author fabricio
 */
public class GeraRelatorios {

    public static void main(String[] args) {

        try {
//            RelatorioUtil relUtil = new RelatorioUtil();
//            
//            RelatorioModel relatorio1 = new RelatorioModel("src/main/resources/relatorios/produtos.jrxml", "Produtos");
//            RelatorioModel relatorio2 = new RelatorioModel("src/main/resources/relatorios/produtos.jrxml", "Produtos");
//            RelatorioModel relatorio3 = new RelatorioModel("src/main/resources/relatorios/produtos.jrxml", "Produtos");
//            
//            relUtil.criarRelatorio(relatorio1);
//            relUtil.criarRelatorio(relatorio2);
//            relUtil.criarRelatorio(relatorio3);
//            
//            relUtil.iniciarFilaRelatorios();

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    boolean flag = true;
                    int i = 0;
                    while (flag) {
                        try {
                            i++;
                            System.out.println("Contador -> " + i);
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            };
            Thread bg = new Thread(r);
            bg.start();
            System.out.println("Terminou");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
