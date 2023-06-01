command="cd .."
echo $command
$command

command="cd hystrix-dashboard"
echo $command
$command

command="mvn clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/hystrix-dashboard:v1 ."
echo $command
$command