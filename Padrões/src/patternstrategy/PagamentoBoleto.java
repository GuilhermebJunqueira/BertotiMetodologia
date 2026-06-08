package patternstrategy;

public class PagamentoBoleto {
    
}
package patternstrategy;

public class PagamentoBoleto implements PagamentoStrategy {

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via boleto.");
    }
}