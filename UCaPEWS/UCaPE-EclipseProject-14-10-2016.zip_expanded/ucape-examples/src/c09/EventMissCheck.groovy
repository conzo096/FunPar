package c09

import org.jcsp.lang.*
import org.jcsp.groovy.*

class EventMissCheck implements CSProcess
{
	def ChannelInput inChannel
	def ChannelOutput outChannel
	
	
	public void run()
	{
		while (true)
		{
			// Read in next event. 
			EventData e = inChannel.read();
			// Check number of misses match.
			if(e.data == (e.previousNum + 1))
			{
				println "Misses is accurate."
			}
			else
			{
				println "Misses does not add up."
			}
			
			// Output e.
			outChannel.write(e);
			
		}
			
	} 

}
 