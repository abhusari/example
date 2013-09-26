package org.anupam.test.security;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.soap.Fault;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;
import org.apache.soap.transport.http.SOAPHTTPConnection;

//import org.apache.axis.client.Call; 

public class HelloService {
      public static void main (String[] args) 
     throws Exception {

  System.out.println("\n\nCalling the SOAP Server to say hello\n\n");       
  URL url = new URL ("http://10.21.136.137:8084/soap");
  String login = "LOGIN";
  Map datamap = new HashMap();
  datamap.put("action", "LOGIN");
  Call call = new Call();
  call.setTargetObjectURI("http://10.21.136.137:8084/NicToolServer/SOAP");
  call.setMethodName("LOGIN");
  call.setEncodingStyleURI("http://schemas.xmlsoap.org/soap/encoding/");
  Vector params = new Vector();  
  //params.addElement(new Parameter("action", Map.class, datamap, null));
  call.setParams(params);
  call.setSOAPTransport(new SOAPHTTPConnection());
  System.out.print("The SOAP Server says:");
  Response resp = call.invoke(url,"");

  if (resp.generatedFault())
  {
    Fault fault = resp.getFault();
    System.out.println ("\nOuch, the call failed: ");
    System.out.println ("  Fault Code   = " + fault.getFaultCode());
    System.out.println ("  Fault String = " + fault.getFaultString());
  } else {
    Parameter result = resp.getReturnValue();
    System.out.print(result.getValue());
    System.out.println();
  }
}


}


