package c05;

import java.awt.BorderLayout
import java.awt.Container
import java.awt.GridLayout
import java.awt.Label
import org.jcsp.awt.ActiveButton
import org.jcsp.awt.ActiveClosingFrame
import org.jcsp.awt.ActiveLabel
import org.jcsp.awt.ActiveTextArea
import org.jcsp.awt.ActiveTextEnterField
import org.jcsp.groovy.PAR
import org.jcsp.lang.CSProcess
import org.jcsp.lang.ChannelInput
import org.jcsp.lang.ChannelOutput

class ControllerUI implements CSProcess
{
	  
  def ChannelInput factor
  def ChannelInput data
  def ChannelOutput suspend
  def ChannelOutput injector
  
  void run()
  {
	  	// Create window to contain all visual display.
	  	def initWindow = new ActiveClosingFrame("Exercise 11 - UI Scaling.")
		def main = initWindow.getActiveFrame()
		// Create suspend button.
		def suspendButton = new ActiveButton(null, suspend, "Suspend")
		
		def factorLabel = new Label("Old scaling factor: ")
		// Get factor value.
		def factorValue = new ActiveLabel(factor)	
		// Get inject value.
		def injectorLabel = new Label("Insert new factor:")
		def inText = new ActiveTextEnterField(null, injector)
		def outText = new ActiveTextArea(data, null)
		// Add all the buttons/ text fields to UI.
		def container = new Container()
		container.setLayout (new GridLayout(1,5))
		container.add(suspendButton)
		container.add(factorLabel)
		container.add(factorValue)
		container.add(injectorLabel)
		container.add(inText.getActiveTextField())
		// Set layout of UI.
		main.setLayout(new BorderLayout())
		main.add(outText, BorderLayout.CENTER)
		main.add(container, BorderLayout.NORTH)
		main.pack()
		main.setVisible(true)
		def network = [initWindow, factorValue, inText, outText, suspendButton]
		new PAR (network).run()
  }
}
