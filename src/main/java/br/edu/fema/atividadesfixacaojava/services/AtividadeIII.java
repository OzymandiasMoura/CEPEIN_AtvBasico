package br.edu.fema.atividadesfixacaojava.services;


import java.time.LocalDate;
import java.util.List;

public interface AtividadeIII
{
    List<String> returnNomeAluno();

    List<LocalDate> returnNascimentoAluno();

    List<Integer> returnIdadeAluno();
}
