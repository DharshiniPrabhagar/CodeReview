import java.nio.file.*;  
Files.write(Paths.get("output.txt"), "Hello, World!\nLine 2\nLine 3".getBytes());
