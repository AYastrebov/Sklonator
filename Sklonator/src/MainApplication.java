import javax.swing.UIManager;


public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
		catch (Exception e) 
		{
	    }
		
		new SklonatorFrame();
	}

}
