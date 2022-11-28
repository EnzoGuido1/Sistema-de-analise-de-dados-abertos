package br.uel.bd1.dadosparlamentares.util;
import br.uel.bd1.dadosparlamentares.business.GenericBusiness;
import br.uel.bd1.dadosparlamentares.dao.relatorios.RelatoriosDAO;
import br.uel.bd1.dadosparlamentares.factory.DAOFactory;
import br.uel.bd1.dadosparlamentares.model.dto.FornecedoresMaisContratadosDTO;
import br.uel.bd1.dadosparlamentares.model.dto.GastoAnualPorPoliticoDTO;
import br.uel.bd1.dadosparlamentares.model.dto.NumPoliticosPorPartidoDTO;
import br.uel.bd1.dadosparlamentares.model.dto.NumProposicoesPorPoliticoDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

@Named
@RequestScoped
public class GenerateReports {

    private static String s;
    private final String script = "reportScript/report_script.py",
                         graph = "images/graph";

    public String callScript() throws IOException {
        String [] cmd = new String[20];
        List<NumPoliticosPorPartidoDTO> numPoliticosPorPartido;
        List<NumProposicoesPorPoliticoDTO> numProposicoesPorPolitico;
        List<FornecedoresMaisContratadosDTO> fornecedoresMaisContratados;
        List<GastoAnualPorPoliticoDTO> gastoAnualPorPolitico;
        RelatoriosDAO dao;
        try {
            dao = DAOFactory.getInstance().getRelatoriosDAO();
            numPoliticosPorPartido = dao.getNumPoliticosPorPartido(10);
            numProposicoesPorPolitico = dao.getNumProposicoesPorPolitico(10);
            fornecedoresMaisContratados = dao.getFornecedoresMaisContratados(10);
            gastoAnualPorPolitico = dao.getGastoAnualPorPolitico(10);
        }
        catch(ClassNotFoundException | SQLException | IOException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }

        cmd[0] = "python";
        cmd[1] = this.getClass().getClassLoader().getResource(script).getPath();
        cmd[2] = "1 2 3 4 5";           // eixo y
        cmd[3] = "1 2 3 4 5";           // eixo x
        cmd[4] = "Bar Graph 1";         // nome do gráfico
        cmd[5] = "X";                   // nome do eixo x
        cmd[6] = "Y";                   // nome do eixo y
        cmd[7] = this.getClass().getClassLoader().getResource(graph + "1.png").getPath();
        cmd[8] = "1 2 3 4 5";           // eixo y
        cmd[9] = "5 4 3 2 1";           // eixo x
        cmd[10] = "Bar Graph 2";        // nome do gráfico
        cmd[11] = "X";                  // nome do eixo x
        cmd[12] = "Y";                  // nome do eixo y
        cmd[13] = this.getClass().getClassLoader().getResource(graph + "2.png").getPath();
        cmd[14] = "";
        for(var n : numPoliticosPorPartido) {
            cmd[14] += n.getNum_politicos().intValue() + " ";
        }
        cmd[15] = "Numero de Políticos por Partido";        // nome do gráfico
        cmd[16] = this.getClass().getClassLoader().getResource(graph + "1.png").getPath();
        cmd[17] = "4 3 2 1";            // valores gerais (pizza)
        cmd[18] = "Pie Chart 2";        // nome do gráfico
        cmd[19] = this.getClass().getClassLoader().getResource(graph + "4.png").getPath();

        Runtime r = Runtime.getRuntime();
        Process p = r.exec(cmd);

        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while((s=in.readLine()) != null){
            System.out.println(s);
        }

        return "relatorios";
    }
}
