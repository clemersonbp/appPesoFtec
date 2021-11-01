import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Atividade1 extends JFrame implements ActionListener{
	
	private JLabel lblAltura, lblSexo,lblResultado;
	private JTextField txtAltura;
	private JComboBox cboSexo;
	private JButton btnCalcular,btnLimpar,btnFechar;
	private GridBagConstraints restricoes=new GridBagConstraints();
	protected JPanel pnlCima,pnlBaixo,pnlResultado,pnlGeral;

	
	public Atividade1() {
		this.setTitle("Peso Ideal");
		this.setSize(380,180);
		this.setLocation(300, 80);
		this.setResizable(false);
		restricoes.fill=GridBagConstraints.BOTH;

		lblAltura = new JLabel("Altura:", JLabel.RIGHT);
		txtAltura = new JTextField(20);
		txtAltura.setToolTipText("Digite a altura");
		
		lblSexo = new JLabel("Sexo:", JLabel.RIGHT);
		cboSexo = new JComboBox();
		cboSexo.setToolTipText("Selecione o sexo");
		cboSexo.addItem("Masculino");
		cboSexo.addItem("Feminino");
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setMnemonic('C');
		btnCalcular.setToolTipText("Calcular o peso");
		btnCalcular.addActionListener(this);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setMnemonic('L');
		btnLimpar.setToolTipText("Limpar dados");
		btnLimpar.addActionListener(this);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setMnemonic('F');
		btnFechar.setToolTipText("Fecha a tela");
		btnFechar.addActionListener(this);
		
		lblResultado = new JLabel("Peso Ideal: ", JLabel.RIGHT);

		
		pnlCima = new JPanel(new GridBagLayout());
		restricoes.insets = new Insets(8,8,8,8);
		addGridBag(0,0,lblAltura,pnlCima);
		addGridBag(1,0,txtAltura,pnlCima);
		addGridBag(0,1,lblSexo,pnlCima);
		addGridBag(1,1,cboSexo,pnlCima);
		
		pnlBaixo = new JPanel(new GridBagLayout());
		addGridBag(0,0,btnLimpar,pnlBaixo);
		addGridBag(1,0,btnFechar,pnlBaixo);
		addGridBag(2,0,btnCalcular,pnlBaixo);
		addGridBag(1,1,lblResultado,pnlBaixo);
		
		pnlGeral = new JPanel(new GridBagLayout());
		addGridBag(0,0,pnlCima,pnlGeral);
		addGridBag(0,1,pnlBaixo,pnlGeral);
		
		Container P = getContentPane();
		P.add(pnlGeral);
		pack();

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object origem=event.getSource();
		
		if (origem == btnCalcular)
		{
			String textoDoCombo = cboSexo .getSelectedItem().toString();
			float altura=Float.parseFloat(txtAltura.getText().toString());
			float pesoIdeal =0;
			
			try 
			{
				if(textoDoCombo == "Masculino") {
					pesoIdeal = (float) (altura * 72.6 - 58);
					lblResultado.setText("Peso Ideal: " + pesoIdeal);
				}else {
					pesoIdeal = (float) (altura * 62.1 - 44.7);
					lblResultado.setText("Peso Ideal: " + pesoIdeal);
				}
			}catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"O valor é inválido!!!","Valor Inválido",JOptionPane.ERROR_MESSAGE);
                txtAltura.requestFocus();
            }
			
		}else if (origem == btnFechar)
		{
			dispose();
		}else if (origem == btnLimpar)
		{
			txtAltura.setText("");
    		lblResultado.setText("Peso Ideal:");
    		txtAltura.requestFocus();
		}			
	}
	
	public void addGridBag(final int x,final int y,final Component obj,final JPanel pnl)
	{
		restricoes.gridx=x;
		restricoes.gridy=y;
		pnl.add(obj,restricoes);
	}


	public static void main(String[] args) {
		Atividade1 atividade = new Atividade1();
		atividade.setVisible(true);
	}
}
