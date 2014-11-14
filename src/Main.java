import gui.MainFrame;

import javax.swing.SwingUtilities;


public class Main 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{	
				// there we will begin create our program
				new MainFrame();
			}	 
		 });
	}

}
