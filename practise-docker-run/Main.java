import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        String env = System.getenv("HCSP_ENV");

        if (env == null) {
            throw new IllegalStateException("HCSP_ENV environment variable not found!");
        }

        String fileContent = Files.readAllLines(new File("config.txt").toPath()).get(0).trim();

        String output = new String(Base64.getEncoder().encode((env + fileContent).getBytes()));

        System.out.println("答案是: " + output);
        System.out.println("The answer is: " + output);
        System.out.println("docker run cmd is docker run --env HCSP_ENV=DEF -it f65405c1e4ba sh -c \"echo 'ABC' > config.txt&&java Main\"");
    }
}
