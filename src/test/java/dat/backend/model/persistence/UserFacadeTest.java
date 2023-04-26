package dat.backend.model.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFacadeTest {

    @Test
    void watchSaldo() {
        int saldo = UserFacade.watchSaldo("User");
        System.out.println(saldo);
    }
}