
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class JGraphPanelWrapper extends JPanel {
    
    public JGraphPanelWrapper(JGraphPanel jgPanel) {
        super(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        this.add(jgPanel, c);
    }
    
}
