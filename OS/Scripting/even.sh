read n1


ans=$((n1 % 2==0))
tput blink

if((ans));
then
tput setaf 1
echo "Even Number"
else 

echo "Odd Number"
fi


tput sgr0
