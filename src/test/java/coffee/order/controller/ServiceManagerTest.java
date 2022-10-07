package coffee.order.controller;

import coffee.order.repository.TransactionRepository;
import coffee.order.view.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceManagerTest {
    private final ServiceManager serviceManager = new ServiceManager();

    @BeforeEach
    void initializeMenu() {
        serviceManager.initializeMenu();
    }

    @Test
    void createNewTransaction() {
        // given
        Order order = new Order(1, 2, 10);

        // when
        serviceManager.createNewTransaction(order);

        // then
        Assertions.assertThat(new TransactionRepository().getTransactionDatabase()).containsKey(1L);
    }
}