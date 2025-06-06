package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utilities.ConvercaoDataString;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade3 implements Atividade
{
    public List<String> returnNomeAluno(List<Aluno> alunos)
    {
        return alunos.stream().map(a -> a.getNomeCompleto()).collect(Collectors.toList());
    }

    public List<LocalDate> returnNascimentoAluno(List<Aluno> alunos)
    {


        return alunos.stream()
                  .map(a -> a.getDataNascimento())
                  .map(a -> ConvercaoDataString.stringParaData(a))
                  .collect(Collectors.toList());
    }


    public List<Integer> returnIdadeAluno(List<Aluno> alunos)
    {
        var nasc = returnNascimentoAluno(alunos);

        return nasc.stream()
                  .map(a -> LocalDate.now().getYear() - a.getYear())
                  .collect(Collectors.toList());
    }

    @Override
    public void executar()
    {
        AlunoRepository alunoRepository = new AlunoRepository();
        var alunos = alunoRepository.findAll();
        //Nomes
        System.out.println("Nome dos alunos: ");
        var nomes = returnNomeAluno(alunos);
        nomes.forEach(System.out::println);

        //Data Nascimento
        System.out.println("Data de nascimento dos alunos: ");
        var data = returnNascimentoAluno(alunos);
        data.forEach(System.out::println);

        //Idade
        System.out.println("Idade dos alunos: ");
        var idades = returnIdadeAluno(alunos);
        idades.forEach(System.out::println);
    }
}
