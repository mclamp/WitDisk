package witdisk;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
				
		Display display = new Display();          // Window
		Shell shell     = new Shell(display);     // Event loop
		
		shell.open();

		// run the event loop as long as the window is open
		while (!shell.isDisposed()) {
		    // read the next OS event queue and transfer it to a SWT event 
		  if (!display.readAndDispatch()) {
			 // if there are currently no other OS event to process
			 // sleep until the next OS event is available 
		    display.sleep();
		   }
		}

		// disposes all associated windows and their components
		display.dispose();
		
		
		// 
		File[] roots = File.listRoots();
	

		for(int i=0;i < roots.length;i++) {
		    		    
		    File file = roots[i];
		    Path path = file.toPath();
		    
		    long freeSpace  = file.getFreeSpace();
		    long totalSpace = file.getTotalSpace();
		    
		    System.out.println("Free Space " + freeSpace);
		    System.out.println("Total Space " + totalSpace);
		    
		    TestFileVisitor tfv = new TestFileVisitor();	
		    try {
				Files.walkFileTree(path,tfv);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
