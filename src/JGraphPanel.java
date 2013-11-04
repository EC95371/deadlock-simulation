import java.awt.geom.Rectangle2D;
import javax.swing.*;

import org.jgraph.*;
import org.jgraph.graph.*;

import org.jgrapht.*;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.ext.*;
//import org.jgrapht.graph.*;
import org.jgrapht.graph.ListenableDirectedGraph;

// resolve ambiguity
import org.jgrapht.graph.DefaultEdge;

/**
 * TODO:
 * 1. anchor jgraph to the sides of JGraphPanel so that resizing panel will resize jgraph. (ANISH)
 * 2. set up getters/setters 
 * @author Gabriel Shaw
 */


public class JGraphPanel extends JPanel {
    
    //variables 
    private final JGraphModelAdapter<String, DefaultEdge> jgAdapter;
    private JGraph jgraph;
    private ListenableDirectedGraph<String, DefaultEdge> graph;
    
    public JGraphPanel() {
        // create a JGraphT graph
        graph = new ListenableDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        // create a visualization using JGraph, via an adapter
        jgAdapter = new JGraphModelAdapter<String, DefaultEdge>(graph);
        jgraph = new JGraph(jgAdapter);

        
        this.add(jgraph);

//        String v1 = "v1";
//        String v2 = "v2";
//        String v3 = "v3";
//        String v4 = "v4";
//
//        // add some sample data (graph manipulated via JGraphT)
//        graph.addVertex(v1);
//        graph.addVertex(v2);
//        graph.addVertex(v3);
//        graph.addVertex(v4);
//
//        graph.addEdge(v1, v2);
//        graph.addEdge(v2, v3);
//        graph.addEdge(v3, v1);
//        graph.addEdge(v4, v3);
//
//        // position vertices nicely within JGraph component
//        positionVertexAt(v1, 130, 40);
//        positionVertexAt(v2, 60, 200);
//        positionVertexAt(v3, 310, 230);
//        positionVertexAt(v4, 380, 70);
    }
    public void addVertex(String vertex)
    {
        graph.addVertex(vertex);
    }
    public void addEdge(String v1, String v2)
    {
        graph.addEdge(v1, v2);
    }
    public boolean detectCycles()
    {
        CycleDetector cycleDetector = new CycleDetector(graph);
        return cycleDetector.detectCycles();
    }
    public void highlightCycleNodes()
    {
        
    }
    
    
    private void positionVertexAt(Object vertex, int x, int y)
    {
        DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
        Rectangle2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
                bounds.getWidth(),
                bounds.getHeight());

        GraphConstants.setBounds(attr, newBounds);

        // TODO: Clean up generics once JGraph goes generic 
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
        jgAdapter.edit(cellAttr, null, null, null);
    }
    
//    public static void main(String [] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                //Create and set up the window.
//                JFrame frame = new JFrame("HelloWorldSwing");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                
//                JGraphPanel jgPanel = new JGraphPanel();
//                frame.getContentPane().add(jgPanel);
//                
//                try {
//                    // Set System L&F
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } 
//                catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//                   // handle exception
//                }
//
//                //Display the window.
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//    }
}
