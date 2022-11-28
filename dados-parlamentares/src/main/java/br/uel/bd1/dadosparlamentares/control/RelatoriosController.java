package br.uel.bd1.dadosparlamentares.control;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

@Named
@RequestScoped
public class RelatoriosController implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String imagePath = "images/";

    public StreamedContent getGrafico(int id) {
        InputStream image = this.getClass().getClassLoader()
                .getResourceAsStream(imagePath + "graph" + id + ".png");

        return DefaultStreamedContent.builder()
            .contentType("image/png")
            .stream(() -> image)
            .build();
    }
}
