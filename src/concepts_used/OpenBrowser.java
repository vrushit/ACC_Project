package concepts_used;

import java.awt.Desktop;
import java.io.IOException;
import java.net.*;

public class OpenBrowser {
	
	public void openInBrowser(String urlLink) throws IOException, URISyntaxException
	{
		Desktop desk = Desktop.getDesktop();
		desk.browse(new URI(urlLink));
	}


}
