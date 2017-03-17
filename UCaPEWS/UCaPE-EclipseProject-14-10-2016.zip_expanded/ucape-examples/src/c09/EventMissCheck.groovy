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
			
			if(e.data == (e.previousOutput + e.missed + 1))
			{
				println "Source ${e.source} Correct: Data: ${e.data} == prevOutput: ${e.previousOutput} + missed: ${e.missed} + 1)"
			}
			else
			{
				println "Source ${e.source} incorrect: Data: ${e.data} != prevOutput: ${e.previousOutput} + missed: ${e.missed} + 1) "
			}
			
			// Output e.
			outChannel.write(e);
			
		}
			
	} 

}
 