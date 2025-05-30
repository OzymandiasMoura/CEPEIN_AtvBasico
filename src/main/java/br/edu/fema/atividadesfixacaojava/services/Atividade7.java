package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class Atividade7 implements Atividade
{
    public List<LocalDateTime> cadastrosOrdenados(List<Aluno> alunos){
        List<LocalDateTime> setOrdenada = alunos.stream()
                  .map(a -> a.getDataHoraCadastro())
                  .sorted(Comparator.comparing(LocalDateTime::toLocalDate).reversed().thenComparing(LocalDateTime::toLocalTime))
                  .toList();


        return setOrdenada;
    }

    @Override
    public void executar()
    {
        AlunoRepository alunoRepository = new AlunoRepository();
        var ord = cadastrosOrdenados(alunoRepository.findAll());
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ord.forEach(a -> System.out.println(a.format(formatacao)));




    }
}
