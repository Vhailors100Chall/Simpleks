import simplex.Equation;
import simplex.SimplexProblem;
import simplex.SimplexSolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("please give me a problem to solve!");
            return;
        }

        Path path = FileSystems.getDefault().getPath(args[0]);
        String contents = "Not Data";
        try {
            contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create new problem
        SimplexProblem p = new SimplexProblem();
        p.parse(contents);

        //solve problem
        SimplexSolver solver = new SimplexSolver();
        Double res = solver.solve(p);

        if(res == Double.NaN)
        {
            System.out.println("Problem has no solution!");
        }
        else
        {
            System.out.println("Problem solving finished!");
        }
    }
}
