package org.foo.shared;

//Class for the object for jobinfo.groovy
public class JobNameInfo implements Serializable {
  final String remotePath;
  final String jobUrl;
  public JobNameInfo(String remotePathParam, String jobURLParam){
    this.remotePath = remotePathParam;
    this.jobUrl = jobURLParam;
  }

  /**Get the remote path for trigger remote and copy artifact remote*/
  public String getRemotePath(){
    return remotePath;
  }
  /**Get the jenkins job url */
  public String getJobURL(){
    return jobURL;
  }
  /**GEt the short job name without folder full path */
  public String getShortName(){
    int index = remotePath.lastIndexOf("/");
    if(index != -1){
      return remotePath.substring(index);
    }else{
      return remotePath;
    }
  }
}
