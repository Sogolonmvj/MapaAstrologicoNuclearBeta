package Service;

import Model.MapaQuantico;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MapaQuanticoAstrologicoLunarCosmico {

    private final static String HOME_DIR = System.getProperty("user.dir");

    public static void escreverNaLista(String info, Path caminho) throws IOException {
        if (!Files.exists(caminho)) {
            Files.createFile(caminho);
            Files.write(caminho, info.getBytes(StandardCharsets.UTF_8));
        } else {
            Files.write(caminho, info.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        }
    }

    public static void lerALista(Path caminho) throws IOException {
        File file = new File(String.valueOf(caminho));
        String[] values;
        Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                String currentLine = scanner.nextLine();
                values = currentLine.split(",");
                String nome = values[0];
                ZoneId zonaNascimento = ZoneId.of(values[1]);
                LocalDateTime dataHoraNascimento = LocalDateTime.parse(values[2], DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                MapaQuantico mapaQuantico = OperacaoesAstrologicas.criarMapaQuantico(nome, dataHoraNascimento, zonaNascimento);
                final Path caminhoFinal = Paths.get(HOME_DIR.concat("/src/main/resources"), nome + ".txt");
                escreverNaLista(mapaQuantico.toString(), caminhoFinal);
        }
    }

}
