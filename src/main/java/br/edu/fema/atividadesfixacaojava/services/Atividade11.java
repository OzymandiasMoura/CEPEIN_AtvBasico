package br.edu.fema.atividadesfixacaojava.services;

import java.util.HashMap;
import java.util.Map;

public class Atividade11 implements Atividade
{
    public Map<Integer, String> createMap(){
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Pedro");
        map.put(2, "João");
        map.put(3, "Marcela");
        map.put(4, "Daniela");
        map.put(5, "Marcos");
        map.put(6, "Marcia");
        map.put(7, "Franscisco");
        map.put(8, "Rafaela");

        return map;
    }
    @Override
    public void executar()
    {
        System.out.println("\n\nExecutando atividade com funcional: ");
        var map = createMap();
        map.forEach((key, value) -> System.out.println(key + " - " + value));

        System.out.println("\n\nExecutando atividade sem funcional: ");
        var map2 = createMap();
        for(Map.Entry<Integer, String> entry : map2.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
