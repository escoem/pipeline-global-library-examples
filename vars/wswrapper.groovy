// vars/wswrapper.groovy
@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2') 

import wslite.soap.*; 
import wslite.*; 

def call() {
  
  String str = "ERROR"
  
	try {
		/*
  def myMessage="<?xml version='1.0' encoding='UTF-8'?>\\n"
	    myMessage= myMessage+"<soap-env:Envelope xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'>\\n"
	    myMessage= myMessage+"<soap-env:Body>\\n"
      myMessage= myMessage+"<GetWeather xmlns='http://www.webserviceX.NET'>\\n"
	    myMessage= myMessage+"<CityName>Paris</CityName>\\n"
	    myMessage= myMessage+"<CountryName>France</CountryName>\\n"
      myMessage= myMessage+"</soap-env:Body>\\n"
      myMessage= myMessage+"</soap-env:Envelope>\\n"
*/
  //def myMessage="<?xml version='1.0' encoding='UTF-8'?><soap-env:Envelope xmlns:SOAP='http://schemas.xmlsoap.org/soap/envelope/'><soap-env:Body><GetWeather xmlns='http://www.webserviceX.NET'><CityName>Paris</CityName><CountryName>France</CountryName></soap-env:Body></soap-env:Envelope>"
		
  def myMessage='''<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <GetWeather xmlns="http://www.webserviceX.NET">
      <CityName>Paris</CityName>
      <CountryName>France</CountryName>
    </GetWeather>
  </soap:Body>
</soap:Envelope>
'''		
		
  def client = new SOAPClient('http://www.webservicex.com/globalweather.asmx')
	def response = client.send(myMessage)
		str = new String(response.text)
	} catch (err) {
		str = "ERR: " + err
	}
		
	
	return str
}

