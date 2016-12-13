@Grab('org.apache.httpcomponents:httpclient:4.5.2')

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;

def call(steps, String restURL){

  CloseableHttpClient httpclient = HttpClients.createDefault();
  HttpGet httpget = new HttpGet(restURL);
  CloseableHttpResponse response = httpclient.execute(httpget);
  try {
    def line = response.getStatusLine()
    steps.echo line
  } finally {
    response.close();
  }
}

