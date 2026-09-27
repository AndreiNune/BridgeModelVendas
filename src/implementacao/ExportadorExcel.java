package implementacao;

import java.util.List;

/**
 * Concrete Implementor: simula a geracao de uma planilha Excel (XLSX)
 * no console.
 */
public class ExportadorExcel implements FormatoExportacao {

    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("[XLSX] Celula A1 preenchida -> " + titulo);
    }

    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[XLSX] Preenchendo " + dados.size() + " linha(s) a partir de A2:");
        int linha = 2;
        for (String dado : dados) {
            System.out.println("        [XLSX] A" + linha + " -> " + dado);
            linha++;
        }
    }

    @Override
    public void finalizarArquivo() {
        System.out.println("[XLSX] Planilha finalizada -> relatorio.xlsx");
    }
}
