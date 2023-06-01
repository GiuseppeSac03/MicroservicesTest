command="cd .."
echo $command
$command

command="cd cloud-service"
echo $command
$command

command="mvn clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/cloud-service:v1 ."
echo $command
$command