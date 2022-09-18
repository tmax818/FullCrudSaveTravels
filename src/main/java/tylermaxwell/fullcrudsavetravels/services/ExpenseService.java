package tylermaxwell.fullcrudsavetravels.services;


import org.springframework.stereotype.Service;
import tylermaxwell.fullcrudsavetravels.models.Expense;
import tylermaxwell.fullcrudsavetravels.repositories.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo){this.repo = repo;}

    // CREATE: create an expense
    public Expense createExpense(Expense expense){return repo.save(expense);}

    // READ ALL: return all expenses:

    public List<Expense> allExpenses(){return repo.findAll();}

    // READ ONE: retrieve one expense
    public Expense findExpense(Long id){
        Optional<Expense> optionalExpense = repo.findById(id);
        return optionalExpense.orElse(null);
    }

    // UPDATE: edit one expense
    public Expense updateExpense(Expense expense){ return repo.save(expense);}

    public void deleteBook(Long id) { repo.deleteById(id); }
}
