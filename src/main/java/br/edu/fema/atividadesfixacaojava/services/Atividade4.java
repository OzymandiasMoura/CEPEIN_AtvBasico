package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.utilities.ConvercaoDataString;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static br.edu.fema.atividadesfixacaojava.enums.Periodo.MATUTINO;


public class Atividade4 implements Atividade
{
    private AlunoRepository alunoRepository = new AlunoRepository();

    public List<Aluno> alunosPos2001(List<Aluno> alunos)
    {
        final LocalDate filterData = LocalDate.of(2001, 02, 15);
        ConvercaoDataString conversor = new ConvercaoDataString();

        return alunos.stream().filter(a -> ConvercaoDataString.stringParaData(a.getDataNascimento()).isAfter(filterData)).collect(Collectors.toList());
    }

    public Set<Aluno> alunosCad18(List<Aluno> alunos)
    {
        return alunos.stream().filter(a -> a.getDataHoraCadastro().getHour() > 18).collect(Collectors.toSet());
    }

    public List<Aluno> alunosSemCurso(List<Aluno> alunos)
    {
        return alunos.stream().filter(aluno -> aluno.getCurso() == null).toList();
    }

    public List<Aluno> alunosComCurso(List<Aluno> alunos)
    {
        return alunos.stream().filter(aluno -> !(aluno.getCurso() == null)).toList();
    }

    public Collection<Aluno> alunosMatutino30(List<Aluno> alunos)
    {
        var alunosComCurso = alunosComCurso(alunos);

        return alunosComCurso.stream()
                  .filter(a -> a.getCurso().getPeriodo().equals(MATUTINO))
                  .filter(a -> (LocalDate.now().getYear() - (ConvercaoDataString.stringParaData(a.getDataNascimento()).getYear())) >= 30)
                  .toList();
    }

    public Aluno primeiroDe2021(List<Aluno> alunos){

        var alunosI= alunos.stream().filter(a -> a.getDataHoraCadastro().getYear() == 2021).toList();

        Aluno primeiroAluno = alunosI.get(0);
        for(Aluno aluno : alunosI){
            if(aluno.getDataHoraCadastro().isBefore(primeiroAluno.getDataHoraCadastro())){

                primeiroAluno = aluno;
            }
        }
        return primeiroAluno;
    }

    public Collection<Aluno> encontrarAlunos(int dia, int mes, List<Aluno> alunos)
    {
        return alunos.stream()
                  .filter(a -> a.getDataHoraCadastro().getMonthValue() == mes && a.getDataHoraCadastro().getDayOfMonth() == dia).toList();
    }

    @Override
    public void executar()
    {
        AlunoRepository alunoRepository = new AlunoRepository();
        var alunos = alunoRepository.findAll();

        System.out.println("\nAlunos nascidos após 2001.\n");
        var alunos2001 = alunosPos2001(alunos);
        alunos2001.forEach(System.out::println);

        System.out.println("\nAlunos cadastrados após 18h.\n");
        var alunos18H = alunosCad18(alunos);
        alunos18H.forEach(System.out::println);

        System.out.println("\nAlunos sem curso.\n");
        var alunosSemCurso = alunosSemCurso(alunos);
        alunosSemCurso.forEach(System.out::println);

        System.out.println("\nAlunos com curso.\n");
        var alunosComCurso = alunosComCurso(alunos);
        alunosComCurso.forEach(System.out::println);

        System.out.println("\nAlunos com curso matutino e com mais de 30 anos.\n");
        var alunosMatutino30 = alunosMatutino30(alunos);
        alunosMatutino30.forEach(System.out::println);

        System.out.println("\nPrimeiro aluno de 2021.\n");
        var aluno = primeiroDe2021(alunos);
        System.out.println(aluno);

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o mes:");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.println("Digite o dia:");
        int dia = Integer.parseInt(sc.nextLine());

        var alunoI = encontrarAlunos(dia, mes, alunos);

        System.out.println("Alunos encontrados: " + alunoI.size());
        alunoI.forEach(System.out::println);
    }
}
