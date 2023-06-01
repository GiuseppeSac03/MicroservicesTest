command="cd .."
echo $command
$command

command="docker-compose up -d --scale numeropari-service=2 --no-recreate --remove-orphans"
echo $command
$command