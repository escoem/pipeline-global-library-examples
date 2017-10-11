// vars/wswrapper.groovy
@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2') 

import wslite.soap.*; 
import wslite.*; 


@NonCPS
def soapcall() {
  
  def myMessage="<?xml version='1.0' encoding='UTF-8'?>"+"\n"
	    myMessage= myMessage+"<soap-env:Envelope xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'>"+"\n"
	    myMessage= myMessage+"<soap-env:Body>"+"\n"
      myMessage= myMessage+"<GetWeather xmlns='http://www.webserviceX.NET'>"+"\n"
	    myMessage= myMessage+"<CityName>Paris</CityName>"+"\n"
	    myMessage= myMessage+"<CountryName>France</CountryName>"+"\n"
      myMessage= myMessage+"</soap-env:Body>"+"\n"
      myMessage= myMessage+"</soap-env:Envelope>"+"\n"
       
  def client = new SOAPClient('http://www.webservicex.com/globalweather.asmx')
	def response = client.send(message)
     
	return response.text
}

