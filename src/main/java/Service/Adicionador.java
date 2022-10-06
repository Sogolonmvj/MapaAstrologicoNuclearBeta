package Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.Set;

import static Service.MapaQuanticoAstrologicoLunarCosmico.escreverNaLista;
import static Service.MapaQuanticoAstrologicoLunarCosmico.lerALista;

public class Adicionador {

    private final static String HOME_DIR = System.getProperty("user.dir");

    public void adicionarIntegrantes() throws IOException {
        Scanner scan = new Scanner(System.in);
        String caminho = HOME_DIR.concat("/src/main/resources");

        final Path novoCaminho = Paths.get(caminho, "integrantes.txt");

        int integrantes = 0;

        String nome = "";

        while (integrantes <= 1) {
            System.out.println("Digite o seu nome: ");
            nome = scan.nextLine();

            System.out.println("Digite o dia do seu nascimento: ");
            String dia = scan.next();
            scan.nextLine();

            System.out.println("Digite o mês do seu nascimento: ");
            String mes = scan.next();
            scan.nextLine();

            System.out.println("Digite o ano do seu nascimento: ");
            String ano = scan.next();
            scan.nextLine();

            System.out.println("Digite o horário de nascimento: ");
            LocalTime horario = LocalTime.parse(scan.next());
            scan.nextLine();

            System.out.println("Digite o local de nascimento: ");
            String local = scan.next();
            scan.nextLine();

            Set<String> zones = ZoneId.getAvailableZoneIds();

            ZoneId zoneIdNascimento = ZoneId.of("America/Recife");

            for (String zone : zones) {
                if (zone.contains(local)) {
                    zoneIdNascimento = ZoneId.of(zone);
                }
            }

            String usuario = nome + "," + zoneIdNascimento + "," + dia + "-" + mes + "-" + ano + " " + horario;

            escreverNaLista(usuario + "\n", novoCaminho);
            integrantes++;
        }
        lerALista(novoCaminho);
    }

}
