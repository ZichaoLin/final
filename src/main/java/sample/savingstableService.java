package sample;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class savingstableService {
    private static List<savingstable> todos = new ArrayList<savingstable>();
    private static int todoCount = 5;

    static {
        todos.add(new savingstable("115", "Jasper Diaz",15000.0,5,"Savings-Deluxe"));
        todos.add(new savingstable("112", "Zanip Mendez",5000.0,2,"Savings-Deluxe"));
        todos.add(new savingstable("113", "Geronima Esper",6000.0,5,"Savings-Regular"));

    }

    public List<savingstable> retrieveTodos() {
        List<savingstable> filteredTodos = new ArrayList<savingstable>();
        for (savingstable todo : todos) {
            filteredTodos.add(todo);
        }
        return filteredTodos;    }


    public void addTodo(String custno, String custname, double cdep, int nyears, String savtype) {
        todos.add(new savingstable(custno, custname,cdep,nyears,savtype));
    }


    public void deleteTodo(String id) {

        for (int i = 0; i < todos.size(); i++) {

            if(id.equals(todos.get(i).getCustno())) {

                todos.remove(i);
                break;
            }


        }

    }

    public savingstable retrieve(String id){

        for(savingstable todo: todos){
            if(todo.getCustno().equals(id)){
                return todo;
            }
        }
        return null;

    }

    public void update(savingstable todo){
        todos.remove(todo);
        todos.add(todo);
    }


}
