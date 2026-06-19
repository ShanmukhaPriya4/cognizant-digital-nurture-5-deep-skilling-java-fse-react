// Repository Interface
interface CustomerRepository {

    String findCustomerById(int id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        return "Customer ID: " + id + ", Name: Shan";
    }
}

// Service Class
class CustomerService {

    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomer(int id) {
        System.out.println(repository.findCustomerById(id));
    }
}

// Main Class
public class DependencyInjectionExample {

    public static void main(String[] args) {

        // Inject dependency using constructor
        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        // Find Customer
        service.getCustomer(101);
    }
}