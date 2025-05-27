package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;
import br.edu.fema.atividadesfixacaojava.services.classesUteis.ConvercaoDataString;
import java.time.LocalDate;
import java.util.*;

import static br.edu.fema.atividadesfixacaojava.enums.Periodo.MATUTINO;


public class AtividadeIVImpl implements AtividadeIV
{
    private AlunoRepository alunoRepository = new AlunoRepository();

    public List<Aluno> alunosPos2001(List<Aluno> alunos)
    {
        LocalDate filterData = LocalDate.of(2001, 02, 15);

        ConvercaoDataString dtst = new ConvercaoDataString();

        List<Aluno> alunosPos2001 = new ArrayList<>();

        for(Aluno aluno : alunos){
            if (dtst.stringParaData(aluno.getDataNascimento()).isAfter(filterData)){
                alunosPos2001.add(aluno);
            }
        }

        return alunosPos2001;
    }

    public Set<Aluno> alunosCad18(List<Aluno> alunos)
    {
        Set<Aluno> alunosCad18 = new HashSet<>();

        for(Aluno aluno : alunos){
            var horaCad = aluno.getDataHoraCadastro().getHour();

            if(horaCad > 18){
                alunosCad18.add(aluno);
            }
        }
        return alunosCad18;
    }

    public List<Aluno> alunosSemCurso(List<Aluno> alunos)
    {
        List<Aluno> alunosSemCurso = alunos.stream().filter(aluno -> aluno.getCurso() == null).toList();

        return alunosSemCurso;
    }

    public List<Aluno> alunosComCurso(List<Aluno> alunos){

        List<Aluno> alunosComCurso =  alunos.stream().filter(aluno -> !(aluno.getCurso() == null)).toList();

        return alunosComCurso;
    }

    public Collection<Aluno> alunosMatutino30(List<Aluno> alunos){

        var alunosComCurso = alunosComCurso(alunos);

        ConvercaoDataString dtst = new ConvercaoDataString();

        Collection<Aluno> alunosMatutino30 = alunosComCurso.stream()
                  .filter(a -> a.getCurso().getPeriodo().equals(MATUTINO))
                  .filter(a -> (LocalDate.now().getYear() - (dtst.stringParaData(a.getDataNascimento()).getYear())) >= 30)
                  .toList();

        return alunosMatutino30;
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

    public Collection<Aluno> encontrarAlunos(int dia, int mes, List<Aluno> alunos) {

        var alunosMesDia = alunos.stream()
                  .filter(a -> a.getDataHoraCadastro().getMonthValue() == mes && a.getDataHoraCadastro().getDayOfMonth() == dia).toList();

        return alunosMesDia;
    }
}
