package cliente;

import abstracao.Relatorio;
import abstracao.RelatorioRH;
import abstracao.RelatorioVendas;
import implementacao.ExportadorExcel;
import implementacao.ExportadorHTML;
import implementacao.ExportadorPDF;
import implementacao.FormatoExportacao;

/**
 * Client do padrao Bridge.
 *
 * Conhece Relatorio (Abstraction) e FormatoExportacao (Implementor), e e o
 * UNICO ponto do sistema onde os exportadores concretos sao instanciados
 * com "new" - a composicao (injecao de dependencia) acontece aqui, nunca
 * dentro das classes de relatorio.
 *
 * Este script comprova o desacoplamento do padrao executando 3 rotinas:
 *   1) Relatorio de Vendas exportado em PDF;
 *   2) o MESMO relatorio de vendas trocando para Excel em tempo de execucao;
 *   3) Relatorio de RH exportado em HTML.
 */
public class Main {

    public static void main(String[] args) {

        separador("Rotina 1: Relatorio de Vendas exportado em PDF");
        FormatoExportacao exportadorPDF = new ExportadorPDF();
        Relatorio relatorioVendas = new RelatorioVendas(exportadorPDF); // injecao via construtor
        relatorioVendas.gerarRelatorio();

        separador("Rotina 2: MESMO relatorio de vendas, agora em Excel (troca em runtime)");
        FormatoExportacao exportadorExcel = new ExportadorExcel();
        relatorioVendas.setExportador(exportadorExcel); // injecao via setter - mesma instancia
        relatorioVendas.gerarRelatorio();

        separador("Rotina 3: Relatorio de Desempenho de RH exportado em HTML");
        FormatoExportacao exportadorHTML = new ExportadorHTML();
        Relatorio relatorioRH = new RelatorioRH(exportadorHTML); // injecao via construtor
        relatorioRH.gerarRelatorio();

        System.out.println();
        System.out.println("Desacoplamento comprovado: a mesma instancia de RelatorioVendas gerou");
        System.out.println("saidas em dois formatos diferentes sem qualquer alteracao em seu codigo,");
        System.out.println("e nenhuma classe de relatorio usou 'new' sobre um exportador concreto.");
    }

    private static void separador(String titulo) {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println(titulo);
        System.out.println("=========================================================");
    }
}
