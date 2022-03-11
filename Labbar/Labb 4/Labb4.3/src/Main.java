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

            System.out.println("Type intermediate vertex: ");
            String intermediateVertex = input.next();

            if (!symbolGraph.contains(sourceVertex))
            {
                throw new IllegalArgumentException("Graph does not contain given intermediate vertex");
            }

            System.out.println("Type target vertex: ");
            String targetVertex = input.next();

            if (!symbolGraph.contains(targetVertex))
            {
                throw new IllegalArgumentException("Graph does not contain given target vertex");
            }

            BreadthFirstPaths ac = new BreadthFirstPaths(graph, symbolGraph.indexOf(sourceVertex));

            BreadthFirstPaths cb = new BreadthFirstPaths(graph, symbolGraph.indexOf(intermediateVertex));

            StringBuilder sb = new StringBuilder();

            if (ac.hasPathTo(symbolGraph.indexOf(intermediateVertex))) {

                for (int x : ac.pathTo(symbolGraph.indexOf(intermediateVertex))) {
                    if (x == symbolGraph.indexOf(sourceVertex)) {
                        sb.append(symbolGraph.nameOf(x));
                    } else {
                        sb.append("-").append(symbolGraph.nameOf(x));
                    }
                }
            }

            if (cb.hasPathTo(symbolGraph.indexOf(intermediateVertex))) {

                for (int x : cb.pathTo(symbolGraph.indexOf(targetVertex))) {
                    if (x != symbolGraph.indexOf(intermediateVertex)) {
                        sb.append("-").append(symbolGraph.nameOf(x));
                    }
                }
            }
            System.out.println(sb);
        }
    }
}

