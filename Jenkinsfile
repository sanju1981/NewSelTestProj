node {

stage('SCM Checkout')
{
  git 'https://github.com/sanju1981/NewSelTestProj'
}
stage('compile-package')
{
  def mvnval = tool name: 'M2_HOME', type: 'maven'
  sh "{mvnval}/bin/mvn package"
  
 }

}
