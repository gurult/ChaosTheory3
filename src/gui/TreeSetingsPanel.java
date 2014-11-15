package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import utils.BranchParams;
import utils.BranchParamsListener;

@SuppressWarnings("serial")
public class TreeSetingsPanel extends JPanel {
	
	private static final String FORMAT = "0.00";
	private static final String FORMAT1 = "000";
	
	private BranchParamsListener bpl;
	
	//Pagrindiniai label
	
	JLabel firstTreeConfigLabel = new JLabel("Pirmos ðakos nustatymai :");
	JLabel secondTreeConfigLabel  = new JLabel("Antros ðakos nustatymai :");
	JLabel thirdTreeConfigLabel  = new JLabel("Treèios ðakos nustatymai : ");
	JLabel fourthTreeConfigLabel  = new JLabel("Ketvirtos ðakos nustatymai : ");
	
	
	//Spinners
	JLabel firstBranchResize = new JLabel("Maþinimas : ");
	JLabel secondBranchResize = new JLabel("Maþinimas : ");
	JLabel thirdBranchResize = new JLabel("Maþinimas : ");
	JLabel fourthBranchResize = new JLabel("Maþinimas : ");
	
	JSpinner firstSpinner;
	JSpinner secondSpinner;
	JSpinner thirdSpinner;
	JSpinner fourthSpinner;
	
	// 4 label ir 4 textfield
	
	JLabel angle1Label = new JLabel("Posukis : ");
	JLabel angle2Label = new JLabel("Posukis : ");
	JLabel angle3Label = new JLabel("Posukis : ");
	JLabel angle4Label = new JLabel("Posukis : ");
	
	JSpinner firstSpinnerDeg;
	JSpinner secondSpinnerDeg;
	JSpinner thirdSpinnerDeg;
	JSpinner fourthSpinnerDeg;
	
	// button
	
	JLabel createTreeLabel = new JLabel("sukurti medi");
	JButton createTreeButton = new JButton("Create");
	
	public TreeSetingsPanel() {
		setVisible(true);
		initSpiners();
		initLayout();
		
		createTreeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				BranchParams[] bp = new BranchParams[4];
				
				bp[0] = new BranchParams((int)firstSpinnerDeg.getValue(),
										(Double)firstSpinner.getValue());
				
				bp[1] = new BranchParams((int)secondSpinnerDeg.getValue(),
						(Double)secondSpinner.getValue());
				
				bp[2] = new BranchParams((int)thirdSpinnerDeg.getValue(),
						(Double)thirdSpinner.getValue());
				
				bp[3] = new BranchParams((int)fourthSpinnerDeg.getValue(),
						(Double)fourthSpinner.getValue());
				
						bpl.printInfo(bp[0]);
						bpl.printInfo(bp[1]);
						bpl.printInfo(bp[2]);
						bpl.printInfo(bp[3]);
				
			}});
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// inicilizavome konstantas
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 0;

		// pirmos ðakos parametrai
		
		add(firstTreeConfigLabel, c);
		
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0;
		c.weighty = 0;
		

		add(firstBranchResize, c);
		
		c.gridx++;
		c.weightx = 0;
		c.weighty = 0;

		add(firstSpinner, c);
		
		c.gridx = 0;
		c.gridy++;
		add(angle1Label, c);
		
		c.gridx++;
		add(firstSpinnerDeg, c);
		
		// 2 ðakos parametrai
		
		c.gridx = 0;
		c.gridy ++;
		
		add(secondTreeConfigLabel, c);
		
		c.gridx = 0;
		c.gridy ++;
		
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0;
		c.weighty = 0;
		

		add(secondBranchResize, c);
		
		c.gridx++;
		c.weightx = 0;
		c.weighty = 0;

		add(secondSpinner, c);
		
		c.gridx = 0;
		c.gridy++;
		add(angle2Label, c);
		
		c.gridx++;
		add(secondSpinnerDeg, c);
		
		
		// 3 ðakos parametrai
		
		c.gridx = 0;
		c.gridy ++;
		
		add(thirdTreeConfigLabel, c);
		
		c.gridx = 0;
		c.gridy ++;
		
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0;
		c.weighty = 0;
		

		add(thirdBranchResize, c);
		
		c.gridx++;
		c.weightx = 0;
		c.weighty = 0;

		add(thirdSpinner, c);
		
		c.gridx = 0;
		c.gridy++;
		add(angle3Label, c);
		
		c.gridx++;
		add(thirdSpinnerDeg, c);
		
		// 4 ðakos parametrai
		
		c.gridx = 0;
		c.gridy ++;
		
		add(fourthTreeConfigLabel, c);
		
		c.gridx = 0;
		c.gridy ++;
		
		c.gridx = 0;
		c.gridy++;
		c.weightx = 0;
		c.weighty = 0;
		

		add(fourthBranchResize, c);
		
		c.gridx++;
		c.weightx = 0;
		c.weighty = 0;

		add(fourthSpinner, c);
		
		c.gridx = 0;
		c.gridy++;
		add(angle4Label, c);
		
		c.gridx++;
		add(fourthSpinnerDeg, c);
		
		// add button
		
		c.gridx = 0;
		c.gridy ++;
		
		add(createTreeLabel, c);

		c.gridx++;
		add(createTreeButton, c);
	}
	
	private void initSpiners() {
				
		firstSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1, 0.01));
		secondSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1, 0.01));
		thirdSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1, 0.01));
		fourthSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1, 0.01));
		
		firstSpinner.setEditor(new JSpinner.NumberEditor(firstSpinner, FORMAT));
		secondSpinner.setEditor(new JSpinner.NumberEditor(secondSpinner, FORMAT));
		thirdSpinner.setEditor(new JSpinner.NumberEditor(thirdSpinner, FORMAT));
		fourthSpinner.setEditor(new JSpinner.NumberEditor(fourthSpinner, FORMAT));
		
		//-----------------------------------------
		firstSpinnerDeg = new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
		secondSpinnerDeg = new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
		thirdSpinnerDeg = new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
		fourthSpinnerDeg = new JSpinner(new SpinnerNumberModel(0, 0, 180, 1));
		
		firstSpinnerDeg.setEditor(new JSpinner.NumberEditor(firstSpinnerDeg, FORMAT1));
		secondSpinnerDeg.setEditor(new JSpinner.NumberEditor(secondSpinnerDeg, FORMAT1));
		thirdSpinnerDeg.setEditor(new JSpinner.NumberEditor(thirdSpinnerDeg, FORMAT1));
		fourthSpinnerDeg.setEditor(new JSpinner.NumberEditor(fourthSpinnerDeg, FORMAT1));
	}
	
	public void setBpl(BranchParamsListener bpl) {
		this.bpl = bpl;
	}
}
