import groovy.transform.Field;
import org.foo.shared.JobNameInfo;

/**This file holds global string constants for jobs in jenkins
Contains the remotejob path, url and shortname in the JobNameInfo class

can access this in pipeilne by calling jobinfo.SEQ.getJobURL();
**/

@groovy.transform.Field m1InstanceID = "ej8139e98h31d9hr23r2r1"
@groovy.transform.Field m2InstanceID = "ej3189j1r93h2r892feihu"


@Field final JobNameInfo SEQ_FVT_PERSONAL = new JobNameInfo(
  "jenkins://${m1InstanceID}/seq/test/seq-fvt-personal",
  "http://127.0.0.1:9090/m1/job/seq/job/test/job/seq-fvt-personal"
);
@Field final JobNameInfo SEQ_PERSONAL = new JobNameInfo(
  "jenkins://${m1InstanceID}/seq/test/seq-personal",
  "http://127.0.0.1:9090/m1/job/seq/job/test/job/seq-personal"
);
@Field final JobNameInfo SEQ = new JobNameInfo(
  "jenkins://${m1InstanceID}/seq/build/seq",
  "http://127.0.0.1:9090/m1/job/seq/job/build/job/seq"
);
@Field final JobNameInfo SEQ_STAB = new JobNameInfo(
  "jenkins://${m1InstanceID}/seq/build-stab/seq-stab",
  "http://127.0.0.1:9090/m1/job/seq/job/build-stab/job/seq-stab"
);

@Field final JobNameInfo SS_SEQ_VBT = new JobNameInfo(
  "jenkins://${m2InstanceID}/Uni/SupportingJobs/SS - seq VBT",
  "http://127.0.0.1:9090/m2/job/Uni/job/SupportingJobs/job/Self%20Service%20-%20seq%20VBT/"
);
@Field final JobNameInfo SS_SEQ_VBT_LOOP = new JobNameInfo(
  "jenkins://${m2InstanceID}/Uni/SupportingJobs/SS - seq VBT Loop",
  "http://127.0.0.1:9090/m2/job/Uni/job/SupportingJobs/view/SS/job/SS%20-%20seq%20VBT%20Loop/"
);
@Field final JobNameInfo SS_RETURN_KARPOF = new JobNameInfo(
  "jenkins://${m2InstanceID}/Uni/SupportingJobs/SS Return Karpof",
  "http://127.0.0.1:9090/m2/job/Uni/job/SupportingJobs/view/SS/job/SS%20Return%20Karpof/"
);
@Field final JobNameInfo SSE_DEPLOY_KARPOF = new JobNameInfo(
  "jenkins://${m2InstanceID}/Uni/SupportingJobs/SS Deploy Karpof",
  "http://127.0.0.1:9090/m2/job/Uni/job/SupportingJobs/job/SS%20Deploy%20Karpof/"
);
@Field final JobNameInfo FIND_DUPLICATED_ISSUES = new JobNameInfo(
  "jenkins://${m2InstanceID}/Admin/Admin Find Duplicated issues",
  "http://127.0.0.1:9090/m2/job/Admin/view/Tools/job/Admin%20Find%20Duplicated%20issues/"
);
