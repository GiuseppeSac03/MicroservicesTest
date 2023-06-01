command="cd .."
echo $command
$command

command="mvn clean compile package"
echo $command
$command

command="docker build -t ibm-cloud-academy/num-generator:v1 ."
echo $command
$command

read -n 1 -s -r -p "Press any key to continue"