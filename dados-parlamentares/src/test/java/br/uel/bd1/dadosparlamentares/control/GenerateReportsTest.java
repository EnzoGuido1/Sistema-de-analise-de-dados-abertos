package br.uel.bd1.dadosparlamentares.control;

import br.uel.bd1.dadosparlamentares.util.GenerateReports;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GenerateReportsTest {
    @Test
    public void testGenerateReports() throws IOException {
        GenerateReports g = new GenerateReports();
        g.callScript();
    }
}
