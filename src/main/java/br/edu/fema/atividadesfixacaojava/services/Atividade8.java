package br.edu.fema.atividadesfixacaojava.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Atividade8 implements Atividade
{
    public BigDecimal somaIntegers(List<Integer> nums){
        BigDecimal soma = BigDecimal.valueOf(nums.stream().reduce((a, b) -> a + b).get());

        return soma;
    }

    public Optional<Double> soma2(List<Double> nums){
        return nums.stream().reduce((a, b) -> a + b);
    }

    public OptionalDouble soma3(List<Double> nums){
        int soma = 0;
        for(Double num : nums){
            soma += num;
        }
        return OptionalDouble.of(soma);
    }

    @Override
    public void executar()
    {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> nums2 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        System.out.println("\nSoma dos inteiros: " + somaIntegers(nums));
        System.out.println("\nSoma do Double com retorno Optional<Double>: " + soma2(nums2));
        System.out.println("\nSoma da lista Double com retorno OptionalDouble: " + soma3(nums2));
    }
}
