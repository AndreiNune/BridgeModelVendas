package abstracao;

import implementacao.FormatoExportacao;

import java.util.List;

/**
 * Refined Abstraction: especializa Relatorio com os dados de vendas.
 * Recebe o exportador via construtor - nunca o instancia internamente.
 */
public class RelatorioVendas extends Relatorio {

    public RelatorioVendas(FormatoExportacao exportador) {
        super(exportador);
    }

    @Override
    protected String getTitulo() {
        return "Relatorio de Vendas";
    }

    @Override
    protected List<String> getDados() {
        return List.of(
                "Pedido #1042 - Notebook Gamer - R$ 4.899,00",
                "Pedido #1043 - Monitor 27pol - R$ 1.199,00",
                "Pedido #1044 - Teclado Mecanico - R$ 349,00"
        );
    }
}
