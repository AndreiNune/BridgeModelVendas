package implementacao;

import java.util.List;

/**
 * Concrete Implementor: simula a geracao de um arquivo PDF no console.
 */
public class ExportadorPDF implements FormatoExportacao {

    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("[PDF] Cabecalho renderizado -> " + titulo);
    }

    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[PDF] Corpo do documento (" + dados.size() + " registro(s)):");
        for (String linha : dados) {
            System.out.println("       [PDF] * " + linha);
        }
    }

    @Override
    public void finalizarArquivo() {
        System.out.println("[PDF] Arquivo finalizado -> relatorio.pdf");
    }
}
