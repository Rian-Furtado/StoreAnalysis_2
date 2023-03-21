package application;

import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o caminho do arquivo: ");
        String path = sc.nextLine();

        Map<String, Double> mapSet = new HashMap<>();
        List<Sale> saleList = new ArrayList<>();

        System.out.println();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

            String line = bf.readLine();

            while (line != null) {
                String[] text = line.split(",");
                saleList.add(new Sale(Integer.parseInt(text[0]),Integer.parseInt(text[1]),text[2],Integer.parseInt(text[3]),Double.parseDouble(text[4])));
                line = bf.readLine();
            }

            for (Sale sale :
                    saleList) {
              mapSet.put(sale.getSeller(), saleList.stream().filter(x -> x.getSeller().equals(sale.getSeller())).mapToDouble(Sale::getTotal).sum());
            }

            System.out.println("Total de vendas por vendendor: ");
            mapSet.forEach((name, totalValue) -> System.out.printf("%s - R$ %.2f\n", name, totalValue));




        } catch (IOException e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        }
    }
}
