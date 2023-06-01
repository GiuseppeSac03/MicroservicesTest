while true
do 
  curl --connect-timeout 1 -s 'http://localhost:8091/random'
  sleep 1;
  echo
done
