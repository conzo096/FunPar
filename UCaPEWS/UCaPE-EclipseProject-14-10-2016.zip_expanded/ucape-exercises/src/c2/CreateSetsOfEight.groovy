package c2

import org.jcsp.lang.*

class CreateSetsOfEight implements CSProcess{
	
	def ChannelInput inChannel
	def actual = []
	def int setSize = 8
	void run(){
		def outList = []
		def v = inChannel.read()
		while (v != -1){
			outList = []
			for ( i in 0 .. setSize-1 ) {
				// put v into outList and read next input
				outList[i] = v
				v = inChannel.read()
			}
			println " Eight Object is ${outList}"
			actual = actual << outList // outList
		}
		println "Finished"
	}
}