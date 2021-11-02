package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askDetails(Model model) {

//        Employee emp = new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Petrov");
//        emp.setSalary(500);
//        model.addAttribute("employee", emp);
        model.addAttribute("employee", new Employee());

        return "ask-emp-details-view";
    }

    @RequestMapping("/showDetails")
    public String showDetails(@Valid @ModelAttribute("employee") Employee emp
            , BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details";
        }
    }

}

/*
@RequestMapping("/showDetails")
    public String showDetails(@RequestParam("employeeName") String empName,
                              Model model) {
        empName = "Mr. " +empName;
        model.addAttribute("nameAttribute", empName);

        return "show-emp-details";
    }
 */

/*
@RequestMapping("/showDetails")
    public String showDetails(@ModelAttribute("employee") Employee emp) {

        String name = emp.getName();
        emp.setName("Mr " + name);

        String surname = emp.getSurname();
        emp.setSurname(surname + "!");

        int salary = emp.getSalary();
        emp.setSalary(salary*10);

        return "show-emp-details";
    }
 */