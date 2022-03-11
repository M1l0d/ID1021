import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Milad\\Documents\\KTH\\Algoritmer & Datastrukturer\\Labbar\\Labb 4\\graphString.txt");

        String s = " ";
        SymbolGraph symbolGraph = new SymbolGraph(file,s);
        Graph graph = symbolGraph.graph();

//        System.out.println(graph.toString());

        Scanner input = new Scanner(System.in);

        while(true) {

            System.out.println("Type source vertex: ");
            String sourceVertex = input.next();

            if (!symbolGraph.contains(sourceVertex))
            {
                throw new IllegalArgumentException("Graph does not contain given source vertex");
            }

            System.out.println("Type target vertex: ");
            String targetVertex = input.next();

            if (!symbolGraph.contains(targetVertex))
            {
                throw new IllegalArgumentException("Graph does not contain given target vertex");
            }

            BreadthFirstPaths bfs = new BreadthFirstPaths(graph, symbolGraph.indexOf(sourceVertex));

            if (bfs.hasPathTo(symbolGraph.indexOf(targetVertex))) {
                System.out.println("There is a path from the source vertex: " + sourceVertex + " to the target vertex: " + targetVertex);

                for (int x : bfs.pathTo(symbolGraph.indexOf(targetVertex))) {
                    if (x == symbolGraph.indexOf(sourceVertex)) {
                        System.out.print(symbolGraph.nameOf(x));
                    } else {
                        System.out.print("-" + symbolGraph.nameOf(x));
                    }
                }
                System.out.println();

            }
        }
    }
}
