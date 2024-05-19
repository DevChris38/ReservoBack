import com.reservo.reservoback.ReservoBackApplication;
import com.reservo.reservoback.model.Customer;
import com.reservo.reservoback.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ReservoBackApplication.class)
@Transactional
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        Customer user1 = new Customer("Vincent", "jétorisque", "0606060606", "vincent@alesia.com", "NikLéRom1");
        Customer user2 = new Customer("Gabrielle", "gay", "0634360498", "gabrielle.gay1991@gmail.com", "Eti6h8zc");
        //save user, verify has ID value after save
        assertNull(user1.getId());
        assertNull(user2.getId());//null before save
        this.customerRepository.save(user1);
        this.customerRepository.save(user2);
        assertNotNull(user1.getId());
        assertNotNull(user2.getId());
    }

    @Test
    public void testFetchData() {
        /*Test data retrieval*/
        Customer customerA = customerRepository.findByLastName("jétorisque");
        assertNotNull(customerA);
        assertEquals("Vincent", customerA.getFirstName());
    }
}