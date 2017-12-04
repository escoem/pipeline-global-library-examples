// vars/pfunk.groovy

def foo() { 
   System.out.println(System.getenv("MY_VAR")); 
   
   println(System.getenv("MY_VAR"))
   
   echo(System.getenv("MY_VAR"))
   
   sh 'echo $MY_VAR'
   
   echo env.MY_VAR
}
