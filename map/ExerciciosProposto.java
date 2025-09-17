package map;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ExerciciosProposto {
    public static void main(String[] args) {
        System.out.println("Crie um dicionário e relacione os estados e suas populações");
        Map<String, Estados> estadosBrasileiros = new HashMap<>(); {
            estadosBrasileiros.put("PE", new Estados("Pernambuco", 9616621));
            estadosBrasileiros.put("AL", new Estados("Alagoas", 3351543));
            estadosBrasileiros.put("CE", new Estados("Ceará", 9187103));
            estadosBrasileiros.put("RN", new Estados("Rio Grande do Norte", 3534265));
        };
        for(Map.Entry<String, Estados> estados : estadosBrasileiros.entrySet())
        System.out.println(estados.getKey() + " - " + estados.getValue().getNome() + " - " + estados.getValue().getPopulacao());

        System.out.println("\nSubstitua a população do estado do RN por 3534165");
        estadosBrasileiros.put("RN", new Estados("Rio Grande do Norte", 3534165));
        for(Map.Entry<String, Estados> estados : estadosBrasileiros.entrySet())
        System.out.println(estados.getKey() + " - " + estados.getValue().getNome() + " - " + estados.getValue().getPopulacao());

        System.out.println("\nConfira se o estado PB está no dicionário, caso não adiocione: PB - 4.039.277");
        System.out.println(estadosBrasileiros.containsKey("PB"));
        if (estadosBrasileiros.containsKey("PB") == false) {
            System.out.println("Adicionado o estado PB no dicionário");
            estadosBrasileiros.put("PB", new Estados("Paraiba", 4039277));
        }else {
            System.out.println("Estado já existente no dicionário");
        }
        for(Map.Entry<String, Estados> estados : estadosBrasileiros.entrySet())
            System.out.println(estados.getKey() + " - " + estados.getValue().getNome() + " - " + estados.getValue().getPopulacao());

        System.out.println("\nExiba a população  de PE");
        System.out.println(estadosBrasileiros.get("PE").getPopulacao());

        System.out.println("\nExiba todos os estados e suas populações na ordem que foi informado");
        Map<String, Estados> estadosBrasileiros1 = new LinkedHashMap<>(); {
            estadosBrasileiros1.put("PE", new Estados("Pernambuco", 9616621));
            estadosBrasileiros1.put("AL", new Estados("Alagoas", 3351543));
            estadosBrasileiros1.put("CE", new Estados("Ceará", 9187103));
            estadosBrasileiros1.put("RN", new Estados("Rio Grande do Norte", 3534265));
        };
        for(Map.Entry<String, Estados> estados : estadosBrasileiros1.entrySet())
        System.out.println(estados.getKey() + " - " + estados.getValue().getNome() + " - " + estados.getValue().getPopulacao());
    
        System.out.println("\nExiba os estados e suas populações em ordem alfabética");
        Set<Map.Entry<String, Estados>> estadosBrasileiros2 = new TreeSet<>(new EstadosEmOrdemAlfabetica());
        estadosBrasileiros2.addAll(estadosBrasileiros.entrySet());
        for(Map.Entry<String, Estados> estados : estadosBrasileiros2)
        System.out.println(estados.getKey() + " - " + estados.getValue().getNome() + " - " + estados.getValue().getPopulacao());

        System.out.println("\nExiba o estado com o menor população e sua quantidade");
        Map.Entry<String, Estados> menorPopulacao = Collections.min(
            estadosBrasileiros.entrySet(), Comparator.comparing(entry -> entry.getValue().getPopulacao())
        );
        System.out.println(menorPopulacao.getKey() + " - " + menorPopulacao.getValue().getNome() + " - " + menorPopulacao.getValue().getPopulacao());

        System.out.println("\nExiba o estado com o maior população e sua quantidade");
        Map.Entry<String, Estados> maiorPopulacao = Collections.max(
            estadosBrasileiros.entrySet(), Comparator.comparing(entry -> entry.getValue().getPopulacao())
        );
        System.out.println(maiorPopulacao.getKey() + " - " + maiorPopulacao.getValue().getNome() + " - " + maiorPopulacao.getValue().getPopulacao());

        System.out.println("\nExiba a soma da população desses estados");
        int soma = 0;
        for (Estados estado : estadosBrasileiros.values()) {
            soma += estado.getPopulacao();
        }
        System.out.println(soma);

        System.out.println("\nExiba a média da população desse dicionário de estados");
        System.out.println(soma / estadosBrasileiros.size());

        System.out.println("\nRemova os estados com a população menor que 4.000.000");
        Iterator<Estados> iterator1 = estadosBrasileiros.values().iterator();
        while (iterator1.hasNext()) {
            Estados estado = iterator1.next();
            if (estado.getPopulacao() < 4000000) iterator1.remove();
        }
        for(Map.Entry<String, Estados> estados : estadosBrasileiros.entrySet())
        System.out.println(estados.getKey() + " - " + estados.getValue().getNome() + " - " + estados.getValue().getPopulacao());

        System.out.println("\nApague o dicionário de estados");
        estadosBrasileiros.clear();
        System.out.println("Dicionário apagado");

        System.out.println("\nConfira se o dicionário está vazio");
        System.out.println(estadosBrasileiros.isEmpty());
    } 
}

class Estados {
    String nome;
    int populacao;
    
    public Estados(String nome, int populacao) {
        this.nome = nome;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    @Override
    public String toString() {
        return "Estados [estado=" + nome + ", populacao=" + populacao + "]";
    }
}

class EstadosEmOrdemAlfabetica implements Comparator<Map.Entry<String, Estados>> {
    public int compare(Map.Entry<String, Estados> e1, Map.Entry<String, Estados> e2) {
        return e1.getValue().getNome().compareToIgnoreCase(e2.getValue().getNome());
    }
}