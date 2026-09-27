package abstracao;

import implementacao.FormatoExportacao;

import java.util.List;

/**
 * Abstraction do padrao Bridge.
 *
 * Mantem a referencia ao Implementor (FormatoExportacao) e delega a ele a
 * responsabilidade de desenhar o relatorio em um formato concreto.
 *
 * REGRA DE NEGOCIO / ARQUITETURAL: esta classe e suas subclasses NUNCA
 * instanciam um exportador concreto com "new" (ex.: "new ExportadorPDF()").
 * A dependencia e sempre recebida de fora - via construtor (injecao
 * obrigatoria) ou via setExportador (troca em tempo de execucao). Isso e o
 * que permite adicionar novos formatos de exportacao sem tocar nesta classe,
 * atendendo ao Principio Aberto/Fechado do SOLID.
 */
public abstract class Relatorio {

    protected FormatoExportacao exportador;

    protected Relatorio(FormatoExportacao exportador) {
        this.exportador = exportador;
    }

    /**
     * Permite substituir o exportador em tempo de execucao (setter
     * injection), mantendo a mesma instancia de Relatorio e apenas trocando
     * a implementacao de exportacao usada por ela.
     */
    public void setExportador(FormatoExportacao exportador) {
        this.exportador = exportador;
    }

    protected abstract String getTitulo();

    protected abstract List<String> getDados();

    /**
     * Operacao de negocio comum a qualquer relatorio: delega a renderizacao
     * inteira ao exportador injetado, sem conhecer sua implementacao
     * concreta (PDF, Excel, HTML ou qualquer formato futuro).
     */
    public void gerarRelatorio() {
        exportador.desenharCabecalho(getTitulo());
        exportador.desenharCorpo(getDados());
        exportador.finalizarArquivo();
    }
}
