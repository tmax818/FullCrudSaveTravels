package tylermaxwell.fullcrudsavetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tylermaxwell.fullcrudsavetravels.models.Expense;
import tylermaxwell.fullcrudsavetravels.services.ExpenseService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    ExpenseService service;

    // CREATE
    @GetMapping("/expenses/new")
    public String newExpense(@ModelAttribute("expense")Expense expense){
        return "/expenses/new.jsp";
    }


    @GetMapping("/expenses")
    public String index(@ModelAttribute("expense") Expense expense, Model model){
        List<Expense> expenses = service.allExpenses();
        model.addAttribute("expenses", expenses);
        return "/expenses/index.jsp";
    }

    // READ ALL
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Expense> expenses = service.allExpenses();
            model.addAttribute("expenses", expenses);
            return "/expenses/index.jsp";
        } else {
            service.createExpense(expense);
            return "redirect:/expenses";
        }
    }


    // READ ONE

    // UPDATE
    @RequestMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        Expense expense = service.findExpense(id);
        model.addAttribute("expense", expense);
        return "/expenses/edit.jsp";
    }

    @RequestMapping(value = "/expenses/{id}", method = RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result){
        if(result.hasErrors()){
            return "/expenses/edit.jsp";
        } else {
            service.updateExpense(expense);
            return "redirect:/expenses";
        }
    }

    // DELETE

    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id){
        service.deleteBook(id);
        return "redirect:/expenses";
    }


}
