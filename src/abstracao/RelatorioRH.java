package abstracao;

import implementacao.FormatoExportacao;

import java.util.List;

/**
 * Refined Abstraction: especializa Relatorio com os dados de desempenho
 * de RH. Recebe o exportador via construtor - nunca o instancia
 * internamente.
 */
public class RelatorioRH extends Relatorio {

    public RelatorioRH(FormatoExportacao exportador) {
        super(exportador);
    }

    @Override
    protected String getTitulo() {
        return "Relatorio de Desempenho de RH";
    }

    @Override
    protected List<String> getDados() {
        return List.of(
                "Maria Silva - Avaliacao: 9.2 - Setor: TI",
                "Joao Pereira - Avaliacao: 8.7 - Setor: Suporte",
                "Carla Souza - Avaliacao: 9.0 - Setor: Infraestrutura"
        );
    }
}
