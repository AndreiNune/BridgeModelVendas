package implementacao;

import java.util.List;

/**
 * Implementor do padrao Bridge.
 *
 * Define o contrato comum que qualquer formato de exportacao (PDF, Excel,
 * HTML, ou um formato futuro ainda nao imaginado) deve cumprir. A classe
 * Relatorio (Abstraction) so conhece este contrato, nunca uma implementacao
 * concreta.
 */
public interface FormatoExportacao {

    void desenharCabecalho(String titulo);

    void desenharCorpo(List<String> dados);

    void finalizarArquivo();
}
