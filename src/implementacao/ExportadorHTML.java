package implementacao;

import java.util.List;

/**
 * Concrete Implementor: simula a geracao de uma pagina HTML no console.
 */
public class ExportadorHTML implements FormatoExportacao {

    @Override
    public void desenharCabecalho(String titulo) {
        System.out.println("[HTML] <h1>" + titulo + "</h1>");
    }

    @Override
    public void desenharCorpo(List<String> dados) {
        System.out.println("[HTML] <table> com " + dados.size() + " <tr> gerada(s):");
        for (String linha : dados) {
            System.out.println("        [HTML] <tr><td>" + linha + "</td></tr>");
        }
    }

    @Override
    public void finalizarArquivo() {
        System.out.println("[HTML] Arquivo finalizado -> relatorio.html");
    }
}
