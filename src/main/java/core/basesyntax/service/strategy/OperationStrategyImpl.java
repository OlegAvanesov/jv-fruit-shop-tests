package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationHandler;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getOperationType(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction can't be null");
        }
        return handlersMap.get(fruitTransaction.getOperation());
    }
}
