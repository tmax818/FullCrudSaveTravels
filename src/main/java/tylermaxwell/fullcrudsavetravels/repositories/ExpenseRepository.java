package tylermaxwell.fullcrudsavetravels.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.fullcrudsavetravels.models.Expense;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll();
}
