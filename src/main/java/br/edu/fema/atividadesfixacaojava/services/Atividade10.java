package br.edu.fema.atividadesfixacaojava.services;

import br.edu.fema.atividadesfixacaojava.enums.Periodo;
import br.edu.fema.atividadesfixacaojava.model.Aluno;
import br.edu.fema.atividadesfixacaojava.repository.AlunoRepository;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Atividade10 implements Atividade
{
    public Map<Boolean, Map<String, List<Aluno>>> alunosPorCursoBeneficio(List<Aluno> alunos)
    {
        //Aqui eu coloquei o curso nulo como parte do agrupamento.
        Map<Boolean, Map<String, List<Aluno>>> alunos2 = alunos.stream().collect(Collectors.groupingBy(Aluno::getPossuiAlgumTipoDeBeneficio,  Collectors.groupingBy(a -> (a.getCurso() != null) ? a.getCurso().getSigla() : "none")));

        return alunos2;
    }
    public Map<Boolean, Map<Periodo, Map<String, List<Aluno>>>> alunosPorCursoPeriodoBeneficio(List<Aluno> alunos){

        //Nesse aqui eu removi todos com curso nulo
        Map<Boolean, Map<Periodo, Map<String, List<Aluno>>>> alunos2 = alunos.stream().filter(a -> a.getCurso() != null).collect(Collectors.groupingBy(Aluno::getPossuiAlgumTipoDeBeneficio, Collectors.groupingBy(a -> a.getCurso().getPeriodo(), Collectors.groupingBy(a -> a.getCurso().getSigla()))));
        return alunos2;
    }
    @Override
    public void executar()
    {
        var mapOrg = alunosPorCursoBeneficio(AlunoRepository.findAll());
        System.out.println("Map organizado Beneficios/Curso: \n" + mapOrg);
        var mapOrg2 = alunosPorCursoPeriodoBeneficio(AlunoRepository.findAll());
        System.out.println("Map organizado Periodo/Beneficio/Curso: \n" + mapOrg2);

    }
}
