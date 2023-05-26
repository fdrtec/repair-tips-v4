package com.api.repairtips.domain.service.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import lombok.Data;

@Data
public class SintaxeService {

    private Map<String, Integer> users;
    private List<String> names;
    
    public void startMap(){
        users = new HashMap<>();
        users.put("Fabiano", 1977);
        //put == conceito update em Map (demais collection add)
        users.put("Fabiano(dev)", 1977);
        users.put("Fernando(emp)", 1982);

        users.size();
        //Map não tem ordem
        users.keySet();
        users.values();
        users.entrySet();
        users.containsKey("Fabiano");
        users.containsValue(1982);
        users.get("Fernando");

        for(Entry<String,Integer> user: users.entrySet()){
            System.out.println(user.getKey());
            System.out.println(user.getValue());
        }

        users.remove("Fernando(emp)");

    }

    public void startList(){
        names = List.of("Fabiano", "Fernando");
        names.add("Andreia");
        names.size();
    }

    /*
     * toMany = (fetch = FetchType.Lazy)
     * toOne = (fetch = FetchType.Eager)
     * 
     * resolução do N+1
     * @Query("from Restaurante r join fetch r.cozinha left join fetch r.formasPagamento")
     * List<Restaurante> getAll()
     * o fetch para lazy funciona automatico só precisa o join(mas é bom para ficar bem definido o motivo),
     * mas para eager precisa colocar o fetch, e caso não tenha uma "forma de pagamento"
     * precisa usar left join 
     * 
    */
    
}
