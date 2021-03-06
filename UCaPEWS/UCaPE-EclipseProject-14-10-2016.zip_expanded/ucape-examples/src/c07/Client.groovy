package c07

// copyright 2012-13 Jon Kerridge
// Let's Do It In Parallel

import org.jcsp.lang.*
import org.jcsp.groovy.*


class Client implements CSProcess{  
	
  def ChannelInput receiveChannel
  def ChannelOutput requestChannel
  def clientNumber   
  def selectList = [ ] 
  def returnList = [ ]
  void run () {
    def iterations = selectList.size
    println "Client $clientNumber has $iterations values in $selectList"
	
    for ( i in 0 ..< iterations) {
      def key = selectList[i]
      requestChannel.write(key)
      def v = receiveChannel.read()
	  returnList[i] = v
	  
	  // Check if value returned is 10*key value.
	  if(key*10 == v)
		  println "Client ${clientNumber} | Search:${i} key ${key} does return the correct value ${v} (Pass) "
	  else
		  println "Client ${clientNumber} | Search:${i} key ${key} does not return the correct value ${v} (Fail)"
    }
	println "\nClient $clientNumber has finished \nKey Ordered: ${selectList} \nKey Return: ${returnList}"
	

  }
}
