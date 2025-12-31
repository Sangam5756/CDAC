read n


a=0
b=1
c=0

for((i=0; i<n; i++))
do
	c=$((a+b))
	a=$b
	b=$c
done

echo "$c"
