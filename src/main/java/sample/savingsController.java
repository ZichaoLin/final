package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"custno","custname","cdep","nyears","savtype","errMsg","ans"})
@Controller
public class savingsController {
    DatabaseService service1;
    @Autowired
    savingstableService service;



    @Autowired
    Connection connect;


    @RequestMapping(value = "/savingstable", method = RequestMethod.GET)
    public String showSavingstablepage(ModelMap model, @RequestParam(defaultValue = "") String custno) throws ClassNotFoundException, SQLException {


        service1 = new DatabaseService(connect.connect());

        model.addAttribute("todos", service1.display());


        List<savingstable> filteredTodos = new ArrayList<savingstable>();

        filteredTodos = (List) model.get("todos");

        model.put("custno",filteredTodos.get(0).getCustno());
        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCustname());
        model.put("nyears",filteredTodos.get(0).getCustname());
        model.put("savtype",filteredTodos.get(0).getCustname());




        return "savingstable";


    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSavingstablePage2(ModelMap model) throws ClassNotFoundException, SQLException {

        service1 = new DatabaseService(connect.connect());



        model.addAttribute("todos", service1.display());


        List<savingstable> filteredTodos = new ArrayList<savingstable>();

        filteredTodos = (List) model.get("todos");
        model.put("custno",filteredTodos.get(0).getCustno());
        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCustname());
        model.put("nyears",filteredTodos.get(0).getCustname());
        model.put("savtype",filteredTodos.get(0).getCustname());



        return "savingstable";


    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "catser";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String custno, @RequestParam String custname, @RequestParam double cdep, @RequestParam int nyears, @RequestParam String savtype) throws SQLException, ClassNotFoundException {




        if (!((service1.search(custno)) ==null)){

            model.put("errorMessage","Record Existing");
            return "savingstable";

        }


        savingstable cc = new savingstable(custno,custname,cdep,nyears,savtype);

        service1.add(cc);

        model.clear();
        return "savingstable";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String custno) throws SQLException, ClassNotFoundException {

        model.put("custno", custno);


        savingstable cc =  service1.search(custno);


        model.put("custno",cc.getCustno());
        model.put("custname",cc.getCustname());
        model.put("cdep",cc.getCdep());
        model.put("nyears",cc.getNyears());
        model.put("savtype",cc.getSavtype());



        return "savingstable2";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam String custno, @RequestParam String custname, @RequestParam double cdep, @RequestParam int nyears, @RequestParam String savtype) throws SQLException, ClassNotFoundException {


        String iid = (String) model.get("custno");

        savingstable cc = new savingstable(custno,custname,cdep,nyears,savtype);

        service1.edit(cc,iid);

        return "redirect:/";

    }



    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String custno) throws SQLException, ClassNotFoundException {


        service1.delete(custno);


        model.clear();
        return "redirect:/";
    }


    @RequestMapping(value ="/see-todo", method = RequestMethod.GET)
    public String seetodo(ModelMap model,  @RequestParam(defaultValue = "") String custno) throws SQLException, ClassNotFoundException {

        model.put("custno", custno);

        service1 = new DatabaseService(connect.connect());

        String iid = (String) model.get("custno");

        List<Items> Itemlist = new ArrayList<>();

        Itemlist = service1.display2(iid);


        if(Itemlist.size()==0){

            model.put("errorMessage","There are not items for this savingstable ");
            return "redirect:/";
        } else {
            model.put("errorMessage"," ");
        }

        model.put("custname",iid);

        System.out.println(iid);
        model.addAttribute("todos1", service1.display2(iid));



        return "items";
    }


    @RequestMapping(value ="/see-todo", method = RequestMethod.POST)
    public String seetodo2(ModelMap model) throws SQLException, ClassNotFoundException {


        return "redirect:/";
    }

}
