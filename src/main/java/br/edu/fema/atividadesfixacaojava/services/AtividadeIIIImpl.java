package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.*;

public class AtividadeIIIImpl implements AtividadeIII
{
    AlunoRepository alunoRepository = new AlunoRepository();
    private List<Aluno> listAlunos = alunoRepository.findAll();

    @Override
    public List<String> returnNomeAluno()
    {
        return listAlunos.stream().map(a -> a.getNomeCompleto()).collect(Collectors.toList());
    }

    @Override
    public List<LocalDate> returnNascimentoAluno()
    {
        List<LocalDate> nasc = new ArrayList<>();

        listAlunos.stream()
                  .map(a -> a.getDataNascimento())
                  .map(a -> a.trim().replace("/", " " ))
                  .map(a -> LocalDate.of(parseInt(a.substring(6)), parseInt(a.substring(3, 5)), parseInt(a.substring(0, 2))))
                  .forEach(nasc::add);

        return nasc;
    }


    public List<Integer> returnIdadeAluno()
    {
        var nasc = returnNascimentoAluno();
        List<Integer> listIdade = new ArrayList<>();
        nasc.stream()
                  .map(a -> LocalDate.now().getYear() - a.getYear())
                  .forEach(listIdade::add);
        return listIdade;
    }
}
