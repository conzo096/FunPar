package c2

import org.jcsp.lang.*
import org.jcsp.groovy.*

class RunThreeToEight extends GroovyTestCase {
	
	void testLists()
	{
		def connect1 = Channel.one2one()
		def connect2 = Channel.one2one()	

		def genSet = new GenerateSetsOfThree ( outChannel: connect1.out())
		def list =  new ListToStream ( inChannel: connect1.in(),outChannel: connect2.out() )
		def createSet = new CreateSetsOfEight ( inChannel: connect2.in(), setSize: 8 )
		
		def processList = [ genSet,list,createSet]
		new PAR (processList).run()
		// Expected value only works for lists that are at a set size of 8.
	  	def expected = [[1, 2, 3, 4, 5, 6, 7, 8], [9, 10, 11, 12, 13, 14, 15, 16],
			  			[17, 18, 19, 20, 21, 22, 23, 24]]
		def actual = createSet.actual
		println " Actual : ${actual}"
		println " Expected : ${expected}"
		assertTrue(expected == actual)
	}
}